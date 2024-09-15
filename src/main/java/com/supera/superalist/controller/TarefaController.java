package com.supera.superalist.controller;

import com.supera.superalist.DTO.TarefaDTO;
import com.supera.superalist.Enum.TarefaStatus;
import com.supera.superalist.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    @Autowired
    TarefaService tarefaService;

    @GetMapping
    public ResponseEntity<Object> listar() {
        try {
            return ResponseEntity.ok(tarefaService.listar());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @GetMapping("/{status}")
    public ResponseEntity<Object> listarStatus(@PathVariable("status") TarefaStatus status) {
        try {
            return ResponseEntity.ok(tarefaService.tarefaPorStatus(status));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTarefa(@PathVariable Long id){
        try {
            return ResponseEntity.ok(tarefaService.getById(id));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody @Valid TarefaDTO tarefaDTO){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(tarefaService.criar(tarefaDTO));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editar(@RequestBody @Valid TarefaDTO tarefaDTO, @PathVariable Long id){
        try {
            return ResponseEntity.ok(tarefaService.editar(tarefaDTO, id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        try {
            tarefaService.deletar(id);
            return ResponseEntity.ok("Tarefa com id "+id+" foi removida com sucesso!");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
