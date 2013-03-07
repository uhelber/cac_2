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
public class Chamado implements Serializable{
    private Integer idchamado;
    private Escola escola;
    private String contato;
    private String telefone;
    private String telefone2;
    private Status status;
    private String descricao;
    private Integer abertopor;
    private String dataabertura;
    private String imagem;
    private Usuario tecnico;

    public Integer getIdchamado() {
        return idchamado;
    }

    public void setIdchamado(Integer idchamado) {
        this.idchamado = idchamado;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getAbertopor() {
        return abertopor;
    }

    public void setAbertopor(Integer abertopor) {
        this.abertopor = abertopor;
    }

    public String getDataabertura() {
        return dataabertura;
    }

    public void setDataabertura(String dataabertura) {
        this.dataabertura = dataabertura;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Usuario getTecnico() {
        return tecnico;
    }

    public void setTecnico(Usuario tecnico) {
        this.tecnico = tecnico;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + (this.idchamado != null ? this.idchamado.hashCode() : 0);
        hash = 41 * hash + (this.escola != null ? this.escola.hashCode() : 0);
        hash = 41 * hash + (this.contato != null ? this.contato.hashCode() : 0);
        hash = 41 * hash + (this.telefone != null ? this.telefone.hashCode() : 0);
        hash = 41 * hash + (this.telefone2 != null ? this.telefone2.hashCode() : 0);
        hash = 41 * hash + (this.status != null ? this.status.hashCode() : 0);
        hash = 41 * hash + (this.descricao != null ? this.descricao.hashCode() : 0);
        hash = 41 * hash + (this.abertopor != null ? this.abertopor.hashCode() : 0);
        hash = 41 * hash + (this.dataabertura != null ? this.dataabertura.hashCode() : 0);
        hash = 41 * hash + (this.imagem != null ? this.imagem.hashCode() : 0);
        hash = 41 * hash + (this.tecnico != null ? this.tecnico.hashCode() : 0);
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
        final Chamado other = (Chamado) obj;
        if (this.idchamado != other.idchamado && (this.idchamado == null || !this.idchamado.equals(other.idchamado))) {
            return false;
        }
        if (this.escola != other.escola && (this.escola == null || !this.escola.equals(other.escola))) {
            return false;
        }
        if ((this.contato == null) ? (other.contato != null) : !this.contato.equals(other.contato)) {
            return false;
        }
        if ((this.telefone == null) ? (other.telefone != null) : !this.telefone.equals(other.telefone)) {
            return false;
        }
        if ((this.telefone2 == null) ? (other.telefone2 != null) : !this.telefone2.equals(other.telefone2)) {
            return false;
        }
        if (this.status != other.status && (this.status == null || !this.status.equals(other.status))) {
            return false;
        }
        if ((this.descricao == null) ? (other.descricao != null) : !this.descricao.equals(other.descricao)) {
            return false;
        }
        if (this.abertopor != other.abertopor && (this.abertopor == null || !this.abertopor.equals(other.abertopor))) {
            return false;
        }
        if ((this.dataabertura == null) ? (other.dataabertura != null) : !this.dataabertura.equals(other.dataabertura)) {
            return false;
        }
        if ((this.imagem == null) ? (other.imagem != null) : !this.imagem.equals(other.imagem)) {
            return false;
        }
        if (this.tecnico != other.tecnico && (this.tecnico == null || !this.tecnico.equals(other.tecnico))) {
            return false;
        }
        return true;
    }

    
}
