package br.com.zup.emerson.casadocodigo.controller;

import br.com.zup.emerson.casadocodigo.controller.dto.AutorForm;
import br.com.zup.emerson.casadocodigo.exception.NegocioException;
import br.com.zup.emerson.casadocodigo.model.Autor;
import br.com.zup.emerson.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    AutorRepository autorRepository;


    @PostMapping
    public ResponseEntity<Void> cadastrarAutor(@RequestBody @Validated AutorForm autorForm){
        Autor autor = autorForm.converter();
        Optional<Autor> emailExistente = autorRepository
                .findByEmail(autor.getEmail());

        if(emailExistente != null && !emailExistente.equals(autor)) {

            throw new NegocioException("Já existe um usuário com esse Email cadastrado!");
        }
        autorRepository.save(autor);
        return ResponseEntity.ok().build();
    }


}
