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
public class AtivarConta implements Serializable {
    
    private Integer idativarconta;
    private String nome;

    public Integer getIdativarconta() {
        return idativarconta;
    }

    public void setIdativarconta(Integer idativarconta) {
        this.idativarconta = idativarconta;
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
        hash = 53 * hash + (this.idativarconta != null ? this.idativarconta.hashCode() : 0);
        hash = 53 * hash + (this.nome != null ? this.nome.hashCode() : 0);
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
        final AtivarConta other = (AtivarConta) obj;
        if (this.idativarconta != other.idativarconta && (this.idativarconta == null || !this.idativarconta.equals(other.idativarconta))) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        return true;
    }

}
