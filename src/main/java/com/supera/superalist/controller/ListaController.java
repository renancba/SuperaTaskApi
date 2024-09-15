package com.supera.superalist.controller;

import com.supera.superalist.DTO.ListaDTO;
import jakarta.validation.Valid;
import com.supera.superalist.service.ListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/listas")
public class ListaController {


    @Autowired
    ListaService listaService;

    @GetMapping
    public ResponseEntity<Object> listar() {
        try {
            return ResponseEntity.ok(listaService.listar());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getLista(@PathVariable Long id){
        try {
            return ResponseEntity.ok(listaService.getById(id));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody @Valid ListaDTO listaDTO){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(listaService.criar(listaDTO));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editar(@RequestBody @Valid ListaDTO listaDTO, @PathVariable Long id){
        try {
            return ResponseEntity.ok(listaService.editar(listaDTO, id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        try {
            listaService.deletar(id);
            return ResponseEntity.ok("Lista com id "+id+" foi removida com sucesso!");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}