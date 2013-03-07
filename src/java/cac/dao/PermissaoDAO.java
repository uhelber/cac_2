/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.dao;

import cac.db.DataBase;
import cac.db.Funcao;
import cac.db.Permissao;
import cac.db.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author UhelberC
 */
public class PermissaoDAO{
    
    DataBase db;
    
    public PermissaoDAO() throws ClassNotFoundException, SQLException {
        
    }
    
    public Permissao getPorIdPermissao(Integer id) throws ClassNotFoundException, SQLException {
        this.db = new DataBase();
        
        PreparedStatement ps = (PreparedStatement) db.getPreparedStatement("SELECT * FROM nte.permissoes WHERE idpermissao = ?");
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        Permissao permissao = new Permissao();

        if (rs.next()) {
            permissao.setIdpermissao(rs.getInt("idpermissao"));
            permissao.setTipo(rs.getString("tipo"));
        }

        ps.close();
        rs.close();
        db.getCon().close();

        return permissao;
    }
    
    public List<Permissao> getTodosPermissoes(Usuario usr) throws ClassNotFoundException, SQLException {
        this.db = new DataBase();
        List<Permissao> permissao = new LinkedList<Permissao>();
        String pr = "";
        
        if(usr.getPermissao().getIdpermissao() == 1){
            pr = " WHERE idpermissao = 1";
        }
        else if(usr.getPermissao().getIdpermissao() == 2){
            pr = " WHERE idpermissao = 1 || idpermissao = 2";
        }
        
        
        ResultSet rs = db.getStatement().executeQuery("SELECT * FROM nte.permissoes"+pr+" ORDER BY tipo");
        while (rs.next()) {
            Permissao prmss = new Permissao();
            polularListaPermissao(prmss, rs);
            permissao.add(prmss);
        }
        rs.close();
        db.getCon().close();

        return permissao;
    }

    private void polularListaPermissao(Permissao permissao, ResultSet rs) throws SQLException, ClassNotFoundException {
        permissao.setIdpermissao(rs.getInt("idpermissao"));
        permissao.setTipo(rs.getString("tipo"));
    }
}
