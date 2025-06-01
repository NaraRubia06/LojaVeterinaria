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

/** @author Nara Rubia B. Balena */

@Entity
@Getter
@Setter
@Data
@Table(name = "venda")

public class VendaModel implements Serializable{
    
       private static final long serialVersionUID = 1L;
        
    // DADOS PARA CADASTRO DA VENDA.
       
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cliente", length = 1000)
    private String cliente;

    @Column(name = "produto",  length = 1000)
    private String produto;
    
    @Column(name = "quantidade", length = 1000)
    private String quantidade;

    @Column(name = "dataVenda", length = 10)
    private String dataVenda;

    @Column(name = "formaPagamento", length = 1000)
    private String formaPagamento;
    
    @Column(name = "valorTotal", length = 1000)
    private String valorTotal;

    public VendaModel() {
    }

    public VendaModel(String cliente, String produto, String quantidade, String dataVenda,
                        String formaPagamento, String valorTotal) {

        this.cliente = cliente;
        this.produto = produto;
        this.quantidade = quantidade;
        this.dataVenda = dataVenda;
        this.formaPagamento = formaPagamento;
        this.valorTotal = valorTotal;
    }
}