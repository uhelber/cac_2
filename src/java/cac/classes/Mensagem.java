/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.classes;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 *
 * @author UhelberC
 */
public class Mensagem {
    
    public void EviarMensagens(String clientId, Severity severity, String summary, String detail){
        FacesContext fcnt = FacesContext.getCurrentInstance();
        FacesMessage msn = new FacesMessage(severity, summary, detail);
        
        fcnt.addMessage(clientId, msn);
    }
    
}
