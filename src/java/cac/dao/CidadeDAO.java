/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.dao;

import cac.db.Cidade;
import cac.db.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author UhelberC
 */
public class CidadeDAO {

    private DataBase db;
    private Connection cnx;

    public CidadeDAO(Connection cnx) throws ClassNotFoundException, SQLException {
        //this.db = new DataBase();
        this.cnx = cnx;
    }

    public CidadeDAO() throws SQLException, ClassNotFoundException {
        this.db = new DataBase();
        this.cnx = this.db.getCon();
    }

    public DataBase getDb() {
        return db;
    }

    public void setDb(DataBase db) {
        this.db = db;
    }
    
    public List<Cidade> getTodosCidades() throws ClassNotFoundException, SQLException {
        //this.db = new DataBase();

        List<Cidade> cidade = new LinkedList<Cidade>();
        //ResultSet rs = this.db.getStatement().executeQuery("SELECT * FROM nte.cidades");
        Statement stmt = this.cnx.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM nte.cidades");
        
        while (rs.next()) {
            Cidade cdd = new Cidade();
            polularListaCidade(cdd, rs);
            cidade.add(cdd);
        }
        
        rs.close();
        stmt.close();
        //this.db.getCon().close();

        return cidade;
    }

    private void polularListaCidade(Cidade cidade, ResultSet rs) throws SQLException, ClassNotFoundException {
        cidade.setIdcidade(rs.getInt("idcidades"));
        cidade.setNome(rs.getString("nome"));
    }

    public Cidade getPorIdCidade(int id) throws ClassNotFoundException, SQLException {
        //this.db = new DataBase();
        
        //PreparedStatement ps = (PreparedStatement) this.db.getPreparedStatement("SELECT * FROM nte.cidades WHERE idcidades = ?");
        PreparedStatement ps = (PreparedStatement) this.cnx.prepareStatement("SELECT * FROM nte.cidades WHERE idcidades = ?");
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        
        Cidade cidade = new Cidade();
        if(rs.next()){
            polularListaCidade(cidade, rs);
        }
                
        ps.close();
        rs.close();
        //this.db.getCon().close();

        return cidade;
    }
}
