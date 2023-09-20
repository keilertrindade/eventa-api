package br.com.eventa.model;

import javax.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long usuario_id;
    private String nome;

    private String email;

    private String senha;

    private String tipoPerfil;
    @ManyToOne
    @JoinColumn(name = "cepEndereco", referencedColumnName = "cep")
    private Endereco endereco;
    private String complementoEndereco;

    public Usuario(){
    }

    public Usuario(Long usuario_id, String nome, String email, String senha, String tipoPerfil, Endereco endereco, String complementoEndereco) {
        this.usuario_id = usuario_id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipoPerfil = tipoPerfil;
        this.endereco = endereco;
        this.complementoEndereco = complementoEndereco;
    }

    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(String tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getComplementoEndereco() {
        return complementoEndereco;
    }

    public void setComplementoEndereco(String complementoEndereco) {
        this.complementoEndereco = complementoEndereco;
    }

    /*@OneToMany(mappedBy = "responsavel")
    private List<Evento> eventosCriados;*/
}
