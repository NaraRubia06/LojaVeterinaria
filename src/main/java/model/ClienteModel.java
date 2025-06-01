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
import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**@author Nara Rubia B. Balena */

@Entity // Indica que essa classe é uma entidade JPA - vai mapear essa classe para a tabela correspondente.
@Getter // São anotações do Lombok, que geram automaticamente os métodos getters e setters para todos os atributos da classe,
@Setter // São anotações do Lombok, que geram automaticamente os métodos getters e setters para todos os atributos da classe,
@Data // essa anotação é um "pacote completo" que gera getters, setters, além de métodos como toString(), equals(), hashCode(), e um construtor padrão.
@Table(name = "clientes") // Especifica que a tabela no banco de dados que essa entidade representa se chama "clientes".

public class ClienteModel implements Serializable{ // 	Serializable - Indica que a classe pode ser convertida para bytes (serializada).
    
        private static final long serialVersionUID = 1L;
        /* serialVersionUID - é um número que serve como versão da classe para serialização. 
            Ajuda o Java a saber se a classe mudou e se pode ler os objetos antigos sem problemas.
            1L é um número long com valor 1. */

        
        // DADOS PESSOAIS CADASTRO CLIENTE
    
    // @Id - Indica que o atributo id é a chave primária da entidade. 
        //Ou seja, ele identifica unicamente cada registro na tabela do banco de dados.
        
    // @GeneratedValue(strategy = GenerationType.IDENTITY) - Diz que o valor do id será gerado automaticamente pelo 
        //banco de dados, usando a estratégia IDENTITY.    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // name = "nome" - Indica que a coluna no banco se chama nome.
    // length = 1000 - Indica o tamanho máximo da coluna, que no caso é 1000 caracteres. 
    // O atributo nullable = false - significa que essa coluna não pode aceitar valores nulos no banco de dados.
    @Column(name = "nome", nullable = false,length = 1000) 
    private String nome;
    
    @Column(name = "data_nascimento", length = 10)
    private String dataNasc;

    @Column(name = "cpf", unique = true, length = 14)
    private String cpf;
    
    @Column(name = "genero", length = 100)
    private String genero;

    @Column(name = "telefone", length = 15)
    private String telefone;
    
    @Column(name = "email", length = 1000)
    private String email;
    
    
        // DADOS PESSOAIS CADASTRO CLIENTE - ENDEREÇO
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

    public ClienteModel() {
    }

    public ClienteModel(String nome, String dataNascimento, String cpf, String genero, String telefone, String email,
                        String cep, String estado, String cidade, String bairro, String logradouro, String complemento, 
                        String numero) {
        this.nome = nome;
        this.dataNasc = dataNascimento;
        this.cpf = cpf;
        this.genero = genero;
        this.telefone = telefone;
        this.email = email;
        
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.numero = numero;
    }
    /* Um construtor é um método especial usado para criar (instanciar) objetos da classe.
        Ele tem o mesmo nome da classe e não tem tipo de retorno (não usa void nem outro tipo). 
        Serve para inicializar os atributos do objeto no momento em que ele é criado.
    O this.nome = nome; significa: o atributo nome do objeto atual recebe o valor do parâmetro nome que foi passado. */
}

/* MODEL = Representa a estrutura dos dados e regras de negócio. 
    São as classes que descrevem as entidades reais do mundo — como clientes, produtos, pedidos.
    Essa classe é um objeto que armazena todas as informações importantes sobre um cliente, como nome, data de nascimento, CPF, telefone, endereço etc.
    Em resumo, ela serve para guardar e manipular os dados de um cliente dentro do programa.
*/