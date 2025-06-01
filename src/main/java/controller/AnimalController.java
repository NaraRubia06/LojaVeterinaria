/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.AnimalDAO;
import javax.swing.JOptionPane;
import model.AnimalModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**@author Nara Rubia B. Balena */

public class AnimalController {
    
    private final AnimalDAO animalDAO;

    public AnimalController() {
        this.animalDAO = new AnimalDAO();
    }

    public boolean salvarAnimal(String nome, String especie, String raca, String sexo,
                        String idade, String dataNascimento, String peso, String cor, String nomeTutor, String observacao) {
        try {
            AnimalModel animalModel = new AnimalModel(); 
            animalModel.setNome(nome);
            animalModel.setEspecie(especie);
            animalModel.setRaca(raca);
            animalModel.setSexo(sexo);
            animalModel.setIdade(idade);  
            animalModel.setDataNascimento(dataNascimento);
            animalModel.setPeso(peso);
            animalModel.setCor(cor);
            animalModel.setNomeTutor(nomeTutor);
            animalModel.setObservacao(observacao);

            Long id = animalDAO.salvar(animalModel);
            JOptionPane.showMessageDialog(null,
                    "Animal cadastrado com sucesso! ID: " + id,
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao salvar o animal: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
        public void atualizarAnimalPorId(Long id, AnimalModel novosDados) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            AnimalModel animal = session.get(AnimalModel.class, id);
            if (animal != null) {
                animal.setNome(novosDados.getNome());
                animal.setEspecie(novosDados.getEspecie());
                animal.setRaca(novosDados.getRaca());
                animal.setSexo(novosDados.getSexo());
                animal.setIdade(novosDados.getIdade());
                animal.setDataNascimento(novosDados.getDataNascimento());
                animal.setPeso(novosDados.getPeso());
                animal.setCor(novosDados.getCor());
                animal.setNomeTutor(novosDados.getNomeTutor());
                animal.setObservacao(novosDados.getObservacao());

                session.update(animal);
                System.out.println("Animal atualizado com sucesso!");
            } else {
                System.out.println("Animal não encontrado.");
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println("Erro ao atualizar o animal: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    public void excluirAnimalPorId(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            AnimalModel animal = session.get(AnimalModel.class, id);
            if (animal != null) {
                session.delete(animal);
                System.out.println("Animal excluído com sucesso!");
            } else {
                System.out.println("Animal não encontrado.");
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }
}