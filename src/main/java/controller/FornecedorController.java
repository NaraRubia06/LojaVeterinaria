/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.FornecedorDAO;
import javax.swing.JOptionPane;
import model.FornecedorModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/** @author Nara Rubia B. Balena */

public class FornecedorController {
    private final FornecedorDAO fornecedorDAO;

    public FornecedorController() {
        this.fornecedorDAO = new FornecedorDAO();
    }

    public boolean salvarFornecedor(String nomeEmpresa, String cnpj, String telefone, String email,
                        String cep, String estado, String cidade, String bairro, String logradouro, String numero) {
        try {
            FornecedorModel fornecedorModel = new FornecedorModel();
            fornecedorModel.setNomeEmpresa(nomeEmpresa);
            fornecedorModel.setCnpj(cnpj);
            fornecedorModel.setTelefone(telefone);
            fornecedorModel.setEmail(email);  
            
            fornecedorModel.setCep(cep);
            fornecedorModel.setEstado(estado);
            fornecedorModel.setCidade(cidade);
            fornecedorModel.setBairro(bairro);
            fornecedorModel.setLogradouro(logradouro);
            fornecedorModel.setNumero(numero);

            Long id = fornecedorDAO.salvar(fornecedorModel);
            JOptionPane.showMessageDialog(null,
                    "Fornecedor cadastrado com sucesso! ID: " + id,
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao salvar o fornecedor: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
        public void atualizarFornecedorPorId(Long id, FornecedorModel novosDados) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            FornecedorModel fornecedor = session.get(FornecedorModel.class, id);
            if (fornecedor != null) {
                fornecedor.setNomeEmpresa(novosDados.getNomeEmpresa());
                fornecedor.setCnpj(novosDados.getCnpj());
                fornecedor.setTelefone(novosDados.getTelefone());
                fornecedor.setEmail(novosDados.getEmail());
                
                fornecedor.setCep(novosDados.getCep());
                fornecedor.setEstado(novosDados.getEstado());
                fornecedor.setCidade(novosDados.getCidade());
                fornecedor.setBairro(novosDados.getBairro());
                fornecedor.setLogradouro(novosDados.getLogradouro());
                fornecedor.setNumero(novosDados.getNumero());

                session.update(fornecedor);
                System.out.println("Fornecedor atualizado com sucesso!");
            } else {
                System.out.println("Fornecedor não encontrado.");
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println("Erro ao atualizar o fornecedor: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    public void excluirFornecedorPorId(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            FornecedorModel fornecedor = session.get(FornecedorModel.class, id);
            if (fornecedor != null) {
                session.delete(fornecedor);
                System.out.println("Fornecedor excluído com sucesso!");
            } else {
                System.out.println("Fornecedor não encontrado.");
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