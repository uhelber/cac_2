/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.conversores;

import cac.dao.CidadeDAO;
import cac.db.Cidade;
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
@FacesConverter(forClass=Cidade.class)
public class ConversorCidade implements Converter {
    private Connection cnx;

    public ConversorCidade(Connection cnx) {
        this.cnx = cnx;
    }
    
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Cidade cidade = null;


        if (value != null) {
            try {
                CidadeDAO cidadeDAO = new CidadeDAO(this.cnx);
                cidade = cidadeDAO.getPorIdCidade(new Integer(value));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConversorCidade.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ConversorCidade.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

        return cidade;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return ((Cidade) value).getIdcidade().toString();
        }
        return null;
    }
}
