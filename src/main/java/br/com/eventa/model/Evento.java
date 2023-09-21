package br.com.eventa.model;

import javax.persistence.*;


import java.sql.Time;
import java.util.Date;

@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Usuario responsavel;

    private String nome;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "local_id")
    private Local local;

    private String linkImagemEvento;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInicio;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFinal;

    private String categoria;

    private String diasExibicao;

    private Time horarioSessaoPrincipal;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Evento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public String getLinkImagemEvento() {
        return linkImagemEvento;
    }

    public void setLinkImagemEvento(String linkImagemEvento) {
        this.linkImagemEvento = linkImagemEvento;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getDiasExibicao() {
        return diasExibicao;
    }

    public void setDiasExibicao(String diasExibicao) {
        this.diasExibicao = diasExibicao;
    }

    public Time getHorarioSessaoPrincipal() {
        return horarioSessaoPrincipal;
    }

    public void setHorarioSessaoPrincipal(Time horarioSessaoPrincipal) {
        this.horarioSessaoPrincipal = horarioSessaoPrincipal;
    }
}
