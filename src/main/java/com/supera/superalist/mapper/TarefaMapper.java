package com.supera.superalist.mapper;

import com.supera.superalist.DTO.TarefaDTO;
import com.supera.superalist.model.Tarefa;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TarefaMapper {

    public Tarefa updateTarefa(TarefaDTO tarefa){
        Tarefa tarefaEntity = new Tarefa();
        tarefaEntity.setId(tarefa.getId());
        tarefaEntity.setNome(tarefa.getNome());
        tarefaEntity.setDescricao(tarefa.getDescricao());
        tarefaEntity.setData(tarefa.getData());
        tarefaEntity.setStatus(tarefa.getStatus());
        return tarefaEntity;
    }

    public TarefaDTO updateTarefa(Tarefa tarefa){
        TarefaDTO tarefaDTO= new TarefaDTO();
        tarefaDTO.setId(tarefa.getId());
        tarefaDTO.setNome(tarefa.getNome());
        tarefaDTO.setDescricao(tarefa.getDescricao());
        tarefaDTO.setData(tarefa.getData());
        tarefaDTO.setStatus(tarefa.getStatus());
        return tarefaDTO;
    }

    public List<Tarefa> updateListTarefaDTO(List<TarefaDTO> listEditoraDTO){
        return listEditoraDTO.stream()
                .map(this::updateTarefa)
                .toList();
    }

    public List<TarefaDTO> updateListTarefaEntity(List<Tarefa> listEditoraEntity){
        return listEditoraEntity.stream()
                .map(this::updateTarefa)
                .toList();
    }
}
