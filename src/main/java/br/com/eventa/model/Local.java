package br.com.eventa.model;

import javax.persistence.*;


@Entity
public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long local_id;
    private String nome;
    private String descricaoLocal;
    @ManyToOne
    @JoinColumn(name = "cepEndereco", referencedColumnName = "cep")
    private Endereco endereco;
    private String complementoEndereco;
    private String linkImagemLocal;

    public Local() {
    }


    public Local(Long local_id, String nome, String descricaoLocal, Endereco endereco, String complementoEndereco, String linkImagemLocal) {
        this.local_id = local_id;
        this.nome = nome;
        this.descricaoLocal = descricaoLocal;
        this.endereco = endereco;
        this.complementoEndereco = complementoEndereco;
        this.linkImagemLocal = linkImagemLocal;
    }

    public Long getLocal_id() {
        return local_id;
    }

    public void setLocal_id(Long local_id) {
        this.local_id = local_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricaoLocal() {
        return descricaoLocal;
    }

    public void setDescricaoLocal(String descricaoLocal) {
        this.descricaoLocal = descricaoLocal;
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

    public String getLinkImagemLocal() {
        return linkImagemLocal;
    }

    public void setLinkImagemLocal(String linkImagemLocal) {
        this.linkImagemLocal = linkImagemLocal;
    }
}
