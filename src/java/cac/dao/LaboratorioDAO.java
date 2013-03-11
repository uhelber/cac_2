/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.dao;

import cac.db.DataBase;
import cac.db.Escola;
import cac.db.Laboratorio;
import cac.db.Pregao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author UhelberC
 */
public class LaboratorioDAO {

    //private DataBase db;
    private Connection cnx;

    public LaboratorioDAO(Connection cnx) throws SQLException, ClassNotFoundException {
        //this.db = new DataBase();
        this.cnx = cnx;
    }
    

    public boolean cadastrarLaboratorio(Escola escola, int indice) throws SQLException, ClassNotFoundException{
        //this.db = new DataBase();
        
        //PreparedStatement ps = (PreparedStatement) this.db.getPreparedStatement("INSERT INTO nte.laboratorio VALUE(?, ?, ?)");
        PreparedStatement ps = (PreparedStatement) this.cnx.prepareStatement("INSERT INTO nte.laboratorio VALUE(?, ?, ?)");
        boolean retorno = false;
        
        if(escola != null){
            ps.setString(1, null);
            ps.setInt(2, escola.getIdescola());
            ps.setInt(3, escola.getPregao()[indice].getIdpregao());
        }
        
        ps.close();
        //this.db.getCon().close();
        
        return retorno;
    }
    
    public List<Laboratorio> getTodosLaboratorios() throws ClassNotFoundException, SQLException {
        //this.db = new DataBase();

        List<Laboratorio> laboratorio = new LinkedList<Laboratorio>();
        //ResultSet rs = this.db.getStatement().executeQuery("SELECT * FROM nte.laboratorio");
        Statement stmt = this.cnx.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM nte.laboratorio");
        
        while (rs.next()) {
            Laboratorio lab = new Laboratorio();
            polularListaLaboratorio(lab, rs);
            laboratorio.add(lab);
        }
        rs.close();
        stmt.close();
        //this.db.getCon().close();

        return laboratorio;
    }

    public List<Pregao> getTodosPregoesPorIdEscola(Integer idEscola) throws ClassNotFoundException, SQLException {
        //this.db = new DataBase();
        
        List<Pregao> pregoes = new LinkedList<Pregao>();
        PregaoDAO pregaoDAO = new PregaoDAO(this.cnx);
        
        //PreparedStatement ps = (PreparedStatement) this.db.getPreparedStatement("SELECT * FROM nte.laboratorio WHERE escola = ?");
        PreparedStatement ps = (PreparedStatement) this.cnx.prepareStatement("SELECT * FROM nte.laboratorio WHERE escola = ?");
        ps.setInt(1, idEscola);
        
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Pregao pregao = new Pregao();
            pregao = pregaoDAO.getPorIdPregao(rs.getInt("pregao"));
            pregoes.add(pregao);
        }
        
        rs.close();
        //this.db.getCon().close();

        return pregoes;
    }

    private void polularListaLaboratorio(Laboratorio laboratorio, ResultSet rs) throws SQLException, ClassNotFoundException {
        PregaoDAO pregaoDAO = new PregaoDAO(this.cnx);
        Pregao pregao = pregaoDAO.getPorIdPregao(rs.getInt("pregao"));

        laboratorio.setIdlaboratorio(rs.getInt("idlaboratorio"));
        laboratorio.setPregao(pregao);
    }

    public Laboratorio getPorIdLaboratorio(int id) throws ClassNotFoundException, SQLException {
        //this.db = new DataBase();

        //PreparedStatement ps = (PreparedStatement) this.db.getPreparedStatement("SELECT * FROM nte.laboratorio WHERE idlaboratorio = ?");
        PreparedStatement ps = (PreparedStatement) this.cnx.prepareStatement("SELECT * FROM nte.laboratorio WHERE idlaboratorio = ?");
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        Laboratorio laboratorio = new Laboratorio();
        if (rs.next()) {
            polularListaLaboratorio(laboratorio, rs);
        }

        ps.close();
        rs.close();
        //this.db.getCon().close();

        return laboratorio;
    }

    public List<Laboratorio> getPorIdEscola(int id) throws ClassNotFoundException, SQLException {
        //this.db = new DataBase();
        List<Laboratorio> lab = new LinkedList<Laboratorio>();

        //PreparedStatement ps = (PreparedStatement) this.db.getPreparedStatement("SELECT * FROM nte.laboratorio WHERE idlaboratorio = ?");
        PreparedStatement ps = (PreparedStatement) this.cnx.prepareStatement("SELECT * FROM nte.laboratorio WHERE idlaboratorio = ?");
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Laboratorio laboratorio = new Laboratorio();
            polularListaLaboratorio(laboratorio, rs);
            lab.add(laboratorio);
        }

        ps.close();
        rs.close();
        //this.db.getCon().close();

        return lab;
    }
    
    public List<Laboratorio> converterPregaoEmLab(List<Pregao> pregao){
        List<Laboratorio> laboratorios = new LinkedList<Laboratorio>();
        
        for(int i = 0; i < pregao.size(); i++){
            Laboratorio lab = new Laboratorio();
            lab.setPregao(pregao.get(i));
            laboratorios.add(lab);
        }
        
        return laboratorios;
    }
}
