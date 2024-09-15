package com.supera.superalist.controller;

import com.supera.superalist.DTO.TarefaDTO;
import com.supera.superalist.service.TarefaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class TarefaControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private TarefaController tarefaController;

    @Mock
    private TarefaService tarefaService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(tarefaController).build();
    }

    @Test
    public void testListar() {
        TarefaDTO tarefaDTO1 = new TarefaDTO();
        tarefaDTO1.setId(1L);
        tarefaDTO1.setNome("Tarefa 1");
        tarefaDTO1.setDescricao("Descrição da Tarefa 1");

        TarefaDTO tarefaDTO2 = new TarefaDTO();
        tarefaDTO2.setId(2L);
        tarefaDTO2.setNome("Tarefa 2");
        tarefaDTO2.setDescricao("Descrição da Tarefa 2");

        List<TarefaDTO> tarefas = Arrays.asList(tarefaDTO1, tarefaDTO2);

        when(tarefaService.listar()).thenReturn(tarefas);

        ResponseEntity<Object> response = tarefaController.listar();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(tarefas, response.getBody());

        verify(tarefaService, times(1)).listar();
    }

    @Test
    public void testGetTarefa() {
        TarefaDTO tarefaDTO = new TarefaDTO();
        tarefaDTO.setId(1L);
        tarefaDTO.setNome("Tarefa 1");
        tarefaDTO.setDescricao("Descrição da Tarefa 1");

        when(tarefaService.getById(anyLong())).thenReturn(tarefaDTO);

        ResponseEntity<Object> response = tarefaController.getTarefa(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(tarefaDTO, response.getBody());

        verify(tarefaService, times(1)).getById(anyLong());
    }

    @Test
    public void testCriar() {
        TarefaDTO tarefaDTO = new TarefaDTO();
        tarefaDTO.setNome("Nova Tarefa");
        tarefaDTO.setDescricao("Descrição da Nova Tarefa");

        when(tarefaService.criar(any(TarefaDTO.class))).thenReturn(tarefaDTO);

        ResponseEntity<Object> response = tarefaController.criar(tarefaDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(tarefaDTO, response.getBody());

        verify(tarefaService, times(1)).criar(any(TarefaDTO.class));
    }

    @Test
    public void testEditar() {
        TarefaDTO tarefaDTO = new TarefaDTO();
        tarefaDTO.setNome("Tarefa Atualizada");
        tarefaDTO.setDescricao("Descrição Atualizada da Tarefa");

        // Mock do método editar()
        when(tarefaService.editar(any(TarefaDTO.class), anyLong())).thenReturn(tarefaDTO);

        ResponseEntity<Object> response = tarefaController.editar(tarefaDTO, 1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(tarefaDTO, response.getBody());

        verify(tarefaService, times(1)).editar(any(TarefaDTO.class), anyLong());
    }

    @Test
    public void testDelete() {
        ResponseEntity<Object> response = tarefaController.delete(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Tarefa com id 1 foi removida com sucesso!", response.getBody());

        verify(tarefaService, times(1)).deletar(anyLong());
    }
}
