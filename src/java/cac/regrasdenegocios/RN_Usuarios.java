/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.regrasdenegocios;

import cac.dao.UsuarioDAO;
import cac.db.Usuario;
import java.sql.SQLException;

/**
 *
 * @author UhelberC
 */
public class RN_Usuarios {

    private UsuarioDAO usuarioDAO;
    private Usuario usuario = null;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    

    public void validarUsuario(Usuario usuario) throws ClassNotFoundException, SQLException, RegraNegocioException {
        this.usuarioDAO = new UsuarioDAO();
        Usuario validado = null;

        if (usuario != null) {
            Usuario nUsuario = this.usuarioDAO.validarUsuario(usuario.getUsuario(), usuario.getSenha());
            
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
}