/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.conversores;

import cac.dao.PregaoDAO;
import cac.db.Pregao;
import java.sql.Connection;
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
@FacesConverter(forClass=Pregao.class)
public class ConversorPregao implements Converter {
    private Connection cnx;

    public ConversorPregao(Connection cnx) {
        this.cnx = cnx;
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Pregao pregao = null;


        if (value != null) {
            try {
                PregaoDAO pregaoDAO = new PregaoDAO(this.cnx);
                pregao = pregaoDAO.getPorIdPregao(new Integer(value));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConversorPregao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ConversorPregao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

        return pregao;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return ((Pregao) value).getIdpregao().toString();
        }
        return null;
    }
}
