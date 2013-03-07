/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.conversores;

import cac.dao.RegionalDAO;
import cac.db.Regional;
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
@FacesConverter(forClass=Regional.class)
public class ConversorRegional implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Regional regional = null;


        if (value != null) {
            try {
                RegionalDAO regionalDAO = new RegionalDAO();
                regional = regionalDAO.getPorIdRegional(new Integer(value));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConversorRegional.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ConversorRegional.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

        return regional;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return ((Regional) value).getIdregional().toString();
        }
        return null;
    }
}
