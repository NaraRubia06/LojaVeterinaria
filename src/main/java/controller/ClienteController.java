/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ClienteDAO;
import model.ClienteModel;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/** @author Nara Rubia B. Balena */

public class ClienteController {
     private final ClienteDAO clienteDAO;
     /* Declara uma variável de instância chamada clienteDAO
        É private → só pode ser usada dentro da classe.
        É final → não pode ser reassociada depois da inicialização → segurança e integridade do objeto.
     */

    public ClienteController() {
        this.clienteDAO = new ClienteDAO(); // Significa que assim que o ClienteController for criado, ele automaticamente instancia um ClienteDAO.
    } // O Controller "nasce" com seu DAO pronto para usar

    //  Método público - pode ser acessado de fora da classe.
    //  Retorna boolean - true se salvar com sucesso, false se der erro.
    //  Recebe todos os atributos do cliente como parâmetros individuais.
    public boolean salvarCliente(String nome, String dataNascimento, String cpf, String genero, String telefone, String email,
                                 String cep, String estado, String cidade, String bairro, String logradouro, String complemento, 
                                 String numero) {
        try {
            ClienteModel clienteModel = new ClienteModel();
            clienteModel.setNome(nome);
            clienteModel.setDataNasc(dataNascimento);
            clienteModel.setCpf(cpf);
            clienteModel.setGenero(genero);
            clienteModel.setTelefone(telefone);
            clienteModel.setEmail(email);  
            
            clienteModel.setCep(cep);
            clienteModel.setEstado(estado);
            clienteModel.setCidade(cidade);
            clienteModel.setBairro(bairro);
            clienteModel.setLogradouro(logradouro);
            clienteModel.setComplemento(complemento);
            clienteModel.setNumero(numero);

            Long id = clienteDAO.salvar(clienteModel);
            JOptionPane.showMessageDialog(null,
                    "Cliente cadastrado com sucesso! ID: " + id,
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao salvar cliente: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
        public void atualizarClientePorId(Long id, ClienteModel novosDados) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            ClienteModel cliente = session.get(ClienteModel.class, id);
            if (cliente != null) {
                cliente.setNome(novosDados.getNome());
                cliente.setDataNasc(novosDados.getDataNasc());
                cliente.setCpf(novosDados.getCpf());
                cliente.setGenero(novosDados.getGenero());
                
                cliente.setCep(novosDados.getCep());
                cliente.setEstado(novosDados.getEstado());
                cliente.setCidade(novosDados.getCidade());
                cliente.setBairro(novosDados.getBairro());
                cliente.setLogradouro(novosDados.getLogradouro());
                cliente.setComplemento(novosDados.getComplemento());
                cliente.setNumero(novosDados.getNumero());
                          
                cliente.setEmail(novosDados.getEmail());
                cliente.setTelefone(novosDados.getTelefone());

                session.update(cliente);
                System.out.println("Cliente atualizado com sucesso!");
            } else {
                System.out.println("Cliente não encontrado.");
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println("Erro ao atualizar cliente: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    public void excluirClientePorId(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            ClienteModel cliente = session.get(ClienteModel.class, id);
            if (cliente != null) {
                session.delete(cliente);
                System.out.println("Cliente excluído com sucesso!");
            } else {
                System.out.println("Cliente não encontrado.");
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
/* CONTROLLER - Receber a solicitação, processar a lógica de negócio e chamar o DAO para executar a operação

*/