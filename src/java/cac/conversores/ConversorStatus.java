/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.conversores;

import cac.dao.StatusDAO;
import cac.db.Status;
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
@FacesConverter(forClass = Status.class)
public class ConversorStatus implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Status stts = null;
        

        if (value != null) {
            try {
                StatusDAO dao = new StatusDAO();
                stts = (Status) dao.getPorIdStatus(new Integer(value));

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConversorStatus.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ConversorStatus.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return stts;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return ((Status) value).getIdstatus().toString();
        }
        return null;
    }
}
