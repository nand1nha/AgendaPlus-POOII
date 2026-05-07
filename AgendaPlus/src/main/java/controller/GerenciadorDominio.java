/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ConexaoHibernate;
import dao.ConexaoPostgres;
import dao.MateriaDAO;
import domain.Materia;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author 2024222760026
 */
public class GerenciadorDominio {
    
    private MateriaDAO matDAO;
    
    public GerenciadorDominio() throws ClassNotFoundException, SQLException {
        //TESTE
        ConexaoHibernate.getSessionFactory().openSession();
        
        matDAO = new MateriaDAO(); 
    }
    
    public List<Materia> listarMateria() throws ClassNotFoundException, SQLException{
        return matDAO.listar();
    }
}
