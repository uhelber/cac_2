/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.conversores;

import cac.dao.FuncaoDAO;
import cac.dao.SetorDAO;
import cac.db.Cidade;
import cac.db.Funcao;
import cac.db.Setor;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author uhelberc
 */
@FacesConverter(forClass=Funcao.class)
public class ConversorFuncao implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Funcao funcao = null;


        if (value != null) {
            try {
                FuncaoDAO funcaoDAO = new FuncaoDAO();
                funcao = funcaoDAO.getPorIdFuncao(new Integer(value));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConversorFuncao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ConversorFuncao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

        return funcao;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return ((Funcao) value).getIdfuncao().toString();
        }
        return null;
    }
}
