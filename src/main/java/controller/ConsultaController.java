/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ConsultaDAO;
import javax.swing.JOptionPane;
import model.ConsultaModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**@author Nara Rubia B. Balena */

public class ConsultaController {
    
    private final ConsultaDAO consultaDAO;

    public ConsultaController() {
        this.consultaDAO = new ConsultaDAO();
    }

    public boolean salvarConsulta (String animal, String tutor, String veterinario, String dataConsulta,
                        String horaConsulta, String statusConsulta, String motivoConsulta, String observacao) {
        try {
            ConsultaModel consultaModel = new ConsultaModel(); 
            consultaModel.setAnimal(animal);
            consultaModel.setTutor(tutor);
            consultaModel.setVeterinario(veterinario);
            consultaModel.setDataConsulta(dataConsulta);
            consultaModel.setHoraConsulta(horaConsulta);  
            consultaModel.setStatusConsulta(statusConsulta);
            consultaModel.setMotivoConsulta(motivoConsulta);  
            consultaModel.setObservacao(observacao);

            Long id = consultaDAO.salvar(consultaModel);
            JOptionPane.showMessageDialog(null,
                    "Consulta cadastrada com sucesso! ID: " + id,
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao salvar a consulta: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
        public void atualizarConsultaPorId(Long id, ConsultaModel novosDados) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            ConsultaModel consulta = session.get(ConsultaModel.class, id);
            if (consulta != null) {
                consulta.setAnimal(novosDados.getAnimal());
                consulta.setTutor(novosDados.getTutor());
                consulta.setVeterinario(novosDados.getVeterinario());
                consulta.setDataConsulta(novosDados.getDataConsulta());
                consulta.setHoraConsulta(novosDados.getHoraConsulta());
                consulta.setStatusConsulta(novosDados.getStatusConsulta());
                consulta.setMotivoConsulta(novosDados.getMotivoConsulta());
                consulta.setObservacao(novosDados.getObservacao());

                session.update(consulta);
                System.out.println("Consulta atualizada com sucesso!");
            } else {
                System.out.println("Consulta não encontrado.");
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println("Erro ao atualizar a consulta: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    public void excluirConsultaPorId(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            ConsultaModel consulta = session.get(ConsultaModel.class, id);
            if (consulta != null) {
                session.delete(consulta);
                System.out.println("Consulta excluída com sucesso!");
            } else {
                System.out.println("Consulta não encontrado.");
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