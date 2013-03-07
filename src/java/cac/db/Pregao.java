/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.db;

/**
 *
 * @author Uhelber
 */
public class Pregao {
    private Integer idpregao;
    private String pregao;
    private String contrato;

    public Integer getIdpregao() {
        return idpregao;
    }

    public void setIdpregao(Integer idpregao) {
        this.idpregao = idpregao;
    }

    public String getPregao() {
        return pregao;
    }

    public void setPregao(String pregao) {
        this.pregao = pregao;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.idpregao != null ? this.idpregao.hashCode() : 0);
        hash = 67 * hash + (this.pregao != null ? this.pregao.hashCode() : 0);
        hash = 67 * hash + (this.contrato != null ? this.contrato.hashCode() : 0);
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
        final Pregao other = (Pregao) obj;
        if (this.idpregao != other.idpregao && (this.idpregao == null || !this.idpregao.equals(other.idpregao))) {
            return false;
        }
        if ((this.pregao == null) ? (other.pregao != null) : !this.pregao.equals(other.pregao)) {
            return false;
        }
        if ((this.contrato == null) ? (other.contrato != null) : !this.contrato.equals(other.contrato)) {
            return false;
        }
        return true;
    }

    
}
