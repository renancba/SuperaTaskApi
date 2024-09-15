package com.supera.superalist.mapper;

import com.supera.superalist.DTO.ListaDTO;
import com.supera.superalist.model.Lista;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListaMapper {

    public Lista updateLista(ListaDTO lista){
        Lista categoriaEntity = new Lista();
        categoriaEntity.setId(lista.getId());
        categoriaEntity.setNomeLista(lista.getNomeLista());
        return categoriaEntity;
    }

    public ListaDTO updateLista(Lista lista){
        ListaDTO listaDTO = new ListaDTO();
        listaDTO.setId(lista.getId());
        listaDTO.setNomeLista(lista.getNomeLista());
        return listaDTO;
    }

    public List<Lista> updateListaDTO(List<ListaDTO> listCategoriaDTO){
        return listCategoriaDTO.stream()
                .map(this::updateLista)
                .toList();
    }

    public List<ListaDTO> updateListaEntity(List<Lista> listCategoriaEntity){
        return listCategoriaEntity.stream()
                .map(this::updateLista)
                .toList();
    }

}
