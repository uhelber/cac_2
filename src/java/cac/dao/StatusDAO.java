/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.dao;

import cac.db.Chamado;
import cac.db.DataBase;
import cac.db.Status;
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
public class StatusDAO {

    DataBase db;
    private Status status;

    public StatusDAO() throws ClassNotFoundException, SQLException {
        this.status = new Status();
    }

    public Status getPorIdStatus(Integer id) throws ClassNotFoundException, SQLException {
        this.db = new DataBase();

        PreparedStatement ps = (PreparedStatement) db.getPreparedStatement("SELECT * FROM nte.status WHERE idstatus = ?");
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        Status sts = new Status();

        if (rs.next()) {
            polularListaStatus(sts, rs);
        }

        ps.close();
        rs.close();
        db.getCon().close();

        return sts;
    }

    public List<Status> getTodosStatus() throws ClassNotFoundException, SQLException {
        this.db = new DataBase();
        LinkedList<Status> status = new LinkedList<Status>();

        ResultSet rs = db.getStatement().executeQuery("SELECT * FROM nte.status");
        while (rs.next()) {
            Status stts = new Status();
            polularListaStatus(stts, rs);
            status.add(stts);
        }
        rs.close();
        db.getCon().close();

        return status;
    }

    public List<Status> getTodosStatusPorPermissao(Usuario usr, Chamado chmd) throws ClassNotFoundException, SQLException {
        this.db = new DataBase();
        LinkedList<Status> status = new LinkedList<Status>();

        if (usr.getPermissao().getIdpermissao() != 1) {
            ResultSet rs = db.getStatement().executeQuery("SELECT * FROM nte.status");
            while (rs.next()) {
                Status stts = new Status();
                polularListaStatus(stts, rs);
                status.add(stts);
            }
            rs.close();
        }else{
            status.add(this.getPorIdStatus(chmd.getStatus().getIdstatus()));
        }

        db.getCon().close();

        return status;
    }

    private void polularListaStatus(Status stts, ResultSet rs) throws SQLException, ClassNotFoundException {
        stts.setIdstatus(rs.getInt("idstatus"));
        stts.setNome(rs.getString("nome"));
    }
}
