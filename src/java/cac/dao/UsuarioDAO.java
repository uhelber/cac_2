/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.dao;

import cac.classes.ConverteData;
import cac.classes.Mensagem;
import cac.db.AtivarConta;
import cac.db.DataBase;
import cac.db.Funcao;
import cac.db.Permissao;
import cac.db.Setor;
import cac.db.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import javax.faces.application.FacesMessage;

/**
 *
 * @author UhelberC
 */
public class UsuarioDAO {

    DataBase db;

    public UsuarioDAO() throws ClassNotFoundException, SQLException {
    }
    private String campoIdUsuario;
    private String campoUsuario;
    private String campoSenha;

    public String getCampoIdUsuario() {
        return campoIdUsuario;
    }

    public String getCampoUsuario() {
        return campoUsuario;
    }

    public String getCampoSenha() {
        return campoSenha;
    }

    public boolean adicionarUsuario(Usuario usr) throws ClassNotFoundException, SQLException {
        this.db = new DataBase();
        ConverteData cDT = new ConverteData();

        Date dt = new Date(System.currentTimeMillis());
        SimpleDateFormat frmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        DateFormat dt_nasc = new SimpleDateFormat("yyyy-MM-dd");

        PreparedStatement ps = (PreparedStatement) db.getPreparedStatement("INSERT INTO NTE.USUARIOS VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        ps.setString(1, null);
        ps.setString(2, usr.getNome());
        ps.setString(3, usr.getSobrenome());
        ps.setInt(4, usr.getSetor().getIdsetor());
        ps.setInt(5, usr.getFuncao().getIdfuncao());
        ps.setString(6, dt_nasc.format(usr.getDatanascimento()));
        ps.setString(7, frmt.format(dt));
        ps.setInt(8, usr.getCadastrador());
        ps.setString(9, usr.getTelefone());
        ps.setString(10, usr.getMatricula());
        ps.setString(11, usr.getUsuario());
        ps.setString(12, usr.getSenha());
        ps.setInt(13, usr.getPermissao().getIdpermissao());
        ps.setInt(14, 2);

        boolean retorno = ps.execute();
        ps.close();
        db.getCon().close();

        return retorno;
    }

    public boolean alterarUsuario(Usuario usr) throws ClassNotFoundException, SQLException {
        this.db = new DataBase();
        DateFormat dt_nasc = new SimpleDateFormat("yyyy-MM-dd");

        PreparedStatement ps = (PreparedStatement) db.getPreparedStatement("UPDATE NTE.USUARIOS SET nome = ?, sobrenome = ?, setor = ?, funcao = ?,"
                + " datanascimento = ?, cadastrador = ?, telefone = ?, matricula = ?, usuario = ?, senha = ?, permissao = ?, ativarconta = ? WHERE idusuarios = ?");

        ps.setString(1, usr.getNome());
        ps.setString(2, usr.getSobrenome());
        ps.setInt(3, usr.getSetor().getIdsetor());
        ps.setInt(4, usr.getFuncao().getIdfuncao());
        ps.setString(5, dt_nasc.format(usr.getDatanascimento()));
        ps.setInt(6, usr.getCadastrador());
        ps.setString(7, usr.getTelefone());
        ps.setString(8, usr.getMatricula());
        ps.setString(9, usr.getUsuario());
        ps.setString(10, usr.getSenha());
        ps.setInt(11, usr.getPermissao().getIdpermissao());
        ps.setInt(12, usr.getAtivarconta().getIdativarconta());
        ps.setInt(13, usr.getIdusuarios());

        boolean retorno = ps.execute();

        ps.close();
        db.getCon().close();

        return retorno;
    }

    public List<Usuario> getTodosUsuarios(Usuario usuario) throws ClassNotFoundException, SQLException {
        this.db = new DataBase();

        List<Usuario> usuarios = new LinkedList<Usuario>();
        List<Usuario> novosUsuarios = new LinkedList<Usuario>();

        ResultSet rs = db.getStatement().executeQuery("SELECT * FROM NTE.USUARIOS");
        while (rs.next()) {
            Usuario usr = new Usuario();
            polularListaUsuario(usr, rs);
            usuarios.add(usr);
        }

        for (int i = 0; i < usuarios.size(); i++) {
            if (usuario.getPermissao().getIdpermissao() != 3) {
                if (usuario.getPermissao().getIdpermissao() == 2) {
                    if (usuario.getSetor().getIdsetor() == usuarios.get(i).getSetor().getIdsetor()) {
                        novosUsuarios.add(usuarios.get(i));
                    }
                }
            } else {
                novosUsuarios.add(usuarios.get(i));
            }
        }

        rs.close();
        db.getCon().close();

        return novosUsuarios;
    }

    public List<Usuario> getTodosUsuariosAvancados(Usuario usuario) throws ClassNotFoundException, SQLException {
        this.db = new DataBase();

        List<Usuario> usuarios = new LinkedList<Usuario>();
        List<Usuario> novosUsuarios = new LinkedList<Usuario>();

        ResultSet rs = db.getStatement().executeQuery("SELECT * FROM NTE.USUARIOS WHERE permissao != 1 && idusuarios != 1");

        while (rs.next()) {
            Usuario usr = new Usuario();
            polularListaUsuario(usr, rs);
            usuarios.add(usr);
        }

        for (int i = 0; i < usuarios.size(); i++) {
            if (usuario.getPermissao().getIdpermissao() != 3) {
                if (usuario.getSetor().getIdsetor() == usuarios.get(i).getSetor().getIdsetor()) {
                    novosUsuarios.add(usuarios.get(i));
                }
            } else {
                novosUsuarios = usuarios;
            }
        }

        rs.close();
        db.getCon().close();

        return novosUsuarios;
    }

    private void polularListaUsuario(Usuario usr, ResultSet rs) throws SQLException, ClassNotFoundException {
        ConverteData cDT = new ConverteData();

        SetorDAO setorDAO = new SetorDAO();
        Setor setor = setorDAO.getPorIdSetor(rs.getInt("setor"));

        FuncaoDAO funcaoDAO = new FuncaoDAO();
        Funcao funcao = funcaoDAO.getPorIdFuncao(rs.getInt("funcao"));

        PermissaoDAO permissaoDAO = new PermissaoDAO();
        Permissao permissao = permissaoDAO.getPorIdPermissao(rs.getInt("permissao"));

        AtivarContaDAO ativarcontaDAO = new AtivarContaDAO();
        AtivarConta ativarconta = ativarcontaDAO.getPorIdAtivarConta(rs.getInt("ativarconta"));

        usr.setIdusuarios(rs.getInt("idusuarios"));
        usr.setNome(rs.getString("nome"));
        usr.setSobrenome(rs.getString("sobrenome"));
        usr.setSetor(setor);
        usr.setFuncao(funcao);
        usr.setDatanascimento(rs.getDate("datanascimento"));
        usr.setDatacadastro(cDT.clu_Data(rs.getString("datacadastro")));
        usr.setCadastrador(rs.getInt("cadastrador"));
        usr.setTelefone(rs.getString("telefone"));
        usr.setMatricula(rs.getString("matricula"));
        usr.setUsuario(rs.getString("usuario"));
        usr.setSenha(rs.getString("senha"));
        usr.setPermissao(permissao);
        usr.setAtivarconta(ativarconta);
    }

    public Usuario validarUsuario(String usuario, String senha) throws ClassNotFoundException, SQLException {
        this.db = new DataBase();
        Usuario usr = null;

        if ((!usuario.equals("")) && (!senha.equals(""))) {
            PreparedStatement ps = (PreparedStatement) db.getPreparedStatement("SELECT * FROM NTE.USUARIOS WHERE USUARIO = ? AND SENHA = ?");
            ps.setString(1, usuario);
            ps.setString(2, senha);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                usr = new Usuario();
                polularListaUsuario(usr, rs);

            }

            ps.close();
            rs.close();
        }

        db.getCon().close();

        return usr;
    }

    public Usuario getPorIdUsuario(int id) throws ClassNotFoundException, SQLException {
        this.db = new DataBase();

        PreparedStatement ps = (PreparedStatement) db.getPreparedStatement("SELECT * FROM NTE.USUARIOS WHERE idusuarios = ?");
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        Usuario usr = new Usuario();

        if (rs.next()) {
            polularListaUsuario(usr, rs);
        }

        ps.close();
        rs.close();
        db.getCon().close();

        return usr;
    }

    public Integer verificarUsuarioJaCadastrado(Usuario usr) throws ClassNotFoundException, SQLException {
        this.db = new DataBase();
        Mensagem msn = new Mensagem();
        Integer ir;

        PreparedStatement ps = (PreparedStatement) this.db.getPreparedStatement("SELECT * FROM NTE.USUARIOS"
                + " WHERE usuario = ?");
        ps.setString(1, usr.getUsuario());

        ResultSet rs = ps.executeQuery();
        rs.last();

        if (rs.getRow() == 0) {
            this.adicionarUsuario(usr);
            msn.EviarMensagens("", FacesMessage.SEVERITY_INFO, "Usuário cadastrado com sucesso...", "");
            ir = 0;
        } else {
            msn.EviarMensagens("", FacesMessage.SEVERITY_ERROR, "Já existe outro usuário com esse login...", "");
            ir = 1;
        }

        rs.close();
        ps.close();
        this.db.getCon().close();

        return ir;
    }
}
