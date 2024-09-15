package com.supera.superalist.model;

import com.supera.superalist.Enum.TarefaStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tarefa")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "data")
    private Date data;

    @Enumerated(EnumType.STRING)
    private TarefaStatus status;

    @ManyToOne
    @JoinColumn(name = "lista_id")
    private Lista lista;
}
