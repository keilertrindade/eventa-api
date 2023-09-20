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
    @ManyToOne
    private Evento evento;

    public Avaliacao() {
    }

    public Avaliacao(Long avaliacao_id, String titulo, String descricao, Date data_criacao, int nota, Usuario usuario, Evento evento) {
        this.avaliacao_id = avaliacao_id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.data_criacao = data_criacao;
        this.nota = nota;
        this.usuario = usuario;
        this.evento = evento;
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

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
