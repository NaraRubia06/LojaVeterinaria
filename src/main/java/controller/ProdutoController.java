/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ClienteDAO;
import dao.ProdutoDAO;
import javax.swing.JOptionPane;
import model.ClienteModel;
import model.ProdutoModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/** @author Nara Rubia B. Balena */

public class ProdutoController {
    private final ProdutoDAO produtoDAO;

    public ProdutoController() {
        this.produtoDAO = new ProdutoDAO();
    }

    public boolean salvarProduto(String nome, String preco, String qtdEstoque, 
                                 String categoria, String fornecedor, String dataValidade) {
        try {
            ProdutoModel produtoModel = new ProdutoModel();
            produtoModel.setNome(nome);
            produtoModel.setPreco(preco);
            produtoModel.setQtdEstoque(qtdEstoque);
            produtoModel.setCategoria(categoria);
            produtoModel.setFornecedor(fornecedor);  
            produtoModel.setDataValidade(dataValidade);

            Long id = produtoDAO.salvar(produtoModel);
            JOptionPane.showMessageDialog(null,
                    "Produto cadastrado com sucesso! ID: " + id,
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao salvar o produto: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
        public void atualizarProdutoPorId(Long id, ProdutoModel novosDados) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            ProdutoModel produto = session.get(ProdutoModel.class, id);
            if (produto != null) {
                produto.setNome(novosDados.getNome());
                produto.setPreco(novosDados.getPreco());
                produto.setQtdEstoque(novosDados.getQtdEstoque());
                produto.setCategoria(novosDados.getCategoria());
                produto.setFornecedor(novosDados.getFornecedor());
                produto.setDataValidade(novosDados.getDataValidade());

                session.update(produto);
                System.out.println("Produto atualizado com sucesso!");
            } else {
                System.out.println("Produto não encontrado.");
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println("Erro ao atualizar o produto: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    public void excluirProdutoPorId(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            ProdutoModel produto = session.get(ProdutoModel.class, id);
            if (produto != null) {
                session.delete(produto);
                System.out.println("Produto excluído com sucesso!");
            } else {
                System.out.println("Produto não encontrado.");
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