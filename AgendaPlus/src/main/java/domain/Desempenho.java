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
    
    
}
