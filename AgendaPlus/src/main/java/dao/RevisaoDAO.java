/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import domain.Materia;
import domain.Revisao;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author 2024222760026
 */
public class RevisaoDAO {
    public List<Revisao> pesquisar(int tipo, String pesq1, String pesq2) throws HibernateException{
        Session sessao = null;
        List<Revisao> lista = null; 
        
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // OPERAÇÃO
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            // Resultado da consulta
            CriteriaQuery consulta = builder.createQuery(Revisao.class);
            // FROM a tabela que esta sendo consultada no bando de dados
            Root tabela = consulta.from( Revisao.class );
            
            //RESTRIÇÕES
            Predicate restricoes;
            switch(tipo){
                case 1: 
                    restricoes = builder.and(builder.like(tabela.get("sessaoEstudo").get("materia").get("nome"), pesq1 + '%'), builder.like(tabela.get("status"), pesq2 + '%'));
                    break;
                case 2:
                    restricoes = builder.like(tabela.get("sessaoEstudo").get("materia").get("nome"), pesq1 + '%');
                    break;
                default:
                    restricoes = null;
            }
            

            
            // WHERE
            consulta.where(restricoes);
            
            // Executar Query
            lista = sessao.createQuery(consulta).getResultList();
            
            sessao.getTransaction().commit();
            sessao.close();
        } catch ( HibernateException ex) {
            if ( sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(ex);
        }

        return lista;
    }
    
    public List<Revisao> pesquisarPorMateriaEStatus(String pesq1, String pesq2){
        return pesquisar(1, pesq1, pesq2);
    }
    
    public List<Revisao> pesquisarPorMateria(String pesq1){
        return pesquisar(2, pesq1, null);
    }
    
}
