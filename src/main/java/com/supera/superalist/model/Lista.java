package com.supera.superalist.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "lista")
public class Lista {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "nome_lista")
    private String nomeLista;

    @OneToMany(mappedBy = "lista", cascade = CascadeType.ALL,orphanRemoval = true )
    private List<Tarefa> tarefas = new ArrayList<>();

}
