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
@Table(name = "funcionario") 

public class FuncionarioModel implements Serializable{ 
    
    private static final long serialVersionUID = 1L;
        
    // DADOS PESSOAIS CADASTRO FUNCIONÁRIO.
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    
    @Column(name = "cpf", unique = true, length = 14)
    private String cpf;
    
    @Column(name = "telefone", length = 15)
    private String telefone;
    
    @Column(name = "cargo", length = 1000)
    private String cargo;
    
    @Column(name = "salario", length = 1000)
    private String salario;
    
    @Column(name = "dataAdmissao", length = 10)
    private String dataAdmissao;
    
    
        // DADOS PESSOAIS CADASTRO FUNCIONÁRIO - ENDEREÇO
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
    
    @Column(name = "complemento", length = 1000)
    private String complemento;
    
    @Column(name = "numero", length = 1000)
    private String numero;

    public FuncionarioModel() {
    }

    public FuncionarioModel(String nome, String cpf, String telefone, String cargo, String salario, String dataAdmissao,
                        String cep, String estado, String cidade, String bairro, String logradouro, String complemento, 
                        String numero) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.cargo = cargo;
        this.salario = salario;
        this.dataAdmissao = dataAdmissao;
        
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.numero = numero;
        }
    
}