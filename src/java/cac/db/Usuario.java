/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.db;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author UhelberC
 */
public class Usuario implements Serializable {

    private Integer idusuarios;
    private String nome;
    private String sobrenome;
    private Setor setor;
    private Funcao funcao;
    private Date datanascimento;
    private String datacadastro;
    private Integer cadastrador;
    private String telefone;
    private String matricula;
    private String usuario;
    private String senha;
    private Permissao permissao;
    private AtivarConta ativarconta;

    public Integer getIdusuarios() {
        return idusuarios;
    }

    public void setIdusuarios(Integer idusuarios) {
        this.idusuarios = idusuarios;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(String datacadastro) {
        this.datacadastro = datacadastro;
    }

    public Integer getCadastrador() {
        return cadastrador;
    }

    public void setCadastrador(Integer cadastrador) {
        this.cadastrador = cadastrador;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }

    public AtivarConta getAtivarconta() {
        return ativarconta;
    }

    public void setAtivarconta(AtivarConta ativarconta) {
        this.ativarconta = ativarconta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.idusuarios != null ? this.idusuarios.hashCode() : 0);
        hash = 29 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 29 * hash + (this.sobrenome != null ? this.sobrenome.hashCode() : 0);
        hash = 29 * hash + (this.setor != null ? this.setor.hashCode() : 0);
        hash = 29 * hash + (this.funcao != null ? this.funcao.hashCode() : 0);
        hash = 29 * hash + (this.datanascimento != null ? this.datanascimento.hashCode() : 0);
        hash = 29 * hash + (this.datacadastro != null ? this.datacadastro.hashCode() : 0);
        hash = 29 * hash + (this.cadastrador != null ? this.cadastrador.hashCode() : 0);
        hash = 29 * hash + (this.telefone != null ? this.telefone.hashCode() : 0);
        hash = 29 * hash + (this.matricula != null ? this.matricula.hashCode() : 0);
        hash = 29 * hash + (this.usuario != null ? this.usuario.hashCode() : 0);
        hash = 29 * hash + (this.senha != null ? this.senha.hashCode() : 0);
        hash = 29 * hash + (this.permissao != null ? this.permissao.hashCode() : 0);
        hash = 29 * hash + (this.ativarconta != null ? this.ativarconta.hashCode() : 0);
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
        final Usuario other = (Usuario) obj;
        if (this.idusuarios != other.idusuarios && (this.idusuarios == null || !this.idusuarios.equals(other.idusuarios))) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.sobrenome == null) ? (other.sobrenome != null) : !this.sobrenome.equals(other.sobrenome)) {
            return false;
        }
        if (this.setor != other.setor && (this.setor == null || !this.setor.equals(other.setor))) {
            return false;
        }
        if (this.funcao != other.funcao && (this.funcao == null || !this.funcao.equals(other.funcao))) {
            return false;
        }
        if ((this.datanascimento == null) ? (other.datanascimento != null) : !this.datanascimento.equals(other.datanascimento)) {
            return false;
        }
        if ((this.datacadastro == null) ? (other.datacadastro != null) : !this.datacadastro.equals(other.datacadastro)) {
            return false;
        }
        if (this.cadastrador != other.cadastrador && (this.cadastrador == null || !this.cadastrador.equals(other.cadastrador))) {
            return false;
        }
        if ((this.telefone == null) ? (other.telefone != null) : !this.telefone.equals(other.telefone)) {
            return false;
        }
        if ((this.matricula == null) ? (other.matricula != null) : !this.matricula.equals(other.matricula)) {
            return false;
        }
        if ((this.usuario == null) ? (other.usuario != null) : !this.usuario.equals(other.usuario)) {
            return false;
        }
        if ((this.senha == null) ? (other.senha != null) : !this.senha.equals(other.senha)) {
            return false;
        }
        if (this.permissao != other.permissao && (this.permissao == null || !this.permissao.equals(other.permissao))) {
            return false;
        }
        if (this.ativarconta != other.ativarconta && (this.ativarconta == null || !this.ativarconta.equals(other.ativarconta))) {
            return false;
        }
        return true;
    }

}
