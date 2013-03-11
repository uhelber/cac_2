/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.regrasdenegocios;

import cac.dao.UsuarioDAO;
import cac.db.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author UhelberC
 */
public class RN_Usuarios {

    private Usuario usuario = null;
    private Connection cnx;

    public RN_Usuarios(Connection cnx) {
        this.cnx = cnx;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void validarUsuario(Usuario usuario) throws ClassNotFoundException, SQLException, RegraNegocioException {
        UsuarioDAO usuarioDAO = new UsuarioDAO(this.cnx);

        if (usuario != null) {
            Usuario nUsuario = usuarioDAO.validarUsuario(usuario.getUsuario(), usuario.getSenha());

            if (nUsuario != null) {
                if (nUsuario.getAtivarconta().getIdativarconta() == 2) {
                    this.usuario = new Usuario();
                    this.usuario = nUsuario;
                } else {
                    throw new RegraNegocioException("Conta destivada pelo administrador.");
                }
            } else {
                throw new RegraNegocioException("Verifique se o usuario e senha estão certos.");
            }
        } else {
            throw new RegraNegocioException("Por favor, insira seu usuário e senha");
        }
    }
/*
    public String alterarUsuario(Usuario usuario) throws ClassNotFoundException, SQLException {
        String ir = "";

        this.novoUsr.setCadastrador(this.usr.getIdusuarios());

        if (this.usr.getNome() != null) {
            if (this.novoUsr.getSenha().equals(this.confirmarSenha)) {
                this.usrDAO.alterarUsuario(this.novoUsr);
                msn.EviarMensagens("", FacesMessage.SEVERITY_INFO, "Dados atualizados com sucesso...", "");
                ir = "editarusuario";
            } else {
                msn.EviarMensagens("frm:senha", FacesMessage.SEVERITY_ERROR, "", "Senhas não coincidem, tente outra vez...");
                ir = "cadastrarusuario";
            }
        } else {
            msn.EviarMensagens("frm:aviso", FacesMessage.SEVERITY_ERROR, "Erro na autenticação...", "Por favor, efetue login no sistema. Obrigado...");
            ir = "index";
        }

        return ir;
    }
*/
    public List<Usuario> listarTodosUsuarios(Usuario usuario) throws SQLException, ClassNotFoundException {
        UsuarioDAO usuarioDAO = new UsuarioDAO(this.cnx);
        List<Usuario> usuarios = new LinkedList<Usuario>();

        if (usuario != null) {
            if (usuario.getPermissao().getIdpermissao() != 1) {
                usuarios = (LinkedList<Usuario>) usuarioDAO.getTodosUsuarios(usuario);
            } else {
                usuarios = null;
            }
        }
        
        return usuarios;
    }
}
