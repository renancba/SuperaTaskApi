package com.supera.superalist.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ListaDTO {

    private Long id;

    private String nomeLista;

    private List<TarefaDTO> tarefas;
}
