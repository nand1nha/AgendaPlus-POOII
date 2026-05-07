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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRevisao;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataRevisao;
    
    @Enumerated(EnumType.STRING)
    private TipoStatus status;
    
    private SessaoEstudo sessao;

    public Revisao() {
    }

    public Revisao(int idRevisao, Date dataRevisao, TipoStatus status, SessaoEstudo sessao) {
        this.idRevisao = idRevisao;
        this.dataRevisao = dataRevisao;
        this.status = status;
        this.sessao = sessao;
    }

    public Revisao(SessaoEstudo sessao, Date dataRevisao, TipoStatus status) {
        this.sessao = sessao;
        this.dataRevisao = dataRevisao;
        this.status = status;
    }

    public SessaoEstudo getSessao() {
        return sessao;
    }

    public int getIdRevisao() {
        return idRevisao;
    }

    public void setIdRevisao(int idRevisao) {
        this.idRevisao = idRevisao;
    }

    public void setSessao(SessaoEstudo sessao) {
        this.sessao = sessao;
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
    
    
}
