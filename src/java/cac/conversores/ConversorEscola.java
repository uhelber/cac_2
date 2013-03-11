/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.conversores;

import cac.dao.EscolaDAO;
import cac.db.Escola;
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
@FacesConverter(forClass = Escola.class)
public class ConversorEscola implements Converter {
    private Connection cnx;

    public ConversorEscola(Connection cnx) {
        this.cnx = cnx;
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Escola escola = null;


        if (value != null) {
            EscolaDAO escolaDAO = null;
            try {
                escolaDAO = new EscolaDAO(this.cnx);
                escola = escolaDAO.getPorIdEscola(new Integer(value));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConversorEscola.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ConversorEscola.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

        return escola;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return ((Escola) value).getIdescola().toString();
        }
        return null;
    }
}
