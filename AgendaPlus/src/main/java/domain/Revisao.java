package domain;

import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author fsmar
 */
public class Revisao {
    private int idRevisao;
    private SessaoEstudo sessao;
    private Date dataRevisao;
    private String status;

    public Revisao(SessaoEstudo sessao, Date dataRevisao, String status) {
        this.sessao = sessao;
        this.dataRevisao = dataRevisao;
        this.status = status;
    }

    public SessaoEstudo getSessao() {
        return sessao;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
