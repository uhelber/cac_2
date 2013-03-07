/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.dao;

import cac.classes.ConverteData;
import cac.db.Chamado;
import cac.db.DataBase;
import cac.db.Parecer;
import cac.db.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author UhelberC
 */
public class ParecerDAO {

    DataBase db;

    public void adicionarParecer(Chamado chmd, Parecer parecer, Usuario usr) throws SQLException, ClassNotFoundException {
        this.db = new DataBase();

        PreparedStatement ps = (PreparedStatement) db.getPreparedStatement("INSERT INTO nte.parecer VALUE (?, ?, ?, ?, ?, ?)");

        Date dt = new Date();
        SimpleDateFormat frmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:s");

        if (!parecer.getParecer().equals("")) {
            ps.setString(1, null);
            ps.setInt(2, usr.getIdusuarios());
            ps.setString(3, frmt.format(dt));
            if (chmd.getStatus().getIdstatus() == 7) {
                ps.setString(4, frmt.format(dt));
            } else {
                ps.setString(4, null);
            }
            ps.setString(5, parecer.getParecer());
            ps.setInt(6, chmd.getIdchamado());

            ps.execute();
        }

        ps.close();
        db.getCon().close();
    }

    public List<Parecer> getTodosPareceres() throws ClassNotFoundException, SQLException {
        this.db = new DataBase();

        List<Parecer> parecer = new LinkedList<Parecer>();
        ResultSet rs = this.db.getStatement().executeQuery("SELECT * FROM NTE.parecer");

        while (rs.next()) {
            Parecer prcr = new Parecer();
            polularListaParecer(prcr, rs);
            parecer.add(prcr);
        }

        rs.close();
        this.db.getCon().close();

        return parecer;
    }

    public List<Parecer> getTodosPareceresPorIdChamado(int idChamado) throws SQLException, ClassNotFoundException {
        this.db = new DataBase();

        List<Parecer> parecer = new LinkedList<Parecer>();

        PreparedStatement ps = (PreparedStatement) this.db.getPreparedStatement("SELECT * FROM nte.parecer WHERE chamado = ?  ORDER BY dataatentimento DESC");
        ps.setInt(1, idChamado);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Parecer prcr = new Parecer();
            polularListaParecer(prcr, rs);
            parecer.add(prcr);
        }

        ps.close();
        rs.close();

        return parecer;
    }

    private void polularListaParecer(Parecer prcr, ResultSet rs) throws SQLException, ClassNotFoundException {
        UsuarioDAO usrDAO = new UsuarioDAO();
        ConverteData cDT = new ConverteData();

        prcr.setIdparecer(rs.getInt("idparecer"));
        prcr.setTecnico(usrDAO.getPorIdUsuario(rs.getInt("tecnico")));
        prcr.setDataatentimento(cDT.clu_Data(rs.getString("dataatentimento")));
        prcr.setDataconclusao(cDT.clu_Data(rs.getString("dataconclusao")));
        prcr.setParecer(rs.getString("parecer"));
        prcr.setChamado(rs.getInt("chamado"));

    }

    public Parecer getPorIdParecer(int id) throws ClassNotFoundException, SQLException, ParseException {
        this.db = new DataBase();

        PreparedStatement ps = (PreparedStatement) db.getPreparedStatement("SELECT * FROM NTE.parecer WHERE idparecer = ?");
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        Parecer parecer = new Parecer();
        UsuarioDAO usrDAO = new UsuarioDAO();

        parecer.setIdparecer(rs.getInt("idparecer"));
        parecer.setTecnico(usrDAO.getPorIdUsuario(rs.getInt("tecnico")));
        parecer.setDataatentimento(rs.getString("dataatentimento"));
        parecer.setDataconclusao(rs.getString("dataconclusao"));
        parecer.setParecer(rs.getString("parecer"));
        parecer.setChamado(rs.getInt("chamado"));

        ps.close();
        rs.close();
        db.getCon().close();

        return parecer;
    }

    public Parecer getParecerConclusaoPorIdChamado(int id) throws ClassNotFoundException, SQLException, ParseException {
        this.db = new DataBase();

        PreparedStatement ps = (PreparedStatement) db.getPreparedStatement("SELECT * FROM NTE.parecer WHERE dataconclusao != '' AND chamado = ?");
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        Parecer parecer = null;
        UsuarioDAO usrDAO = new UsuarioDAO();

        if (rs.next()) {
            parecer = new Parecer();
        
            
            parecer.setIdparecer(rs.getInt("idparecer"));
            parecer.setTecnico(usrDAO.getPorIdUsuario(rs.getInt("tecnico")));
            parecer.setDataatentimento(rs.getString("dataatentimento"));
            parecer.setDataconclusao(rs.getString("dataconclusao"));
            parecer.setParecer(rs.getString("parecer"));
            parecer.setChamado(rs.getInt("chamado"));
        }

        ps.close();
        rs.close();
        db.getCon().close();

        return parecer;
    }
}
