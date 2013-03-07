/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.dao;

import cac.db.Cidade;
import cac.db.DataBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author UhelberC
 */
public class CidadeDAO {

    DataBase db;

    public CidadeDAO() throws ClassNotFoundException, SQLException {
    }

    public List<Cidade> getTodosCidades() throws ClassNotFoundException, SQLException {
        this.db = new DataBase();

        List<Cidade> cidade = new LinkedList<Cidade>();
        ResultSet rs = this.db.getStatement().executeQuery("SELECT * FROM nte.cidades");
        while (rs.next()) {
            Cidade cdd = new Cidade();
            polularListaCidade(cdd, rs);
            cidade.add(cdd);
        }
        rs.close();
        db.getCon().close();

        return cidade;
    }

    private void polularListaCidade(Cidade cidade, ResultSet rs) throws SQLException, ClassNotFoundException {
        cidade.setIdcidade(rs.getInt("idcidades"));
        cidade.setNome(rs.getString("nome"));
    }

    public Cidade getPorIdCidade(int id) throws ClassNotFoundException, SQLException {
        this.db = new DataBase();
        
        
        PreparedStatement ps = (PreparedStatement) db.getPreparedStatement("SELECT * FROM nte.cidades WHERE idcidades = ?");
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        
        Cidade cidade = new Cidade();
        if(rs.next()){
            polularListaCidade(cidade, rs);
        }
                
        ps.close();
        rs.close();
        this.db.getCon().close();

        return cidade;
    }
}
