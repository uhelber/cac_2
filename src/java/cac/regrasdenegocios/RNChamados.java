/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.regrasdenegocios;

import regrasdenegocios.*;
import cac.dao.ChamadoDAO;
import cac.db.Chamado;
import cac.db.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author UhelberC
 */
public class RNChamados {

    private ChamadoDAO chamadoDAO;
    private Chamado chamado;
    private Connection cnx;

    public RNChamados(Connection cnx) {
        this.cnx = cnx;
    }

    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }

    public String cadastrarChamados(Usuario usuario, Chamado chamado) throws ClassNotFoundException, SQLException {
        String ir = "";
        this.chamadoDAO = new ChamadoDAO(this.cnx);
        Chamado verificarChamado = this.chamadoDAO.verificarExisteChamadoAberto(chamado.getEscola());

        if (verificarChamado == null) {
            if (usuario.getNome() != null) {
                this.chamadoDAO.adicionarChamado(chamado, usuario);
                this.chamado = new Chamado();
                ir = "listarchamados";
            } else {
            }
        } else {
        }

        return ir;
    }

    public List<Chamado> listarTodosChamados(Usuario usuario, Chamado chamado, String tipoListarChamados) throws ClassNotFoundException, SQLException {
        List<Chamado> chamados = new LinkedList<Chamado>();
        this.chamadoDAO = new ChamadoDAO(this.cnx);

        if (usuario.getNome() != null) {
            chamados = (LinkedList<Chamado>) this.chamadoDAO.getTodosChamados(usuario, tipoListarChamados);
        }

        return chamados;
    }
    
    
}
