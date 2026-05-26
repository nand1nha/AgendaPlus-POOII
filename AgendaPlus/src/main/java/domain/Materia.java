package domain;

import jakarta.persistence.*;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 2024222760026
 */
@Entity
@Table(name = "materia")
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMateria;
    
    @Column(unique = true, nullable = false)
    private String nome;
    
    @Column(length = 500)
    private String descricao;
    
    @Enumerated(EnumType.STRING)
    private TipoNivelDificuldade dificuldade;
    
    @Transient
    private Desempenho desempenho;
    
    @OneToMany(mappedBy = "materia", fetch = FetchType.LAZY)
    private List<SessaoEstudo> sessaoEstudo;

    public Materia() {
    }

    public Materia(int idMateria, String nome, String descricao, TipoNivelDificuldade dificuldade, Desempenho desepenho) {
        this.idMateria = idMateria;
        this.nome = nome;
        this.descricao = descricao;
        this.dificuldade = dificuldade;
        this.desempenho = desepenho;
    }

    public Materia(String nome, String descricao, TipoNivelDificuldade dificuldade) {
        this.nome = nome;
        this.descricao = descricao;
        this.dificuldade = dificuldade;
    }

    public Materia(String descricao, TipoNivelDificuldade dificuldade) {
        this.descricao = descricao;
        this.dificuldade = dificuldade;
    }
    
    public Materia(int idMateria, String nome, String descricao, TipoNivelDificuldade dificuldade) {
        this.idMateria = idMateria;
        this.nome = nome;
        this.descricao = descricao;
        this.dificuldade = dificuldade;
    }

    public Materia(int idMateria, String nome, String descricao, TipoNivelDificuldade dificuldade, Desempenho desepenho, List<SessaoEstudo> sessaoEstudo) {
        this.idMateria = idMateria;
        this.nome = nome;
        this.descricao = descricao;
        this.dificuldade = dificuldade;
        this.desempenho = desepenho;
        this.sessaoEstudo = sessaoEstudo;
    }

    public Desempenho getDesepenho() {
        return desempenho;
    }

    public void setDesepenho(Desempenho desepenho) {
        this.desempenho = desepenho;
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

    public TipoNivelDificuldade getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(TipoNivelDificuldade dificuldade) {
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
