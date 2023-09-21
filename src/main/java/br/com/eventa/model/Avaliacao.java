package br.com.eventa.model;

import javax.persistence.*;

import java.util.Date;

@Entity
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long avaliacao_id;

    private String titulo;

    private String descricao;

    @Temporal(TemporalType.DATE)
    private Date data_criacao;

    private int nota;

    @ManyToOne
    private Usuario usuario;

    //Atributo usado para verificar se o avaliado é um Evento ou um Local
    private String tipo_avaliado;

    //Atributo usado para validar o id do avaliado, e realizar o relacionamento especifico através da services
    private Long id_avaliado;

    public Avaliacao() {
    }

    public String getTipo_avaliado() {
        return tipo_avaliado;
    }

    public void setTipo_avaliado(String tipo_avaliado) {
        this.tipo_avaliado = tipo_avaliado;
    }

    public Long getId_avaliado() {
        return id_avaliado;
    }

    public void setId_avaliado(Long id_avaliado) {
        this.id_avaliado = id_avaliado;
    }

    public Long getAvaliacao_id() {
        return avaliacao_id;
    }

    public void setAvaliacao_id(Long avaliacao_id) {
        this.avaliacao_id = avaliacao_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(Date data_criacao) {
        this.data_criacao = data_criacao;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


}
