/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**@author Nara Rubia B. Balena */

@Entity
@Getter
@Setter
@Data
@Table(name = "produtos")

public class ProdutoModel implements Serializable {
    
     private static final long serialVersionUID = 1L;
        
    // DADOS PARA CADASTRO DO PRODUTO.
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 1000)
    private String nome;

    @Column(name = "preco", length = 1000)
    private String preco;
    
    @Column(name = "qtdEstoque", length = 1000)
    private String qtdEstoque;

    @Column(name = "categoria", length = 1000)
    private String categoria;
    
    @Column(name = "fornecedor", length = 1000)
    private String fornecedor;
    
    @Column(name = "dataValidade", length = 10)
    private String dataValidade;

    public ProdutoModel() {
    }

    public ProdutoModel(String nome, String preco, String qtdEstoque, 
                        String categoria, String fornecedor, String dataValidade) {

        this.nome = nome;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
        this.dataValidade = dataValidade;
    }
    
}