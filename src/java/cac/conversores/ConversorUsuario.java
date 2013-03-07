/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.conversores;

import cac.dao.UsuarioDAO;
import cac.db.Usuario;
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
@FacesConverter(forClass = Usuario.class)
public class ConversorUsuario implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Usuario stts = null;
        

        if (value != null) {
            try {
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                stts = (Usuario) usuarioDAO.getPorIdUsuario(new Integer(value));

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConversorUsuario.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ConversorUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return stts;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return ((Usuario) value).getIdusuarios().toString();
        }
        return null;
    }
}
