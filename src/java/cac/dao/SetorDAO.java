/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.dao;

import cac.db.Cidade;
import cac.db.DataBase;
import cac.db.Setor;
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
public class SetorDAO {

    DataBase db;

    public SetorDAO() {
    }

    public Setor getPorIdSetor(Integer id) throws ClassNotFoundException, SQLException {
        this.db = new DataBase();

        PreparedStatement ps = (PreparedStatement) db.getPreparedStatement("SELECT * FROM nte.setor WHERE idsetor = ?");
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        Setor setor = new Setor();

        if (rs.next()) {
            polularListaChamado(setor, rs);
        }

        ps.close();
        rs.close();
        db.getCon().close();

        return setor;
    }

    public List<Setor> getTodosSetor(Usuario usuario) throws ClassNotFoundException, SQLException {
        this.db = new DataBase();
        List<Setor> setor = new LinkedList<Setor>();
        List<Setor> novoSetor = new LinkedList<Setor>();

        ResultSet rs = db.getStatement().executeQuery("SELECT * FROM nte.setor");
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
        db.getCon().close();

        return novoSetor;
    }

    private void polularListaChamado(Setor setor, ResultSet rs) throws SQLException, ClassNotFoundException {
        CidadeDAO cidadeDAO = new CidadeDAO();
        Cidade cidade = cidadeDAO.getPorIdCidade(rs.getInt("cidade"));

        setor.setIdsetor(rs.getInt("idsetor"));
        setor.setNome(rs.getString("nome"));
        setor.setCidade(cidade);
    }
}
