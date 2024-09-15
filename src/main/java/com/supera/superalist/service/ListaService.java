package com.supera.superalist.service;

import com.supera.superalist.DTO.ListaDTO;
import com.supera.superalist.mapper.ListaMapper;
import com.supera.superalist.model.Lista;
import com.supera.superalist.repository.ListaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListaService {

    @Autowired
    ListaRepository listaRepository;

    @Autowired
    ListaMapper listaMapper;

    public List<ListaDTO> listar(){
        return listaMapper.updateListaEntity(listaRepository.findAll());
    }

    public ListaDTO getById(Long id){
        Optional<Lista> listaOptional = listaRepository.findById(id);

        if (listaOptional.isPresent()){
            return listaMapper.updateLista(listaOptional.get());
        }

        throw new EntityNotFoundException("Lista não encontrada.");
    }

    public void deletar(Long id){
        Optional<Lista> listaOptional = listaRepository.findById(id);

        listaOptional.ifPresent(lista -> listaRepository.delete(lista));

        throw new EntityNotFoundException("Lista não encontrada.");
    }

    public ListaDTO editar(ListaDTO listaDTO, Long id){
        if (listaRepository.existsById(id)){
            Lista listaEntity = listaMapper.updateLista(listaDTO);
            listaEntity.setId(listaDTO.getId());
            Lista listaSave = listaRepository.save(listaEntity);
            return listaMapper.updateLista(listaSave);
        }
        throw new EntityNotFoundException("Lista não encontrada.");
    }

    public ListaDTO criar(ListaDTO listaDTO){
        Lista listaSave = listaRepository.save(listaMapper.updateLista(listaDTO));
        return listaMapper.updateLista(listaSave);
    }
}