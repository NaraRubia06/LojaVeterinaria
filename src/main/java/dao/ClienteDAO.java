/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.ClienteModel;
import util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/** @author Nara Rubia B. Balena */

public class ClienteDAO {
    
    // SALVAR um clienteModel no banco de dados usando o Hibernate.
    
    // Recebe um objeto `ClienteModel`.  - Retorna um `Long`, o `id` do cliente — valor de chave primária.
    public Long salvar(ClienteModel cliente) {
        Session session = null; // Inicializa a sessão e a transação como null.
        Transaction transaction = null;
        // Sem transação, o Hibernate não sabe quando deve efetivar (commit) ou cancelar (rollback) as mudanças.

        try {
            session = HibernateUtil.getSessionFactory().openSession(); // Abre uma **nova sessão** — canal de comunicação com o banco.  
            transaction = session.beginTransaction(); //  Inicia uma **transação** — qualquer alteração no banco deve estar dentro de uma, para garantir sucesso.
            // openSession + beginTransaction - Prepara a conexão e a transação
            
            session.saveOrUpdate(cliente); // saveOrUpdate - Insere ou atualiza conforme o estado do objeto 
            // Se o cliente não tiver ID → Hibernate interpreta como novo → faz INSERT.
            // Se o cliente já tiver ID → Hibernate interpreta como existente → faz UPDATE.
 
            transaction.commit(); //️ Confirma / Finaliza a transação - grava as alterações de forma **permanente** no banco.  - Sem o `commit`, nada acontece de fato — fica tudo só na memória da sessão.
            return cliente.getId(); // Após o commit, o Hibernate garante que o id tenha feito com sucesso.
            
        } catch (Exception e) {
            if (transaction != null) { //️ Se qualquer exceção for lançada, a transação é **desfeita** (rollback).  
                transaction.rollback(); // Isso garante a **integridade** do banco — nada fica pela metade.
                // rollback - Desfaz alterações se der erro
            }
            throw new RuntimeException("Erro ao salvar cliente: " + e.getMessage(), e); // Relança uma RuntimeException com mensagem clara e a causa original - Permite que a camada superior saiba que deu ruim e tome as providências.
        } finally {
            if (session != null) { 
                session.close(); // Fecha a sessão
            }
        }
    }
    
    // ATUALIZAR - EDITAR um clienteModel no banco de dados usando o hibernate.
    // Recebe um `ClienteModel` como parâmetro — **o cliente já deve existir** no banco, com o `id` preenchido.  - `void`- só executa a atualização.
    public void atualizarCliente(ClienteModel cliente) {
        Session session = HibernateUtil.getSessionFactory().openSession();   // openSession - Abre uma sessão com o banco via HibernateUtil   
        Transaction tx = null; //  Prepara uma transação (tx), inicialmente null
        
        try {
            tx = session.beginTransaction(); //  Inicia / Começa a **transação** - A partir daqui, qualquer operação precisa ser **confirmada** com `commit` ou **desfeita** com `rollback`.
            session.update(cliente); //  Atualiza o cliente na base.
            tx.commit();// Confirma a transação - grava de forma definitiva no banco.  
            System.out.println("Cliente atualizado com sucesso!");
        } catch (Exception e) {
            if (tx != null) { 
                tx.rollback(); // Se der qualquer erro, desfaz a transação.  - Mantém o banco **íntegro**.
            }
            System.err.println("Erro ao atualizar cliente: " + e.getMessage());
        } finally {
            session.close(); // Fecha a sessão.
        }
    }

    // EXCLUIR algum ClienModel do banco de dados.
    public void excluirCliente(ClienteModel cliente) {
        Session session = HibernateUtil.getSessionFactory().openSession();//Abre uma sessão com o banco via HibernateUtil
        Transaction tx = null; // ️ Declara a Transaction como null para controle posterior.

        try {
            tx = session.beginTransaction(); //  Inicia uma **transação** — a partir daqui, qualquer operação precisa de **commit** para efetivar, ou **rollback** para desfazer.
            session.delete(cliente);// Manda o Hibernate deletar o objeto cliente da base.
            tx.commit(); // Confirma a transação - exclui de vez o registro do banco.  
            System.out.println("Cliente deletado com sucesso!");
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback(); // Se der qualquer erro, faz **rollback** - desfaz a transação.  
            }
        } finally {
            session.close(); // Fecha a sessão 
        }
    }
    
    // LISTAR TODOS NA TABELA QUANDO SALVAR
    public List<ClienteModel> listarTodos() { // Retorna uma **lista** (`List`) de objetos `ClienteModel`.  
    Session session = HibernateUtil.getSessionFactory().openSession(); //  Abre uma sessão com o banco, usando o HibernateUtil
    List<ClienteModel> clientes = session.createQuery("FROM ClienteModel", ClienteModel.class).list(); // Executa consulta HQL para listar todos os clientes
    // Cria uma **query HQL** (Hibernate Query Language).
   
    return clientes;  // Retorna a lista de clientes .
    }  
}
/* DAO - interface de negociação entre o sistema e o banco - Sem DAO, sem acesso ao banco.
O ClienteDAO é a camada responsável por isolar e encapsular todas as operações de acesso a dados relacionadas à entidade ClienteModel
Centraliza tudo que é inserir, atualizar, excluir e consultar clientes no banco.
*/