package br.otymus.curso.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_carros")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modelo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="marca_id")
    @JsonIgnore
    private Marca marca;

    private int ano;
    private String cor;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "carro_proprietario",
            joinColumns = @JoinColumn(name = "carro_id"),
            inverseJoinColumns = @JoinColumn(name = "proprietario_id")
    )

    private List<Proprietario> proprietarios;


}
