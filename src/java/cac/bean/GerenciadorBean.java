/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.bean;

import cac.classes.Mensagem;
import cac.db.Chamado;
import cac.db.Escola;
import cac.db.Usuario;
import cac.regrasdenegocios.RN_Chamados;
import cac.regrasdenegocios.RN_Usuarios;
import cac.regrasdenegocios.RegraNegocioException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author UhelberC
 */
@ManagedBean
@SessionScoped
public class GerenciadorBean implements Serializable{
    private Mensagem msn;
    private RN_Usuarios rnUsuario = new RN_Usuarios();
    private RN_Chamados rnChamados = new RN_Chamados();
    
    private Usuario usuarioLogado = new Usuario();
    private Chamado chamado = new Chamado();

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }
    
    public String validarUsuario() throws ClassNotFoundException, SQLException{
        String ir = "";
        
        try {
            this.rnUsuario.validarUsuario(this.usuarioLogado);
            if(this.rnUsuario.getUsuario().getNome() != null){
                this.usuarioLogado = this.rnUsuario.getUsuario();
                ir = "listarchamados";
            }else{
                ir = "index";
            }
        } catch (RegraNegocioException ex) {
            this.msn = new Mensagem();
            this.msn.EviarMensagens("frm:aviso", FacesMessage.SEVERITY_ERROR, "Erro na autenticação...", ex.getMessage());
        }
        
        return ir;
    }
    
    public List<Chamado> listarTodosChamados() throws ClassNotFoundException, SQLException{
        return this.rnChamados.listarTodosChamados(this.usuarioLogado, this.chamado, "");
    }
}
