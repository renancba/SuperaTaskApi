package com.supera.superalist.service;

import com.supera.superalist.DTO.TarefaDTO;
import com.supera.superalist.Enum.TarefaStatus;
import com.supera.superalist.mapper.TarefaMapper;
import com.supera.superalist.model.Tarefa;
import com.supera.superalist.repository.TarefaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private TarefaMapper tarefaMapper;

    public List<TarefaDTO> listar() {
        return tarefaMapper.updateListTarefaEntity(tarefaRepository.findAll());
    }

    public TarefaDTO getById(Long id) {
        Optional<Tarefa> tarefaOptional = tarefaRepository.findById(id);
        if (tarefaOptional.isPresent()) {
            return tarefaMapper.updateTarefa(tarefaOptional.get());
        }
        throw new EntityNotFoundException("Tarefa não encontrada.");
    }

    public List<TarefaDTO> tarefaPorStatus(TarefaStatus status) {
        return tarefaMapper.updateListTarefaEntity(tarefaRepository.findTarefaByTarefaStatus(status));
    }

    public TarefaDTO criar(TarefaDTO tarefa) {
        Tarefa tarefaSave = tarefaRepository.save(tarefaMapper.updateTarefa(tarefa));
        return tarefaMapper.updateTarefa(tarefaSave);
    }

    public void deletar(Long id){
        Optional<Tarefa> tarefaOptional = tarefaRepository.findById(id);
        if (tarefaOptional.isPresent()) {
            tarefaRepository.deleteById(id);
        }
        throw new EntityNotFoundException("Tarefa não encontrada.");
    }

    public TarefaDTO editar(TarefaDTO tarefaDTO, Long id){
        if (tarefaRepository.existsById(id)){
            Tarefa tarefa = tarefaMapper.updateTarefa(tarefaDTO);
            tarefa.setId(tarefaDTO.getId());
            tarefaRepository.save(tarefa);
            return tarefaMapper.updateTarefa(tarefa);
        }
        throw new EntityNotFoundException("Tarefa não encontrada.");
    }
}
