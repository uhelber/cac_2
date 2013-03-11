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
public class RNUsuarios {

    private Usuario usuario = null;
    private Connection cnx;
    private int cadastro;

    public RNUsuarios(Connection cnx) {
        this.cnx = cnx;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getCadastro() {
        return cadastro;
    }

    public void setCadastro(int cadastro) {
        this.cadastro = cadastro;
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

    public void cadastrarUsuario(Usuario usuarioLogado, Usuario novoUsuario, String confirmarSenha) throws ClassNotFoundException, SQLException, RegraNegocioException {
        UsuarioDAO usuarioDAO = new UsuarioDAO(this.cnx);
        String ir = "";
        Integer teste;
        novoUsuario.setCadastrador(usuarioLogado.getIdusuarios());

        if (usuarioLogado.getNome() != null) {
            if (novoUsuario.getSenha().equals(confirmarSenha)) {
                teste = usuarioDAO.verificarUsuarioJaCadastrado(novoUsuario);
                if (teste == 0) {
                    this.cadastro = 0;
                    throw new RegraNegocioException("Usuário cadastrado com sucesso...");
                }
            } else {
                this.cadastro = 1;
                throw new RegraNegocioException("Senhas não coincidem, tente outra vez...");
            }
        } else {
            this.cadastro = 2;
            throw new RegraNegocioException("Por favor, efetue login no sistema. Obrigado...");
        }
    }

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
