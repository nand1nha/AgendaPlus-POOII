/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ConexaoHibernate;
import dao.GenericDAO;
import domain.Materia;
import domain.TipoNivelDificuldade;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author 2024222760026
 */
public class GerenciadorDominio {
    
    private GenericDAO genDAO;
    
    public GerenciadorDominio() throws ClassNotFoundException, SQLException {
        //TESTE
        ConexaoHibernate.getSessionFactory().openSession();
        
        genDAO = new GenericDAO(); 
    }
    
    public List<Materia> listarMateria() throws ClassNotFoundException, SQLException{
        List<Materia> lista = genDAO.listar(Materia.class);
        return lista;
    }
    
    public Materia inserirMateria(String nome, String descricao, TipoNivelDificuldade dificuldade){
        
        Materia mat = new Materia(nome, descricao, dificuldade);
        
        genDAO.inserir(mat); 
        return mat;
    }
    
    public void alterarMateria(int idMateria, String nome, String descricao, TipoNivelDificuldade dificuldade){
        
        Materia mat = new Materia(nome, descricao, dificuldade);
        mat.setIdMateria(idMateria);
        genDAO.alterar(mat);
        
    }
    
    public void excluirMateria(Materia mat){
        genDAO.excluir(mat);
    }
    
}
