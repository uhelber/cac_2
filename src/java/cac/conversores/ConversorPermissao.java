/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.conversores;

import cac.dao.PermissaoDAO;
import cac.db.Permissao;
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
@FacesConverter(forClass=Permissao.class)
public class ConversorPermissao implements Converter {
    private Connection cnx;

    public ConversorPermissao(Connection cnx) {
        this.cnx = cnx;
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Permissao permissao = null;


        if (value != null) {
            try {
                PermissaoDAO permissaoDAO = new PermissaoDAO(this.cnx);
                permissao = permissaoDAO.getPorIdPermissao(new Integer(value));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConversorPermissao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ConversorPermissao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

        return permissao;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return ((Permissao) value).getIdpermissao().toString();
        }
        return null;
    }
}
