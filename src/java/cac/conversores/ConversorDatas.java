/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.conversores;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author uhelberc
 */
@FacesConverter("ConversorDatas")
public class ConversorDatas implements Converter {

    private DateFormat formatador;
            
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Date dt = null;
        java.sql.Date dtSql = null;
        
        if(value != null && !value.equals("")){
            this.formatador = new SimpleDateFormat("yyyy-MM-dd");
            try {
                dt = formatador.parse(value);
                dtSql = new java.sql.Date(dt.getTime());
            } catch (ParseException ex) {
                FacesMessage msn  = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Data incorreta. Veja Ex.: dia/mês/ano");
                
                throw new ConverterException(msn);
            }
        }
        
        return dtSql;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        this.formatador = new SimpleDateFormat("dd/MM/yyyy");
        
        return formatador.format((Date) value);
    }
}
