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

@Entity
@Getter
@Setter
@Data
@Table(name = "animal")

public class AnimalModel implements Serializable {

    private static final long serialVersionUID = 1L;
    
    // DADOS PARA CADASTRO DO ANIMAL.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 1000)
    private String nome;

    @Column(name = "especie", length = 1000)
    private String especie;

    @Column(name = "raca", length = 1000)
    private String raca;

    @Column(name = "sexo", length = 1000)
    private String sexo;

    @Column(name = "idade", length = 1000)
    private String idade;

    @Column(name = "dataNascimento", length = 10)
    private String dataNascimento;

    @Column(name = "peso", length = 1000)
    private String peso;

    @Column(name = "cor", length = 1000)
    private String cor;

    @Column(name = "nomeTutor", length = 1000)
    private String nomeTutor;

    @Column(name = "observacao", length = 1000)
    private String observacao;

    public AnimalModel() {
    }

    public AnimalModel(String nome, String especie, String raca, String sexo,
                       String idade, String dataNascimento, String peso,
                       String cor, String nomeTutor, String observacao) {

        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.sexo = sexo;
        this.idade = idade;
        this.dataNascimento = dataNascimento;
        this.peso = peso;
        this.cor = cor;
        this.nomeTutor = nomeTutor;
        this.observacao = observacao;
    }
}