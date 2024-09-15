package com.supera.superalist.repository;

import com.supera.superalist.Enum.TarefaStatus;
import com.supera.superalist.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    List<Tarefa> findTarefaByTarefaStatus(TarefaStatus status);
}
