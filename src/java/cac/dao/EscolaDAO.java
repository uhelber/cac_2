/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.dao;

import cac.db.Cidade;
import cac.db.DataBase;
import cac.db.Escola;
import cac.db.Laboratorio;
import cac.db.Pregao;
import cac.db.Regional;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author UhelberC
 */
public class EscolaDAO {

    DataBase db;

    public EscolaDAO() throws ClassNotFoundException, SQLException {
    }

    public boolean cadastrarEscola(Escola escola) throws ClassNotFoundException, SQLException {
        this.db = new DataBase();
        LaboratorioDAO laboratorioDAO = new LaboratorioDAO();

        PreparedStatement ps = (PreparedStatement) this.db.getPreparedStatement("INSERT INTO nte.escola VALUE(?, ?, ?, ?, ?, ?, ?, ?, ?)");
        boolean retorno = false;

        if (escola != null) {
            ps.setString(1, null);
            ps.setInt(2, escola.getRegional().getIdregional());
            ps.setInt(3, escola.getCidade().getIdcidade());
            ps.setInt(4, escola.getInep());
            ps.setString(5, escola.getNome());
            ps.setString(6, escola.getEndereco());
            ps.setString(7, escola.getBairro());
            ps.setString(8, escola.getTelefone());
            ps.setString(9, escola.getTelefone2());

            for (int i = 0; i < escola.getPregao().length; i++) {
                laboratorioDAO.cadastrarLaboratorio(escola, i);
            }
            retorno = ps.execute();
        }

        ps.close();
        this.db.getCon().close();

        return retorno;
    }

    public List<Escola> getTodosEscolas() throws ClassNotFoundException, SQLException {
        this.db = new DataBase();
        
        List<Escola> escola = new LinkedList<Escola>();
        ResultSet rs = this.db.getStatement().executeQuery("SELECT * FROM nte.escola ORDER BY regional");
        while (rs.next()) {
            Escola scl = new Escola();
            polularListaEscola(scl, rs);
            escola.add(scl);
        }
        rs.close();
        db.getCon().close();

        return escola;
    }

    public List<Escola> getTodosEscolasPorIdCidade(Cidade cdd) throws ClassNotFoundException, SQLException {
        this.db = new DataBase();

        List<Escola> escola = new LinkedList<Escola>();

        PreparedStatement ps = (PreparedStatement) db.getPreparedStatement("SELECT * FROM nte.escola WHERE cidade = ?");
        ps.setInt(1, cdd.getIdcidade());

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Escola scl = new Escola();
            polularListaEscola(scl, rs);
            escola.add(scl);
        }
        rs.close();
        ps.close();
        db.getCon().close();

        return escola;
    }

    private void polularListaEscola(Escola escola, ResultSet rs) throws SQLException, ClassNotFoundException {
        RegionalDAO regionalDAO = new RegionalDAO();
        Regional regional = regionalDAO.getPorIdRegional(rs.getInt("regional"));

        LaboratorioDAO laboratorioDAO = new LaboratorioDAO();
        List<Pregao> pregoes = laboratorioDAO.getTodosPregoesPorIdEscola(rs.getInt("idescola"));
        
        Pregao[] pregaoArray = null;
        
        for(int i = 0; i < pregoes.size(); i++){
            pregaoArray[i] = pregoes.get(i);
        }

        CidadeDAO cidadeDAO = new CidadeDAO();
        Cidade cidade = cidadeDAO.getPorIdCidade(rs.getInt("cidade"));

        escola.setIdescola(rs.getInt("idescola"));
        escola.setRegional(regional);
        escola.setCidade(cidade);
        escola.setInep(rs.getInt("inep"));
        escola.setNome(rs.getString("escola"));
        escola.setEndereco(rs.getString("endereco"));
        escola.setBairro(rs.getString("bairro"));
        escola.setTelefone(rs.getString("telefone"));
        escola.setTelefone2(rs.getString("telefone2"));
        escola.setPregao(pregaoArray);
    }

    public Escola getPorIdEscola(int id) throws ClassNotFoundException, SQLException {
        this.db = new DataBase();


        PreparedStatement ps = (PreparedStatement) db.getPreparedStatement("SELECT * FROM nte.escola WHERE idescola = ?");
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        Escola escola = new Escola();
        if (rs.next()) {
            polularListaEscola(escola, rs);
        }

        ps.close();
        rs.close();
        this.db.getCon().close();

        return escola;
    }

    public Escola getPorIdCidade(Cidade cidade) throws ClassNotFoundException, SQLException {
        this.db = new DataBase();


        PreparedStatement ps = (PreparedStatement) db.getPreparedStatement("SELECT * FROM nte.escola WHERE cidade = ?");
        ps.setInt(1, cidade.getIdcidade());

        ResultSet rs = ps.executeQuery();

        Escola escola = new Escola();
        if (rs.next()) {
            polularListaEscola(escola, rs);
        }

        ps.close();
        rs.close();
        this.db.getCon().close();

        return escola;
    }

    public Escola getPorINEP(Integer inep) throws ClassNotFoundException, SQLException {
        this.db = new DataBase();


        PreparedStatement ps = (PreparedStatement) db.getPreparedStatement("SELECT * FROM nte.escola WHERE inep = ?");
        ps.setInt(1, inep);

        ResultSet rs = ps.executeQuery();

        Escola scl = null;

        if (rs.next()) {
            scl = new Escola();
            polularListaEscola(scl, rs);
        }

        ps.close();
        rs.close();
        this.db.getCon().close();

        return scl;
    }
}
