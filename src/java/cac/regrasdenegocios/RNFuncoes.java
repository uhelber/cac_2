/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.regrasdenegocios;

import cac.dao.FuncaoDAO;
import cac.db.Funcao;
import cac.db.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author UhelberC
 */
public class RNFuncoes {
    private Connection cnx;

    public RNFuncoes(Connection cnx) {
        this.cnx = cnx;
    }
    
    public List<Funcao> listarTodosFuncaos(Usuario usuario) throws SQLException, ClassNotFoundException {
        List<Funcao> funcoes = new LinkedList<Funcao>();
        FuncaoDAO funcaoDAO = new FuncaoDAO(this.cnx);

        if (usuario.getNome() != null) {
            funcoes = (LinkedList<Funcao>) funcaoDAO.getTodosFuncao();
        }
        return funcoes;

    }
}
