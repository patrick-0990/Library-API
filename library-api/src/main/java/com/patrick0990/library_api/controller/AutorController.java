package com.patrick0990.library_api.controller;


import com.patrick0990.library_api.dto.AutorDTO;
import com.patrick0990.library_api.service.AutorService;
import com.patrick0990.library_api.model.Autor;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private static final Logger log = LoggerFactory.getLogger(AutorController.class);
    @Autowired
    private AutorService service;

    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody @Valid AutorDTO dto){

        Autor autorSalvo = service.salvar(dto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(autorSalvo.getId())
                .toUri();

        return ResponseEntity.created(location).body(autorSalvo);

    }


}
