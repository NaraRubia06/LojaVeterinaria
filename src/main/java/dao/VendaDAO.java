/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import model.VendaModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/** @author Nara Rubia B. Balena */

public class VendaDAO {
    
     // SALVAR 
    public Long salvar(VendaModel venda) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.saveOrUpdate(venda);

            transaction.commit();
            return venda.getId();
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Erro ao salvar a venda: " + e.getMessage(), e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    // ATUALIZAR - EDITAR 
    public void atualizarVenda(VendaModel venda) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();      
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            session.update(venda);
            tx.commit();
            System.out.println("Venda atualizado com sucesso!");
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println("Erro ao atualizar a venda: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    // EXCLUIR
    public void excluirVenda(VendaModel venda) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(venda);
            tx.commit();
            System.out.println("Venda deletada com sucesso!");
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }
    
    // LISTAR TODOS NA TABELA QUANDO SALVAR
    public List<VendaModel> listarTodos() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<VendaModel> venda = session.createQuery("FROM VendaModel", VendaModel.class).list();
   
    return venda;   
    }
}