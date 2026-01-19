package com.patrick0990.library_api.service;

import  com.patrick0990.library_api.model.Autor;
import  com.patrick0990.library_api.dto.AutorDTO;
import  com.patrick0990.library_api.controller.AutorController;
import com.patrick0990.library_api.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
import java.util.List;

import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository repository;

    public Autor salvar(AutorDTO dto){
        Autor autor = new Autor();
        autor.setNome(dto.getNome());
        autor.setNacionalidade(dto.getNacionalidade());

        return repository.save(autor);

    }

    public List<Autor> listar(){
        return repository.findAll();
    }

    public Optional<Autor> obterPorId(UUID id){
        return repository.findById(id);
    }

}
