/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author 2024222760026
 */
public enum TipoDesempenho {
    EXCELENTE("Excelente"),
    BOM("Bom"),
    REGULAR("Regular"),
    PRECISA_REVISAR("Precisa Revisar");
    
    private final String descricao;
    
    TipoDesempenho(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
