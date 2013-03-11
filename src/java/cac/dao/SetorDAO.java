/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.dao;

import cac.db.Cidade;
import cac.db.DataBase;
import cac.db.Setor;
import cac.db.Usuario;
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
public class SetorDAO {

    //private DataBase db;
    private Connection cnx;

    public SetorDAO(Connection cnx) throws SQLException, ClassNotFoundException {
        //this.db = new DataBase();
        this.cnx = cnx;
    }

    public Setor getPorIdSetor(Integer id) throws ClassNotFoundException, SQLException {
        //this.db = new DataBase();

        //PreparedStatement ps = (PreparedStatement) this.db.getPreparedStatement("SELECT * FROM nte.setor WHERE idsetor = ?");
        PreparedStatement ps = (PreparedStatement) this.cnx.prepareStatement("SELECT * FROM nte.setor WHERE idsetor = ?");
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        Setor setor = new Setor();

        if (rs.next()) {
            polularListaChamado(setor, rs);
        }

        ps.close();
        rs.close();
        //this.db.getCon().close();

        return setor;
    }

    public List<Setor> getTodosSetor(Usuario usuario) throws ClassNotFoundException, SQLException {
        //this.db = new DataBase();
        List<Setor> setor = new LinkedList<Setor>();
        List<Setor> novoSetor = new LinkedList<Setor>();

        //ResultSet rs = db.getStatement().executeQuery("SELECT * FROM nte.setor");
        Statement stmt = this.cnx.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM nte.setor");
                
        while (rs.next()) {
            Setor str = new Setor();
            polularListaChamado(str, rs);
            setor.add(str);
        }

        for (int i = 0; i < setor.size(); i++) {
            if (usuario.getPermissao().getIdpermissao() != 3) {
                if (usuario.getSetor().getIdsetor() == setor.get(i).getIdsetor()) {
                    novoSetor.add(setor.get(i));
                }
            } else {
                novoSetor.add(setor.get(i));
            }
        }

        rs.close();
        stmt.close();
        //this.db.getCon().close();

        return novoSetor;
    }

    private void polularListaChamado(Setor setor, ResultSet rs) throws SQLException, ClassNotFoundException {
        CidadeDAO cidadeDAO = new CidadeDAO(this.cnx);
        Cidade cidade = cidadeDAO.getPorIdCidade(rs.getInt("cidade"));

        setor.setIdsetor(rs.getInt("idsetor"));
        setor.setNome(rs.getString("nome"));
        setor.setCidade(cidade);
    }
}
