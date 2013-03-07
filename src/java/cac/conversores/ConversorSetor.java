/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.conversores;

import cac.dao.SetorDAO;
import cac.db.Cidade;
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
@FacesConverter(forClass=Setor.class)
public class ConversorSetor implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Setor setor = null;


        if (value != null) {
            try {
                SetorDAO setorDAO = new SetorDAO();
                setor = setorDAO.getPorIdSetor(new Integer(value));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConversorSetor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ConversorSetor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

        return setor;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return ((Setor) value).getIdsetor().toString();
        }
        return null;
    }
}
