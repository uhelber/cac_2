/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.validadores;

import cac.classes.Mensagem;
import com.sun.faces.util.MessageFactory;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Uhelber
 */
@FacesValidator("ValidarTelefone")
public class ValidarTelefone implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String telefone = (String) value;
        Object campo = MessageFactory.getLabel(context, component);

        Mensagem msn;

        if (telefone.length() < 13 || telefone.length() > 13) {
            msn = new Mensagem();

            FacesMessage mensagen = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "O campo " + campo + " deve ser preenchido como mostra o ex.: (99)9999-9999");

            throw new ValidatorException(mensagen);
        }

        for (int i = 0; i < telefone.length(); i++) {
            if (Character.isLetter(telefone.charAt(i))) {
                FacesMessage mensagen = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "O campo " + campo + " não deve conter letras. Veja o ex.: (99)9999-9999");

                throw new ValidatorException(mensagen);
            }
        }

        if (!telefone.substring(0, 1).equals("(")) {
            FacesMessage mensagen = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "O campo " + campo + " não deve conter caracteres que não sejam \"()\" ou \"-\". Veja o ex.: (99)9999-9999");

            throw new ValidatorException(mensagen);
        }

        if (!telefone.substring(3, 4).equals(")")) {
            FacesMessage mensagen = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "O campo " + campo + " não deve conter caracteres que não sejam \"()\" ou \"-\". Veja o ex.: (99)9999-9999");

            throw new ValidatorException(mensagen);
        }

        if (!telefone.substring(8, 9).equals("-")) {
            FacesMessage mensagen = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "O campo " + campo + " não deve conter caracteres que não sejam \"()\" ou \"-\". Veja o ex.: (99)9999-9999");

            throw new ValidatorException(mensagen);
        }


    }
}
