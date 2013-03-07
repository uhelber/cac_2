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
public class Laboratorio implements Serializable {
    private Integer idlaboratorio;
    private Pregao pregao;

    public Integer getIdlaboratorio() {
        return idlaboratorio;
    }

    public void setIdlaboratorio(Integer idlaboratorio) {
        this.idlaboratorio = idlaboratorio;
    }

    public Pregao getPregao() {
        return pregao;
    }

    public void setPregao(Pregao pregao) {
        this.pregao = pregao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.idlaboratorio != null ? this.idlaboratorio.hashCode() : 0);
        hash = 29 * hash + (this.pregao != null ? this.pregao.hashCode() : 0);
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
        final Laboratorio other = (Laboratorio) obj;
        if (this.idlaboratorio != other.idlaboratorio && (this.idlaboratorio == null || !this.idlaboratorio.equals(other.idlaboratorio))) {
            return false;
        }
        if (this.pregao != other.pregao && (this.pregao == null || !this.pregao.equals(other.pregao))) {
            return false;
        }
        return true;
    }

    
}
