/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.regrasdenegocios;

import cac.dao.SetorDAO;
import cac.db.Setor;
import cac.db.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author UhelberC
 */
public class RNSetores {
    private Connection cnx;

    public RNSetores(Connection cnx) {
        this.cnx = cnx;
    }
    
    public List<Setor> listarTodosSetores(Usuario usuario) throws SQLException, ClassNotFoundException {
        List<Setor> setores = new LinkedList<Setor>();
        SetorDAO setorDAO = new SetorDAO(this.cnx);
        
        if (usuario.getNome() != null) {
            setores = (LinkedList<Setor>) setorDAO.getTodosSetor(usuario);
        }
        return setores;

    }
}
