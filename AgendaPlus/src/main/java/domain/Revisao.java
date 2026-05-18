package domain;

import jakarta.persistence.*;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author fsmar
 */
@Entity
public class Revisao {
    
    @Id
    private int idRevisao;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataRevisao;
    
    @Temporal(TemporalType.DATE)
    private Date dataRealizacao;
    
    @Enumerated(EnumType.STRING)
    private TipoStatus status;
    
    @Column(length = 500)
    private String observacao;
    
    @OneToOne
    @MapsId
    @JoinColumn (name = "idRevisao")
    private SessaoEstudo sessaoEstudo;

    public Revisao() {
    }

    public Revisao(int idRevisao, Date dataRevisao, Date dataRealizacao, TipoStatus status, String observacao, SessaoEstudo sessaoEstudo) {
        this.idRevisao = idRevisao;
        this.dataRevisao = dataRevisao;
        this.dataRealizacao = dataRealizacao;
        this.status = status;
        this.observacao = observacao;
        this.sessaoEstudo = sessaoEstudo;
    }

    public Revisao(Date dataRevisao, Date dataRealizacao, TipoStatus status, String observacao, SessaoEstudo sessaoEstudo) {
        this.dataRevisao = dataRevisao;
        this.dataRealizacao = dataRealizacao;
        this.status = status;
        this.observacao = observacao;
        this.sessaoEstudo = sessaoEstudo;
    }

    public Revisao(Date dataRevisao, Date dataRealizacao, TipoStatus status, String observacao) {
        this.dataRevisao = dataRevisao;
        this.dataRealizacao = dataRealizacao;
        this.status = status;
        this.observacao = observacao;
    }

    public Revisao(int idRevisao, Date dataRevisao, Date dataRealizacao, TipoStatus status, String observacao) {
        this.idRevisao = idRevisao;
        this.dataRevisao = dataRevisao;
        this.dataRealizacao = dataRealizacao;
        this.status = status;
        this.observacao = observacao;
    }


    public SessaoEstudo getSessaoEstudo() {
        return sessaoEstudo;
    }

    public int getIdRevisao() {
        return idRevisao;
    }

    public void setIdRevisao(int idRevisao) {
        this.idRevisao = idRevisao;
    }

    public void setSessaoEstudo(SessaoEstudo sessaoEstudo) {
        this.sessaoEstudo = sessaoEstudo;
    }

    public Date getDataRevisao() {
        return dataRevisao;
    }

    public void setDataRevisao(Date dataRevisao) {
        this.dataRevisao = dataRevisao;
    }

    public TipoStatus getStatus() {
        return status;
    }

    public void setStatus(TipoStatus status) {
        this.status = status;
    }

    public Date getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(Date dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    
}
