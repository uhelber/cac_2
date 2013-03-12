/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.bean;

import cac.classes.Mensagem;
import cac.db.Chamado;
import cac.db.DataBase;
import cac.db.Escola;
import cac.db.Funcao;
import cac.db.Permissao;
import cac.db.Setor;
import cac.db.Usuario;
import cac.regrasdenegocios.RNChamados;
import cac.regrasdenegocios.RNFuncoes;
import cac.regrasdenegocios.RNPermissoes;
import cac.regrasdenegocios.RNSetores;
import cac.regrasdenegocios.RNUsuarios;
import cac.regrasdenegocios.RegraNegocioException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PreDestroy;
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
    private Escola escola = new Escola();
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

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    /*
     * 
     * ==================================================================================================================
     *                                               Usuários
     * ==================================================================================================================
     * 
     */
    public String validarUsuario() throws ClassNotFoundException, SQLException {
        RNUsuarios rnUsuario = new RNUsuarios(this.db.getCon());

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

    public String cadastrarUsuario() throws ClassNotFoundException, SQLException, RegraNegocioException {
        this.msn = new Mensagem();
        RNUsuarios rnUsuarios = new RNUsuarios(this.db.getCon());
        rnUsuarios.cadastrarUsuario(this.usuarioLogado, this.novoUsuario, this.confirmarSenha);
        String ir = "";

        try {
            if (rnUsuarios.getCadastro() == 0) {
                this.novoUsuario = new Usuario();
                ir = "cadastrarusuario";
            } else if (rnUsuarios.getCadastro() == 1) {
                ir = "cadastrarusuario";
            } else {
                ir = "index";
            }
        } catch (Exception e) {
            this.msn.EviarMensagens("", FacesMessage.SEVERITY_ERROR, e.getMessage(), "");
        }

        return null;
    }

    public List<Usuario> listarTodosUsuarios() throws ClassNotFoundException, SQLException {
        RNUsuarios rnUsuarios = new RNUsuarios(this.db.getCon());

        return rnUsuarios.listarTodosUsuarios(this.usuarioLogado);
    }

    /*
     * 
     * ==================================================================================================================
     *                                               Chamados
     * ==================================================================================================================
     * 
     */
    public List<Chamado> listarTodosChamados() throws ClassNotFoundException, SQLException {
        RNChamados rnChamados = new RNChamados(this.db.getCon());

        return rnChamados.listarTodosChamados(this.usuarioLogado, this.chamado, null);
    }

    public List<Chamado> listarTodosChamadosFinalizados() throws ClassNotFoundException, SQLException {
        RNChamados rnChamados = new RNChamados(this.db.getCon());

        return rnChamados.listarTodosChamados(this.usuarioLogado, this.chamado, "Finalizado");
    }

    /*
     * 
     * ==================================================================================================================
     *                                               Setores
     * ==================================================================================================================
     * 
     */
    public List<Setor> listarTodosSetores() throws SQLException, ClassNotFoundException {
        RNSetores rNSetores = new RNSetores(this.db.getCon());

        return rNSetores.listarTodosSetores(this.usuarioLogado);
    }

    /*
     * 
     * ==================================================================================================================
     *                                               Funções
     * ==================================================================================================================
     * 
     */
    public List<Funcao> listarTodosFuncoes() throws SQLException, ClassNotFoundException {
        RNFuncoes rNFuncoes = new RNFuncoes(this.db.getCon());

        return rNFuncoes.listarTodosFuncaos(this.usuarioLogado);
    }

    /*
     * 
     * ==================================================================================================================
     *                                               Permissões
     * ==================================================================================================================
     * 
     */
    public List<Permissao> listarTodosPermissoes() throws SQLException, ClassNotFoundException {
        RNPermissoes rNPermissoes = new RNPermissoes(this.db.getCon());

        return rNPermissoes.listarTodosPermissoes(this.usuarioLogado);
    }

    /*
     * 
     * ==================================================================================================================
     *                                               Sistema
     * ==================================================================================================================
     * 
     */
    @PreDestroy
    public void destroy() throws SQLException, ClassNotFoundException {
        this.usuarioLogado = new Usuario();
        this.db.fecherTudo();
    }
    
    public String sair() throws SQLException, ClassNotFoundException {
        this.usuarioLogado = new Usuario();
        this.db.fecherTudo();

        return "index";
    }

    public String irCadastrarUsuarios() {
        this.novoUsuario = new Usuario();

        return "cadastrarusuario";
    }
}
