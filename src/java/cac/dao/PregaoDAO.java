/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.dao;

import cac.db.DataBase;
import cac.db.Escola;
import cac.db.Pregao;
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
public class PregaoDAO {

    private DataBase db;
    private Connection cnx;

    public PregaoDAO(Connection cnx) throws ClassNotFoundException, SQLException {
        //this.db = new DataBase();
        this.cnx = cnx;
    }

    public PregaoDAO()  throws SQLException, ClassNotFoundException {
        this.db = new DataBase();
        this.cnx = this.db.getCon();
    }

    public DataBase getDb() {
        return db;
    }

    public void setDb(DataBase db) {
        this.db = db;
    }
    
    public List<Pregao> getTodosPregoes() throws ClassNotFoundException, SQLException {
        //this.db = new DataBase();

        List<Pregao> pregao = new LinkedList<Pregao>();
        //ResultSet rs = this.db.getStatement().executeQuery("SELECT * FROM nte.pregao");
        Statement stmt = this.cnx.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM nte.pregao");
        
        while (rs.next()) {
            Pregao lab = new Pregao();
            polularListaPregao(lab, rs);
            pregao.add(lab);
        }
        rs.close();
        stmt.close();
        //this.db.getCon().close();

        return pregao;
    }

    public List<Pregao> getTodosPregoesArray() throws ClassNotFoundException, SQLException {
        //this.db = new DataBase();
        List<Pregao> pregoes = new LinkedList<Pregao>();
        
        //ResultSet rs = this.db.getStatement().executeQuery("SELECT * FROM nte.pregao");
        Statement stmt = this.cnx.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM nte.pregao");
        
        while (rs.next()) {
            Pregao prg = new Pregao();
            polularListaPregao(prg, rs);
            pregoes.add(prg);
        }
        
        rs.close();
        stmt.close();
        //this.db.getCon().close();

        return pregoes;
    }

    public void polularListaPregao(Pregao pregao, ResultSet rs) throws SQLException, ClassNotFoundException {
        pregao.setIdpregao(rs.getInt("idpregao"));
        pregao.setPregao(rs.getString("pregao"));
        pregao.setContrato(rs.getString("contrato"));
    }

    public Pregao getPorIdPregao(int id) throws ClassNotFoundException, SQLException {
        //this.db = new DataBase();
        
        
        //PreparedStatement ps = (PreparedStatement) this.db.getPreparedStatement("SELECT * FROM nte.pregao WHERE idpregao = ?");
        PreparedStatement ps = (PreparedStatement) this.cnx.prepareStatement("SELECT * FROM nte.pregao WHERE idpregao = ?");
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        
        Pregao pregao = new Pregao();
        if(rs.next()){
            polularListaPregao(pregao, rs);
        }
                
        ps.close();
        rs.close();
        //this.db.getCon().close();

        return pregao;
    }
}
