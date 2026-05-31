/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import jakarta.persistence.*;
import java.util.Date;

/**
 *
 * @author fsmar
 */
@Entity
public class SessaoEstudo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSessaoEstudo;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataEstudo;
    
    @Column(nullable = false)
    private int totalQuestoes;
    
    @Column(nullable = false)
    private int acertos;
    
    @Column(length = 500)
    private String observacao;
    
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "idMateria")
    private Materia materia;
    
    @OneToOne (mappedBy = "sessaoEstudo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Revisao revisao;
    
    
    public SessaoEstudo() {
    }

    public SessaoEstudo(Date dataEstudo, int totalQuestoes, int acertos, String observacao, Materia materia, Revisao revisao) {
        this.dataEstudo = dataEstudo;
        this.totalQuestoes = totalQuestoes;
        this.acertos = acertos;
        this.observacao = observacao;
        this.materia = materia;
        this.revisao = revisao;
    }
    

    public SessaoEstudo(int idSessaoEstudo, Date dataEstudo, int totalQuestoes, int acertos, String observacao, Materia materia, Revisao revisao) {
        this.idSessaoEstudo = idSessaoEstudo;
        this.dataEstudo = dataEstudo;
        this.totalQuestoes = totalQuestoes;
        this.acertos = acertos;
        this.observacao = observacao;
        this.materia = materia;
        this.revisao = revisao;
    }

    public SessaoEstudo(int idSessaoEstudo, Date dataEstudo, int totalQuestoes, int acertos, String observacao, Materia materia, Date dataRevisao, TipoStatus status) {
        this.idSessaoEstudo = idSessaoEstudo;
        this.dataEstudo = dataEstudo;
        this.totalQuestoes = totalQuestoes;
        this.acertos = acertos;
        this.observacao = observacao;
        this.materia = materia;
        this.revisao = new Revisao(dataRevisao,status,observacao);
        this.revisao.setSessaoEstudo(this);
    }

    public SessaoEstudo(Date dataEstudo, int totalQuestoes, int acertos, String observacao, Materia materia, Date dataRevisao, TipoStatus status) {
        this.dataEstudo = dataEstudo;
        this.totalQuestoes = totalQuestoes;
        this.acertos = acertos;
        this.observacao = observacao;
        this.materia = materia;
        this.revisao = new Revisao(dataRevisao,status,observacao);
        this.revisao.setSessaoEstudo(this);
    }
    
    public Materia getMateria() {
        return materia;
    }

    public int getIdSessaoEstudo() {
        return idSessaoEstudo;
    }

    public void setIdSessaoEstudo(int idSessaoEstudo) {
        this.idSessaoEstudo = idSessaoEstudo;
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
    
    public int getErros() {
        return totalQuestoes - acertos;
    }

    public double getPercentualAcertos() {

        if(totalQuestoes == 0){
            return 0;
        }

        return ((double) acertos / totalQuestoes) * 100;
    }
}
