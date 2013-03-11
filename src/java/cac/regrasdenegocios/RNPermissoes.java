/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.regrasdenegocios;

import cac.dao.PermissaoDAO;
import cac.db.Permissao;
import cac.db.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author UhelberC
 */
public class RNPermissoes {

    private Connection cnx;

    public RNPermissoes(Connection cnx) {
        this.cnx = cnx;
    }

    public List<Permissao> listarTodosPermissoes(Usuario usuario) throws SQLException, ClassNotFoundException {
        List<Permissao> permissoes = new LinkedList<Permissao>();
        PermissaoDAO permissaoDAO = new PermissaoDAO(this.cnx);

        if (usuario.getNome() != null) {
            permissoes = (LinkedList<Permissao>) permissaoDAO.getTodosPermissoes(usuario);
        }
        return permissoes;

    }
}
