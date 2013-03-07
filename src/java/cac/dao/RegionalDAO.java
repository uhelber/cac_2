/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.dao;

import cac.db.DataBase;
import cac.db.Regional;
import cac.db.Setor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author UhelberC
 */
public class RegionalDAO {

    DataBase db;

    public RegionalDAO() throws ClassNotFoundException, SQLException {
    }

    public List<Regional> getTodosRegionais() throws ClassNotFoundException, SQLException {
        this.db = new DataBase();

        List<Regional> regional = new LinkedList<Regional>();
        ResultSet rs = this.db.getStatement().executeQuery("SELECT * FROM nte.regional");
        while (rs.next()) {
            Regional rgnl = new Regional();
            polularListaRegional(rgnl, rs);
            regional.add(rgnl);
        }
        rs.close();
        db.getCon().close();

        return regional;
    }

    private void polularListaRegional(Regional regional, ResultSet rs) throws SQLException, ClassNotFoundException {
        SetorDAO setorDAO = new SetorDAO();
        Setor setor = setorDAO.getPorIdSetor(rs.getInt("setor"));

        regional.setIdregional(rs.getInt("idregional"));
        regional.setNome(rs.getString("nome"));
        regional.setSetor(setor);
    }

    public Regional getPorIdRegional(int id) throws ClassNotFoundException, SQLException {
        this.db = new DataBase();

        PreparedStatement ps = (PreparedStatement) db.getPreparedStatement("SELECT * FROM nte.regional WHERE idregional = ?");
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        Regional regional = new Regional();
        if (rs.next()) {
            polularListaRegional(regional, rs);
        }

        ps.close();
        rs.close();
        this.db.getCon().close();

        return regional;
    }
}
