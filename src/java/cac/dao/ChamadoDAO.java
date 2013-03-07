/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.dao;

import cac.classes.ConverteData;
import cac.db.DataBase;
import cac.db.Chamado;
import cac.db.Escola;
import cac.db.Parecer;
import cac.db.Status;
import cac.db.Usuario;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author UhelberC
 */
public class ChamadoDAO {

    DataBase db;

    public ChamadoDAO() throws ClassNotFoundException, SQLException {
    }

    public boolean adicionarChamado(Chamado chmd, Usuario usr) throws ClassNotFoundException, SQLException {
        this.db = new DataBase();

        PreparedStatement ps = (PreparedStatement) db.getPreparedStatement("INSERT INTO NTE.chamado VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        Date dt = new Date();
        SimpleDateFormat frmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        boolean retorno = false;

        if (chmd.getEscola() != null) {
            ps.setString(1, null);
            ps.setInt(2, chmd.getEscola().getIdescola());
            ps.setString(3, chmd.getContato());
            ps.setString(4, chmd.getTelefone());
            ps.setString(5, chmd.getTelefone2());
            ps.setInt(6, 4);
            ps.setString(7, chmd.getDescricao());
            ps.setInt(8, usr.getIdusuarios());
            ps.setString(9, frmt.format(dt));
            ps.setString(10, null);

            retorno = ps.execute();
        }

        ps.close();
        db.getCon().close();

        return retorno;
    }

    public boolean atualizarChamado(Chamado chmd, Parecer parecer, Usuario usr) throws ClassNotFoundException, SQLException {
        this.db = new DataBase();
        ParecerDAO prcrDAO = new ParecerDAO();

        PreparedStatement ps = (PreparedStatement) db.getPreparedStatement("UPDATE NTE.chamado SET contato = ?, telefone = ?, telefone2 = ?, status = ?, tecnico = ? WHERE idchamado = ?");

        ps.setString(1, chmd.getContato());
        ps.setString(2, chmd.getTelefone());
        ps.setString(3, chmd.getTelefone2());
        ps.setInt(4, chmd.getStatus().getIdstatus());
        ps.setInt(5, chmd.getTecnico().getIdusuarios());
        ps.setInt(6, chmd.getIdchamado());

        prcrDAO.adicionarParecer(chmd, parecer, usr);

        boolean retorno = ps.execute();
        ps.close();
        db.getCon().close();

        return retorno;
    }

    public List<Chamado> getTodosChamados(Usuario usr, String tipo) throws ClassNotFoundException, SQLException {
        this.db = new DataBase();
        String org = "";
        String organizar = null;

        if (tipo == null) {
            if (organizar == null || organizar.equals("")) {
                org = " WHERE status <> '7' ORDER BY status, dataabertura";
            } 
        } else if (tipo.equals("finalizado")) {
            org = " WHERE status = '7' ORDER BY status, dataabertura";
            
        }


        List<Chamado> chamado = new LinkedList<Chamado>();
        ResultSet rs = this.db.getStatement().executeQuery("SELECT * FROM nte.chamado" + org);
        while (rs.next()) {
            Chamado chmd = new Chamado();
            polularListaChamado(chmd, rs);
            if (usr.getPermissao().getIdpermissao() != 3) {
                if (usr.getSetor().getIdsetor() == chmd.getEscola().getRegional().getSetor().getIdsetor()) {
                    chamado.add(chmd);
                }
            } else {
                chamado.add(chmd);
            }
        }
        rs.close();
        db.getCon().close();

        return chamado;
    }

    private void polularListaChamado(Chamado chmd, ResultSet rs) throws SQLException, ClassNotFoundException {
        ConverteData cDT = new ConverteData();

        UsuarioDAO usrDAO = new UsuarioDAO();
        Usuario usr = usrDAO.getPorIdUsuario(rs.getInt("abertopor"));

        Usuario tecnico = usrDAO.getPorIdUsuario(rs.getInt("tecnico"));

        StatusDAO stsDAO = new StatusDAO();
        Status sts = stsDAO.getPorIdStatus(rs.getInt("status"));

        EscolaDAO escolaDAO = new EscolaDAO();
        Escola escola = escolaDAO.getPorIdEscola(rs.getInt("escola"));

        chmd.setIdchamado(rs.getInt("idchamado"));
        chmd.setEscola(escola);
        chmd.setContato(rs.getString("contato"));
        chmd.setTelefone(rs.getString("telefone"));
        chmd.setTelefone2(rs.getString("telefone2"));
        chmd.setStatus(sts);
        chmd.setDescricao(rs.getString("descricao"));
        chmd.setAbertopor(rs.getInt("abertopor"));
        chmd.setDataabertura(cDT.clu_Data(rs.getString("dataabertura")));
        chmd.setTecnico(tecnico);

        if (sts.getIdstatus() == 1) {
            chmd.setImagem("/imagens/alerta1.2.png");
        }
        if (sts.getIdstatus() == 2) {
            chmd.setImagem("/imagens/alerta2.2.png");
        }
        if ((sts.getIdstatus() == 3) || (sts.getIdstatus() == 5) || (sts.getIdstatus() == 6)) {
            chmd.setImagem("/imagens/alerta3.2.png");
        }
        if (sts.getIdstatus() == 4) {
            chmd.setImagem("/imagens/alerta4.2.png");
        }
        if (sts.getIdstatus() == 7) {
            chmd.setImagem("/imagens/alerta5.2.png");
        }

    }

    public Chamado getPorIdChamado(int id) throws ClassNotFoundException, SQLException {
        this.db = new DataBase();
        ConverteData cDT = new ConverteData();

        PreparedStatement ps = (PreparedStatement) db.getPreparedStatement("SELECT * FROM NTE.chamado WHERE 'idchamado' = ?");
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        Chamado chmd = new Chamado();
        
        if(rs.next()){
            polularListaChamado(chmd, rs);
        }
        
        
        ps.close();
        rs.close();
        this.db.getCon().close();

        return chmd;
    }

    public Chamado getPorIdEscola(int id) throws ClassNotFoundException, SQLException {
        this.db = new DataBase();
        ConverteData cDT = new ConverteData();

        PreparedStatement ps = (PreparedStatement) db.getPreparedStatement("SELECT * FROM NTE.chamado WHERE escola = ?");
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        Chamado chmd = new Chamado();

        if (rs.next()) {
            polularListaChamado(chmd, rs);
            
        }

        rs.close();
        ps.close();

        this.db.getCon().close();

        return chmd;
    }

    public Chamado verificarExisteChamadoAberto(Escola escola) throws SQLException, ClassNotFoundException {
        this.db = new DataBase();
        
        PreparedStatement ps = (PreparedStatement) this.db.getPreparedStatement("SELECT * FROM nte.chamado WHERE status != 7 AND escola = ?");
        ps.setInt(1, escola.getIdescola());

        ResultSet rs = ps.executeQuery();
        
        Chamado novoCHMD = null;
            
        if(rs.next()){
            novoCHMD = new Chamado();
            polularListaChamado(novoCHMD, rs);
        }
        
        rs.close();
        ps.close();
        this.db.getCon().close();
        
        return novoCHMD;
    }
}
