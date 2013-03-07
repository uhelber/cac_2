/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.db;

import java.io.Serializable;

/**
 *
 * @author UhelberC
 */
public class Status implements Serializable {
    
    private Integer idstatus;
    private String nome;

    public Integer getIdstatus() {
        return idstatus;
    }

    public void setIdstatus(Integer idstatus) {
        this.idstatus = idstatus;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (this.idstatus != null ? this.idstatus.hashCode() : 0);
        hash = 59 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Status other = (Status) obj;
        if (this.idstatus != other.idstatus && (this.idstatus == null || !this.idstatus.equals(other.idstatus))) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        return true;
    }
    
    
}
