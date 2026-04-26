package domain;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 2024222760026
 */
public class Materia {
    private int idMateria;
    private String nome;
    private String descricao;
    private String dificuldade;

    public Materia(String nome, String descricao, String dificuldade) {
        this.nome = nome;
        this.descricao = descricao;
        this.dificuldade = dificuldade;
    }

    public Materia(int idMateria, String nome, String descricao, String dificuldade) {
        this.idMateria = idMateria;
        this.nome = nome;
        this.descricao = descricao;
        this.dificuldade = dificuldade;
    }

    public Materia(int idMateria, String nome, String dificuldade) {
        this.idMateria = idMateria;
        this.nome = nome;
        this.dificuldade = dificuldade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    @Override
    public String toString() {
        return nome;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }
    
    
}
