/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import model.AnimalModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**@author Nara Rubia B. Balena */

public class AnimalDAO {
    
    // SALVAR 
    public Long salvar(AnimalModel animal) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.saveOrUpdate(animal);

            transaction.commit();
            return animal.getId();
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Erro ao salvar o animal: " + e.getMessage(), e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    // ATUALIZAR - EDITAR 
    public void atualizarAnimal(AnimalModel animal) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();      
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            session.update(animal);
            tx.commit();
            System.out.println("Animal atualizado com sucesso!");
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println("Erro ao atualizar o animal: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    // EXCLUIR
    public void excluirAnimal(AnimalModel animal) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(animal);
            tx.commit();
            System.out.println("Animal deletado com sucesso!");
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }
    
    // LISTAR TODOS NA TABELA QUANDO SALVAR
    public List<AnimalModel> listarTodos() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<AnimalModel> animal = session.createQuery("FROM AnimalModel", AnimalModel.class).list();
   
    return animal;   
    }
}