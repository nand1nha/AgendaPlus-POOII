/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author fsmar
 */
public enum TipoNivelDificuldade {
    BAIXO("Baixo"),
    MEDIO("Médio"),
    ALTO("Alto");
    
    private final String descricao;
    
    TipoNivelDificuldade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
