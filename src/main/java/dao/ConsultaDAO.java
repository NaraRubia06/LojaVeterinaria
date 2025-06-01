/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import model.ConsultaModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/** @author Nara Rubia B. Balena */

public class ConsultaDAO {
    
    // SALVAR 
    public Long salvar(ConsultaModel consulta) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.saveOrUpdate(consulta);

            transaction.commit();
            return consulta.getId();
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Erro ao salvar a consulta: " + e.getMessage(), e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    // ATUALIZAR - EDITAR 
    public void atualizarConsulta(ConsultaModel consulta) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();      
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            session.update(consulta);
            tx.commit();
            System.out.println("Consulta atualizada com sucesso!");
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println("Erro ao atualizar a consulta: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    // EXCLUIR
    public void excluirConsulta(ConsultaModel venda) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(venda);
            tx.commit();
            System.out.println("Consulta deletada com sucesso!");
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }
    
    // LISTAR TODOS NA TABELA QUANDO SALVAR
    public List<ConsultaModel> listarTodos() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<ConsultaModel> consulta = session.createQuery("FROM ConsultaModel", ConsultaModel.class).list();
   
    return consulta;   
    }
}
