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
@Table(name = "fornecedor")

public class FornecedorModel implements Serializable{
    
    private static final long serialVersionUID = 1L;
        
    // DADOS DO CADASTRO DO FORNECEDOR.
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomeEmpresa", nullable = false, length = 1000)
    private String nomeEmpresa;

    @Column(name = "cnpj", unique = true, length = 18)
    private String cnpj;

    @Column(name = "telefone", length = 15)
    private String telefone;
    
    @Column(name = "email", length = 1000)
    private String email;
    
    
        // DADOS DO CADASTRO FORNECEDOR - ENDEREÇO
    @Column(name = "cep", length = 10)
    private String cep;
    
    @Column(name = "estado", length = 1000)
    private String estado;
    
    @Column(name = "cidade", length = 1000)
    private String cidade;
     
    @Column(name = "bairro", length = 1000)
    private String bairro;
    
    @Column(name = "logradouro", length = 1000)
    private String logradouro;
    
    @Column(name = "numero", length = 1000)
    private String numero;

    public FornecedorModel() {
    }

    public FornecedorModel(String nomeEmpresa, String cnpj, String telefone, String email,
                        String cep, String estado, String cidade, String bairro, String logradouro, String numero) {
        this.nomeEmpresa = nomeEmpresa;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.email = email;
        
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero = numero;
        
    }
    
}