/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import jakarta.persistence.Entity;
import java.util.Date;

/**
 *
 * @author fsmar
 */

public class Desempenho {
    
    private Materia materia;

    private double mediaAcertos;

    private double percentualEvolucao;

    private TipoDesempenho status;

    private Date ultimaSessao;
    private Date proximaRevisao;

    public Desempenho(Materia materia, double mediaAcertos, double percentualEvolucao, TipoDesempenho status, Date ultimaSessao, Date proximaRevisao) {
        this.materia = materia;
        this.mediaAcertos = mediaAcertos;
        this.percentualEvolucao = percentualEvolucao;
        this.status = status;
        this.ultimaSessao = ultimaSessao;
        this.proximaRevisao = proximaRevisao;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public double getMediaAcertos() {
        return mediaAcertos;
    }

    public void setMediaAcertos(double mediaAcertos) {
        this.mediaAcertos = mediaAcertos;
    }

    public double getPercentualEvolucao() {
        return percentualEvolucao;
    }

    public void setPercentualEvolucao(double percentualEvolucao) {
        this.percentualEvolucao = percentualEvolucao;
    }

    public TipoDesempenho getStatus() {
        return status;
    }

    public void setStatus(TipoDesempenho status) {
        this.status = status;
    }

    public Date getUltimaSessao() {
        return ultimaSessao;
    }

    public void setUltimaSessao(Date ultimaSessao) {
        this.ultimaSessao = ultimaSessao;
    }

    public Date getProximaRevisao() {
        return proximaRevisao;
    }

    public void setProximaRevisao(Date proximaRevisao) {
        this.proximaRevisao = proximaRevisao;
    }
    
    
}
