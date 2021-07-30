package br.com.zup.emerson.casadocodigo.controller;

import br.com.zup.emerson.casadocodigo.controller.dto.AutorDto;
import br.com.zup.emerson.casadocodigo.model.Autor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @PostMapping
    public ResponseEntity<AutorDto> cadastrarAutor(@RequestBody @Valid AutorForm autor){

        return ResponseEntity.ok().build();
    }

}
