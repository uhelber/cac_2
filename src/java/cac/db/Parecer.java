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
public class Parecer implements Serializable {
    private Integer idparecer;
    private Usuario tecnico;
    private String dataatentimento;
    private String dataconclusao;
    private String parecer;
    private Integer chamado;

    public Parecer() {
    }

    public Integer getIdparecer() {
        return idparecer;
    }

    public void setIdparecer(Integer idparecer) {
        this.idparecer = idparecer;
    }

    public Usuario getTecnico() {
        return tecnico;
    }

    public void setTecnico(Usuario tecnico) {
        this.tecnico = tecnico;
    }

    public String getDataatentimento() {
        return dataatentimento;
    }

    public void setDataatentimento(String dataatentimento) {
        this.dataatentimento = dataatentimento;
    }

    public String getDataconclusao() {
        return dataconclusao;
    }

    public void setDataconclusao(String dataconclusao) {
        this.dataconclusao = dataconclusao;
    }

    public String getParecer() {
        return parecer;
    }

    public void setParecer(String parecer) {
        this.parecer = parecer;
    }

    public Integer getChamado() {
        return chamado;
    }

    public void setChamado(Integer chamado) {
        this.chamado = chamado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.idparecer != null ? this.idparecer.hashCode() : 0);
        hash = 97 * hash + (this.tecnico != null ? this.tecnico.hashCode() : 0);
        hash = 97 * hash + (this.dataatentimento != null ? this.dataatentimento.hashCode() : 0);
        hash = 97 * hash + (this.dataconclusao != null ? this.dataconclusao.hashCode() : 0);
        hash = 97 * hash + (this.parecer != null ? this.parecer.hashCode() : 0);
        hash = 97 * hash + (this.chamado != null ? this.chamado.hashCode() : 0);
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
        final Parecer other = (Parecer) obj;
        if (this.idparecer != other.idparecer && (this.idparecer == null || !this.idparecer.equals(other.idparecer))) {
            return false;
        }
        if (this.tecnico != other.tecnico && (this.tecnico == null || !this.tecnico.equals(other.tecnico))) {
            return false;
        }
        if ((this.dataatentimento == null) ? (other.dataatentimento != null) : !this.dataatentimento.equals(other.dataatentimento)) {
            return false;
        }
        if ((this.dataconclusao == null) ? (other.dataconclusao != null) : !this.dataconclusao.equals(other.dataconclusao)) {
            return false;
        }
        if ((this.parecer == null) ? (other.parecer != null) : !this.parecer.equals(other.parecer)) {
            return false;
        }
        if (this.chamado != other.chamado && (this.chamado == null || !this.chamado.equals(other.chamado))) {
            return false;
        }
        return true;
    }

}
