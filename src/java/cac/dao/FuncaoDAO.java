/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.dao;

import cac.db.DataBase;
import cac.db.Funcao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author UhelberC
 */
public class FuncaoDAO {

    DataBase db;
    
    public FuncaoDAO(){
    }

    public Funcao getPorIdFuncao(Integer id) throws ClassNotFoundException, SQLException {
        this.db = new DataBase();

        PreparedStatement ps = (PreparedStatement) db.getPreparedStatement("SELECT * FROM nte.funcao WHERE idfuncao = ?");
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        Funcao funcao = new Funcao();

        if (rs.next()) {
            polularListaFuncao(funcao, rs);
        }

        ps.close();
        rs.close();
        db.getCon().close();

        return funcao;
    }

    public List<Funcao> getTodosFuncao() throws ClassNotFoundException, SQLException {
        this.db = new DataBase();
        List<Funcao> funcao = new LinkedList<Funcao>();

        ResultSet rs = db.getStatement().executeQuery("SELECT * FROM nte.funcao");
        while (rs.next()) {
            Funcao func = new Funcao();
            polularListaFuncao(func, rs);
            funcao.add(func);
        }
        rs.close();
        db.getCon().close();

        return funcao;
    }

    private void polularListaFuncao(Funcao funcao, ResultSet rs) throws SQLException, ClassNotFoundException {
        funcao.setIdfuncao(rs.getInt("idfuncao"));
        funcao.setNome(rs.getString("nome"));
    }
}
