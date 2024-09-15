package com.supera.superalist.controller;

import com.supera.superalist.DTO.ListaDTO;
import com.supera.superalist.service.ListaService;
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

public class ListaControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private ListaController listaController;

    @Mock
    private ListaService listaService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(listaController).build();
    }

    @Test
    public void testListar() {
        ListaDTO listaDTO1 = new ListaDTO();
        listaDTO1.setId(1L);
        listaDTO1.setNomeLista("Lista 1");

        ListaDTO listaDTO2 = new ListaDTO();
        listaDTO2.setId(2L);
        listaDTO2.setNomeLista("Lista 2");

        List<ListaDTO> listas = Arrays.asList(listaDTO1, listaDTO2);

        when(listaService.listar()).thenReturn(listas);

        ResponseEntity<Object> response = listaController.listar();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(listas, response.getBody());

        verify(listaService, times(1)).listar();
    }

    @Test
    public void testGetLista() {
        ListaDTO listaDTO = new ListaDTO();
        listaDTO.setId(1L);
        listaDTO.setNomeLista("Lista 1");

        when(listaService.getById(anyLong())).thenReturn(listaDTO);

        ResponseEntity<Object> response = listaController.getLista(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(listaDTO, response.getBody());

        verify(listaService, times(1)).getById(anyLong());
    }

    @Test
    public void testCriar() {
        ListaDTO listaDTO = new ListaDTO();
        listaDTO.setNomeLista("Nova Lista");

        when(listaService.criar(any(ListaDTO.class))).thenReturn(listaDTO);

        ResponseEntity<Object> response = listaController.criar(listaDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(listaDTO, response.getBody());

        verify(listaService, times(1)).criar(any(ListaDTO.class));
    }

    @Test
    public void testEditar() {
        ListaDTO listaDTO = new ListaDTO();
        listaDTO.setNomeLista("Lista Atualizada");

        when(listaService.editar(any(ListaDTO.class), anyLong())).thenReturn(listaDTO);

        ResponseEntity<Object> response = listaController.editar(listaDTO, 1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(listaDTO, response.getBody());

        verify(listaService, times(1)).editar(any(ListaDTO.class), anyLong());
    }

    @Test
    public void testDelete() {
        ResponseEntity<Object> response = listaController.delete(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Lista com id 1 foi removida com sucesso!", response.getBody());

        verify(listaService, times(1)).deletar(anyLong());
    }
}
