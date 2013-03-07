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
public class Regional implements Serializable {
    private Integer idregional;
    private String nome;
    private Setor setor;

    public Integer getIdregional() {
        return idregional;
    }

    public void setIdregional(Integer idregional) {
        this.idregional = idregional;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.idregional != null ? this.idregional.hashCode() : 0);
        hash = 97 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 97 * hash + (this.setor != null ? this.setor.hashCode() : 0);
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
        final Regional other = (Regional) obj;
        if (this.idregional != other.idregional && (this.idregional == null || !this.idregional.equals(other.idregional))) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if (this.setor != other.setor && (this.setor == null || !this.setor.equals(other.setor))) {
            return false;
        }
        return true;
    }

}
