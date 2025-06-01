/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.VendaDAO;
import javax.swing.JOptionPane;
import model.VendaModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/** @author Nara Rubia B. Balena */

public class VendaController {
     private final VendaDAO vendaDAO;

    public VendaController() {
        this.vendaDAO = new VendaDAO();
    }

    public boolean salvarVenda(String cliente, String produto, String quantidade, String dataVenda,
                        String formaPagamento, String valorTotal) {
        try {
            VendaModel vendaModel = new VendaModel(); 
            vendaModel.setCliente(cliente);
            vendaModel.setProduto(produto);
            vendaModel.setQuantidade(quantidade);
            vendaModel.setDataVenda(dataVenda);
            vendaModel.setFormaPagamento(formaPagamento);  
            vendaModel.setValorTotal(valorTotal);

            Long id = vendaDAO.salvar(vendaModel);
            JOptionPane.showMessageDialog(null,
                    "Venda cadastrada com sucesso! ID: " + id,
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao salvar a venda: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
        public void atualizarVendaPorId(Long id, VendaModel novosDados) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            VendaModel venda = session.get(VendaModel.class, id);
            if (venda != null) {
                venda.setCliente(novosDados.getCliente());
                venda.setProduto(novosDados.getProduto());
                venda.setQuantidade(novosDados.getQuantidade());
                venda.setDataVenda(novosDados.getDataVenda());
                venda.setFormaPagamento(novosDados.getFormaPagamento());
                venda.setValorTotal(novosDados.getValorTotal());

                session.update(venda);
                System.out.println("Venda atualizado com sucesso!");
            } else {
                System.out.println("Venda não encontrado.");
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println("Erro ao atualizar a venda: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    public void excluirVendaPorId(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            VendaModel venda = session.get(VendaModel.class, id);
            if (venda != null) {
                session.delete(venda);
                System.out.println("Venda excluída com sucesso!");
            } else {
                System.out.println("Venda não encontrado.");
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