/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import model.FornecedorModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/** @author Nara Rubia B. Balena */
public class FornecedorDAO {
    
     // SALVAR 
    public Long salvar(FornecedorModel fornecedor) {
        
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.saveOrUpdate(fornecedor);

            transaction.commit();
            return fornecedor.getId();
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Erro ao salvar o fornecedor: " + e.getMessage(), e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    // ATUALIZAR - EDITAR 
    public void atualizarFornecedor(FornecedorModel fornecedor) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();      
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            session.update(fornecedor);
            tx.commit();
            System.out.println("Fornecedor atualizado com sucesso!");
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println("Erro ao atualizar o fornecedor: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    // EXCLUIR
    public void excluirFornecedor(FornecedorModel fornecedor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(fornecedor);
            tx.commit();
            System.out.println("Fornecedor deletado com sucesso!");
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }
    
    // LISTAR TODOS NA TABELA QUANDO SALVAR
    public List<FornecedorModel> listarTodos() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<FornecedorModel> fornecedor = session.createQuery("FROM FornecedorModel", FornecedorModel.class).list();
   
    return fornecedor;   
    }
    
}
