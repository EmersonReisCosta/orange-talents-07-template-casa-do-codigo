package br.com.zup.emerson.casadocodigo.controller;

import br.com.zup.emerson.casadocodigo.controller.dto.AutorForm;
//import br.com.zup.emerson.casadocodigo.exception.NegocioException;
import br.com.zup.emerson.casadocodigo.model.Autor;
import br.com.zup.emerson.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    AutorRepository autorRepository;


    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrarAutor(@RequestBody @Valid AutorForm autorForm){
        Autor autor = autorForm.converter();

        autorRepository.save(autor);
        return ResponseEntity.ok().build();
    }


}
