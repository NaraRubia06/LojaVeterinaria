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

/** @author Nara Rubia B. Balena  */

@Entity
@Getter
@Setter
@Data
@Table(name = "consulta")

public class ConsultaModel implements Serializable {
    
     private static final long serialVersionUID = 1L;
        
    // DADOS PARA CADASTRO DA CONSULTA.
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "animal", length = 1000)
    private String animal;

    @Column(name = "tutor",  length = 1000)
    private String tutor;
    
    @Column(name = "veterinario", length = 1000)
    private String veterinario;

    @Column(name = "dataConsulta",  length = 10)
    private String dataConsulta;

    @Column(name = "horaConsulta", length = 10)
    private String horaConsulta;
    
    @Column(name = "statusConsulta", length = 1000)
    private String statusConsulta;
    
    @Column(name = "motivoConsulta", length = 1000)
    private String motivoConsulta;
    
    @Column(name = "observacao", length = 1000)
    private String observacao;
    

    public ConsultaModel() {
    }

    public ConsultaModel(String animal, String tutor, String veterinario, String dataConsulta,
                        String horaConsulta, String statusConsulta, String motivoConsulta, String observacao) {

        this.animal = animal;
        this.tutor = tutor;
        this.veterinario = veterinario;
        this.dataConsulta = dataConsulta;
        this.horaConsulta = horaConsulta;
        this.statusConsulta = statusConsulta;
        this.motivoConsulta = motivoConsulta;
        this.observacao = observacao;
    }
    
}