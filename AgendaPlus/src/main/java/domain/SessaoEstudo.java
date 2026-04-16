/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.Date;

/**
 *
 * @author fsmar
 */
public class SessaoEstudo {
    private int idSessaoEstudo;
    private Materia materia;
    private Date dataEstudo;
    private int totalQuestoes;
    private int acertos;
    private String observacao;

    public SessaoEstudo(Materia materia, Date dataEstudo, int totalQuestoes, int acertos, String observacao) {
        this.materia = materia;
        this.dataEstudo = dataEstudo;
        this.totalQuestoes = totalQuestoes;
        this.acertos = acertos;
        this.observacao = observacao;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Date getDataEstudo() {
        return dataEstudo;
    }

    public void setDataEstudo(Date dataEstudo) {
        this.dataEstudo = dataEstudo;
    }

    public int getTotalQuestoes() {
        return totalQuestoes;
    }

    public void setTotalQuestoes(int totalQuestoes) {
        this.totalQuestoes = totalQuestoes;
    }

    public int getAcertos() {
        return acertos;
    }

    public void setAcertos(int acertos) {
        this.acertos = acertos;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    
}
