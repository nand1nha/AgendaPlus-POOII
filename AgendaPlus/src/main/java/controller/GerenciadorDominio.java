/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ConexaoHibernate;
import dao.GenericDAO;
import dao.MateriaDAO;
import dao.RevisaoDAO;
import domain.Desempenho;
import domain.Materia;
import domain.Revisao;
import domain.SessaoEstudo;
import domain.TipoDesempenho;
import domain.TipoNivelDificuldade;
import domain.TipoStatus;
import java.sql.SQLException;
import java.util.ArrayList;
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
    private MateriaDAO matDAO;
    private DesempenhoService desempenhoService;
    
    public GerenciadorDominio() throws ClassNotFoundException, SQLException {
        //TESTE
        ConexaoHibernate.getSessionFactory().openSession();
        
        genDAO = new GenericDAO(); 
        revDAO = new RevisaoDAO();
        matDAO = new MateriaDAO();
        desempenhoService = new DesempenhoService();
        
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
    
    public List<Revisao> pesquisarPorMateriaEStatus(String pesq1, String pesq2) throws HibernateException {        
        return revDAO.pesquisarPorMateriaEStatus(pesq1, pesq2);
    }
    
    public List<Revisao> pesquisarPorMateria(String pesq1) throws HibernateException {        
        return revDAO.pesquisarPorMateria(pesq1);
    }
    
    public List<Desempenho> listarDesempenhos() {

        List<Materia> materias =
                matDAO.listarComSessoes();

        List<Desempenho> desempenhos =
                new ArrayList<>();

        for (Materia materia : materias) {
            desempenhos.add(
                desempenhoService.gerarDesempenho(materia)
            );
        }

        return desempenhos;
    }
    
    public List<Desempenho> filtrarPorMateria(List<Desempenho> desempenhos,int idMateria) {

         List<Desempenho> resultado = new ArrayList<>();

        for (Desempenho d : desempenhos) {

            if (d.getMateria().getIdMateria() == idMateria) {
                resultado.add(d);
                break;
            }
        }

        return resultado;
    }
    
    public Desempenho obterMelhorDesempenho() {

        List<Desempenho> desempenhos =
                listarDesempenhos();

        Desempenho melhor = null;

        for (Desempenho d : desempenhos) {

            if (melhor == null ||
                    d.getMediaAcertos() >
                    melhor.getMediaAcertos()) {

                melhor = d;
            }
        }

        return melhor;
    }
    
    public Desempenho obterMaiorEvolucao() {

        List<Desempenho> lista = listarDesempenhos();

        Desempenho melhor = null;

        for (Desempenho d : lista) {

            if (melhor == null ||
                d.getPercentualEvolucao() >
                melhor.getPercentualEvolucao()) {

                melhor = d;
            }
        }

        return melhor;
    }
    
    public List<Materia> obterMateriasParaRevisao() {

        List<Desempenho> desempenhos = listarDesempenhos();

        List<Materia> materiasRevisao = new ArrayList<>();

        for (Desempenho d : desempenhos) {

            if (d.getStatus() ==
                    TipoDesempenho.PRECISA_REVISAR) {

                materiasRevisao.add(
                        d.getMateria());
            }
        }

        return materiasRevisao;
    }
}
