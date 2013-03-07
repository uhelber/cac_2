/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author UhelberC
 */
public class DataBase {
    
    private Connection con = null;
    
    private String usuario = "nte";
    private String senha = "nte";
    private String db = "nte";
    private String srv = "127.0.0.1:3306";

    public DataBase() throws SQLException, ClassNotFoundException{
        this.Conexao();
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public void Conexao() throws SQLException, ClassNotFoundException
    {
        if(this.con == null)
        {
            Class.forName("com.mysql.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://" + this.srv + "/" + this.db, this.usuario, this.senha);
        }
    }
    
    public Statement getStatement() throws ClassNotFoundException, SQLException
    {
        return this.con.createStatement();
    }
    
    public Statement getPreparedStatement(String sql) throws ClassNotFoundException, SQLException
    {
        return this.con.prepareStatement(sql);
    }
    
    public void fecherTudo() throws SQLException
    {
        if(this.con != null)
        {
            this.con.close();
        }
    }
}
