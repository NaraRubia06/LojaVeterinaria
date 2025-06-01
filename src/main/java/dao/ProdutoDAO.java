/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import model.ClienteModel;
import model.ProdutoModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/** @author Nara Rubia B. Balena */

public class ProdutoDAO {
    
     // SALVAR 
    public Long salvar(ProdutoModel produto) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.saveOrUpdate(produto);

            transaction.commit();
            return produto.getId();
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Erro ao salvar o produto: " + e.getMessage(), e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    // ATUALIZAR - EDITAR 
    public void atualizarProduto(ProdutoModel produto) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();      
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            session.update(produto);
            tx.commit();
            System.out.println("Produto atualizado com sucesso!");
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println("Erro ao atualizar o produto: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    // EXCLUIR
    public void excluirProduto(ProdutoModel produto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(produto);
            tx.commit();
            System.out.println("Produto deletado com sucesso!");
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }
    
    // LISTAR TODOS NA TABELA QUANDO SALVAR
    public List<ProdutoModel> listarTodos() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<ProdutoModel> produto = session.createQuery("FROM ProdutoModel", ProdutoModel.class).list();
   
    return produto;   
    }
    
}