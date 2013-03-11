/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.bean;

import cac.classes.Mensagem;
import cac.db.Chamado;
import cac.db.DataBase;
import cac.db.Escola;
import cac.db.Usuario;
import cac.regrasdenegocios.RN_Chamados;
import cac.regrasdenegocios.RN_Usuarios;
import cac.regrasdenegocios.RegraNegocioException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author UhelberC
 */
@ManagedBean
@SessionScoped
public class GerenciadorBean implements Serializable {

    private Usuario usuarioLogado = new Usuario();
    private Usuario novoUsuario = new Usuario();
    private Chamado chamado = new Chamado();
    private DataBase db;
    private Mensagem msn;
    private String confirmarSenha;

    public GerenciadorBean() throws SQLException, ClassNotFoundException {
        this.db = new DataBase();
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public Usuario getNovoUsuario() {
        return novoUsuario;
    }

    public void setNovoUsuario(Usuario novoUsuario) {
        this.novoUsuario = novoUsuario;
    }

    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }

    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }

    /*
     * 
     * ==================================================================================================================
     *                                               Usuários
     * ==================================================================================================================
     * 
     */
    public String validarUsuario() throws ClassNotFoundException, SQLException {
        RN_Usuarios rnUsuario = new RN_Usuarios(this.db.getCon());

        String ir = "";

        try {
            rnUsuario.validarUsuario(this.usuarioLogado);
            if (rnUsuario.getUsuario().getNome() != null) {
                this.usuarioLogado = rnUsuario.getUsuario();
                ir = "listarchamados";
            } else {
                ir = "index";
            }
        } catch (RegraNegocioException ex) {
            this.msn = new Mensagem();
            this.msn.EviarMensagens("frm:aviso", FacesMessage.SEVERITY_ERROR, "Erro na autenticação...", ex.getMessage());
        }

        return ir;
    }

    public List<Usuario> listarTodosUsuarios() throws ClassNotFoundException, SQLException {
        RN_Usuarios rnUsuarios = new RN_Usuarios(this.db.getCon());
        
        return  rnUsuarios.listarTodosUsuarios(this.usuarioLogado);
    }

    /*
     * 
     * ==================================================================================================================
     *                                               Chamdos
     * ==================================================================================================================
     * 
     */
    public List<Chamado> listarTodosChamados() throws ClassNotFoundException, SQLException {
        RN_Chamados rnChamados = new RN_Chamados(this.db.getCon());

        return rnChamados.listarTodosChamados(this.usuarioLogado, this.chamado, null);
    }

    public List<Chamado> listarTodosChamadosFinalizados() throws ClassNotFoundException, SQLException {
        RN_Chamados rnChamados = new RN_Chamados(this.db.getCon());

        return rnChamados.listarTodosChamados(this.usuarioLogado, this.chamado, "Finalizado");
    }

    /*
     * 
     * ==================================================================================================================
     *                                               Sistema
     * ==================================================================================================================
     * 
     */
    public String sair() throws SQLException, ClassNotFoundException {
        this.usuarioLogado = new Usuario();

        DataBase db = new DataBase();
        db.fecherTudo();

        return "index";
    }
}
