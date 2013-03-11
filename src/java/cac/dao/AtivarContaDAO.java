/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.dao;

import cac.db.AtivarConta;
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
public class AtivarContaDAO {

    //private DataBase db;
    private Connection cnx;
    
    public AtivarContaDAO(Connection cnx) throws SQLException, ClassNotFoundException{
        //this.db = new DataBase();
        this.cnx = cnx;
    }

    public AtivarConta getPorIdAtivarConta(Integer id) throws ClassNotFoundException, SQLException {
        //this.db = new DataBase();

        //PreparedStatement ps = (PreparedStatement) this.db.getPreparedStatement("SELECT * FROM nte.ativarconta WHERE idativarconta = ?");
        PreparedStatement ps = (PreparedStatement) this.cnx.prepareStatement("SELECT * FROM nte.ativarconta WHERE idativarconta = ?");
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        AtivarConta ativarconta = new AtivarConta();

        if (rs.next()) {
            polularListaAtivarConta(ativarconta, rs);
        }

        rs.close();
        ps.close();
        //this.db.getCon().close();

        return ativarconta;
    }

    public List<AtivarConta> getTodosFuncao() throws ClassNotFoundException, SQLException {
        //this.db = new DataBase();
        List<AtivarConta> ativarconta = new LinkedList<AtivarConta>();

        //ResultSet rs = this.db.getStatement().executeQuery("SELECT * FROM nte.ativarconta");
        Statement stmt = this.cnx.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM nte.ativarconta");
        
        while (rs.next()) {
            AtivarConta atrvct = new AtivarConta();
            polularListaAtivarConta(atrvct, rs);
            ativarconta.add(atrvct);
        }
        rs.close();
        stmt.close();
        //this.db.getCon().close();

        return ativarconta;
    }

    private void polularListaAtivarConta(AtivarConta ativarconta, ResultSet rs) throws SQLException, ClassNotFoundException {
        ativarconta.setIdativarconta(rs.getInt("idativarconta"));
        ativarconta.setNome(rs.getString("nome"));
    }
}
