/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ConexaoHibernate;
import dao.GenericDAO;
import dao.RevisaoDAO;
import domain.Materia;
import domain.Revisao;
import domain.SessaoEstudo;
import domain.TipoNivelDificuldade;
import domain.TipoStatus;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author 2024222760026
 */
public class GerenciadorDominio {
    
    private GenericDAO genDAO;
    private RevisaoDAO revDAO;
    
    public GerenciadorDominio() throws ClassNotFoundException, SQLException {
        //TESTE
        ConexaoHibernate.getSessionFactory().openSession();
        
        genDAO = new GenericDAO(); 
        revDAO = new RevisaoDAO();
        
    }
    
    public List<Materia> listarMateria() throws ClassNotFoundException, SQLException{
        List<Materia> lista = genDAO.listar(Materia.class);
        return lista;
    }
    
    public List<Revisao> listarRevisao() throws ClassNotFoundException, SQLException{
        List<Revisao> lista = genDAO.listar(Revisao.class);
        return lista;
    }
    
    public Materia inserirMateria(String nome, String descricao, TipoNivelDificuldade dificuldade){
        
        Materia mat = new Materia(nome, descricao, dificuldade);
        
        genDAO.inserir(mat); 
        return mat;
    }
    
    public SessaoEstudo inserirSessaoEstudo(Date dataEstudo, int totalQuestoes, int acertos, String observacao, Materia materia, Date dataRevisao, TipoStatus status){
        
        SessaoEstudo sessao = new SessaoEstudo(dataEstudo, totalQuestoes, acertos, observacao, materia, dataRevisao, status);
        
        genDAO.inserir(sessao); 
        return sessao;
    }
    
    public void alterarMateria(int idMateria, String nome, String descricao, TipoNivelDificuldade dificuldade){
        
        Materia mat = new Materia(nome, descricao, dificuldade);
        mat.setIdMateria(idMateria);
        genDAO.alterar(mat);
        
    }
    
    public void alterarRevisao(int idRevisao, Date dataRevisao, TipoStatus status, String observacao, SessaoEstudo sessaoEstudo){
        
        Revisao rev = new Revisao(dataRevisao, status, observacao, sessaoEstudo);
        rev.setIdRevisao(idRevisao);
        genDAO.alterar(rev);
        
    }
    
    // EXCLUIR GENÉRICO
    public void excluir(Object obj) throws HibernateException {                                
        genDAO.excluir(obj);
    }
    
    public List<Revisao> pesquisarRevisao(String pesq, int tipo) throws HibernateException {        
        
        switch ( tipo ) {
            case 0: return revDAO.pesquisarPorMateria(pesq);
            default : return null;
        }

    }
    
}
