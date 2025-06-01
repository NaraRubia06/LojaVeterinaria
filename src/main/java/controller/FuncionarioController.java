/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ClienteDAO;
import dao.FuncionarioDAO;
import javax.swing.JOptionPane;
import model.ClienteModel;
import model.FuncionarioModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/** @author Nara Rubia B. Balena  */

public class FuncionarioController {
     private final FuncionarioDAO funcionarioDAO;

    public FuncionarioController() {
        this.funcionarioDAO = new FuncionarioDAO();
    }

    public boolean salvarFuncionario(String nome, String cpf, String telefone, String cargo, String salario, String dataAdmissao,
                        String cep, String estado, String cidade, String bairro, String logradouro, String complemento, 
                        String numero) {
        try {
            FuncionarioModel funcionarioModel = new FuncionarioModel();
            funcionarioModel.setNome(nome);
            funcionarioModel.setCpf(cpf);
            funcionarioModel.setTelefone(telefone); 
            funcionarioModel.setCargo(cargo);
            funcionarioModel.setSalario(salario);
            funcionarioModel.setDataAdmissao(dataAdmissao);

            funcionarioModel.setCep(cep);
            funcionarioModel.setEstado(estado);
            funcionarioModel.setCidade(cidade);
            funcionarioModel.setBairro(bairro);
            funcionarioModel.setLogradouro(logradouro);
            funcionarioModel.setComplemento(complemento);
            funcionarioModel.setNumero(numero);

            Long id = funcionarioDAO.salvar(funcionarioModel);
            JOptionPane.showMessageDialog(null,
                    "Funcionário cadastrado com sucesso! ID: " + id,
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao salvar o funcionário: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
        public void atualizarFuncionarioPorId(Long id, FuncionarioModel novosDados) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            FuncionarioModel funcionario = session.get(FuncionarioModel.class, id);
            if (funcionario != null) {
                funcionario.setNome(novosDados.getNome());
                funcionario.setCpf(novosDados.getCpf());
                funcionario.setTelefone(novosDados.getTelefone());
                funcionario.setCargo(novosDados.getCargo());
                funcionario.setSalario(novosDados.getSalario());
                funcionario.setDataAdmissao(novosDados.getDataAdmissao());
                
                funcionario.setCep(novosDados.getCep());
                funcionario.setEstado(novosDados.getEstado());
                funcionario.setCidade(novosDados.getCidade());
                funcionario.setBairro(novosDados.getBairro());
                funcionario.setLogradouro(novosDados.getLogradouro());
                funcionario.setComplemento(novosDados.getComplemento());
                funcionario.setNumero(novosDados.getNumero());

                session.update(funcionario);
                System.out.println("Funcionário atualizado com sucesso!");
            } else {
                System.out.println("Funcionário não encontrado.");
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println("Erro ao atualizar o funcionário: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    public void excluirFuncionarioPorId(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            FuncionarioModel funcionario = session.get(FuncionarioModel.class, id);
            if (funcionario != null) {
                session.delete(funcionario);
                System.out.println("Funcionário excluído com sucesso!");
            } else {
                System.out.println("Funcionário não encontrado.");
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