/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Desempenho;
import domain.Materia;
import domain.SessaoEstudo;
import domain.TipoDesempenho;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 *
 * @author fsmar
 */
public class DesempenhoFunc {
    
    public Desempenho gerarDesempenho(Materia materia) {

        double mediaAcertos = calcularMediaAcertos(materia);

        double percentualEvolucao = calcularPercentualEvolucao(materia);

        TipoDesempenho status = calcularStatus(mediaAcertos);

        Date ultimaSessao = buscarUltimaSessao(materia);

        Date proximaRevisao = calcularProximaRevisao(materia);

        return new Desempenho(
                materia,
                mediaAcertos,
                percentualEvolucao,
                status,
                ultimaSessao,
                proximaRevisao
        );
    }

    private double calcularMediaAcertos(Materia materia) {
        List<SessaoEstudo> sessoes = materia.getSessaoEstudo();

        if (sessoes == null || sessoes.isEmpty()) {
            return 0;
        }

        double soma = 0;

        for (SessaoEstudo sessao : sessoes) {
            soma += sessao.getPercentualAcertos();
        }

        return soma / sessoes.size();
    }

    private double calcularPercentualEvolucao(Materia materia) {
        List<SessaoEstudo> sessoes = materia.getSessaoEstudo();

        if (sessoes == null || sessoes.size() < 2) {
            return 0;
        }

        sessoes.sort(
            Comparator.comparing(SessaoEstudo::getDataEstudo)
        );

        double primeiro =
                sessoes.get(0).getPercentualAcertos();

        double ultimo =
                sessoes.get(sessoes.size() - 1)
                       .getPercentualAcertos();

        return ultimo - primeiro;
    }

    private TipoDesempenho calcularStatus(double media) {

        if (media >= 85) {
        return TipoDesempenho.EXCELENTE;
        }

        if (media >= 70) {
            return TipoDesempenho.BOM;
        }

        if (media >= 50) {
            return TipoDesempenho.REGULAR;
        }

        return TipoDesempenho.PRECISA_REVISAR;
    }

    private Date buscarUltimaSessao(Materia materia) {
        List<SessaoEstudo> sessoes = materia.getSessaoEstudo();

        if (sessoes == null || sessoes.isEmpty()) {
            return null;
        }

        Date ultima = sessoes.get(0).getDataEstudo();

        for (SessaoEstudo sessao : sessoes) {

            if (sessao.getDataEstudo().after(ultima)) {
                ultima = sessao.getDataEstudo();
            }
        }

        return ultima;
    }

    private Date calcularProximaRevisao(Materia materia) {
        List<SessaoEstudo> sessoes = materia.getSessaoEstudo();

        if (sessoes == null || sessoes.isEmpty()) {
            return null;
        }

        Date hoje = new Date();
        Date proxima = null;

        for (SessaoEstudo sessao : sessoes) {

            if (sessao.getRevisao() == null) {
                continue;
            }

            Date dataRevisao =
                    sessao.getRevisao().getDataRevisao();

            if (dataRevisao == null) {
                continue;
            }

            if (dataRevisao.after(hoje)) {

                if (proxima == null ||
                        dataRevisao.before(proxima)) {

                    proxima = dataRevisao;
                }
            }
        }

        return proxima;
    }
}
