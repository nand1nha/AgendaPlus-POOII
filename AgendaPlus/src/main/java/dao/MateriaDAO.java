/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import domain.Materia;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author fsmar
 */
public class MateriaDAO {
    public List<Materia> listarComSessoes() throws HibernateException {

        Session sessao = null;
        List<Materia> materias;

        try {

            sessao = ConexaoHibernate
                    .getSessionFactory()
                    .openSession();

            sessao.beginTransaction();

            materias = sessao.createQuery(
                    "SELECT DISTINCT m FROM Materia m " +
                    "LEFT JOIN FETCH m.sessaoEstudo",
                    Materia.class)
                    .getResultList();

            sessao.getTransaction().commit();

        } catch (HibernateException ex) {

            if (sessao != null) {
                sessao.getTransaction().rollback();
            }

            throw new HibernateException(ex);

        } finally {

            if (sessao != null) {
                sessao.close();
            }
        }

        return materias;
    }

}
