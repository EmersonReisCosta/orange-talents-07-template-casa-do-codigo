package br.com.zup.emerson.casadocodigo.controller;

import br.com.zup.emerson.casadocodigo.controller.dto.AutorDto;
import br.com.zup.emerson.casadocodigo.model.Autor;
import br.com.zup.emerson.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    AutorRepository autorRepository;


    @PostMapping
    public Autor cadastrarAutor(@RequestBody @Valid AutorForm autorForm, Errors errors){
        Autor autor = autorForm.converter();
        validaEmail(autor, errors);
        autorRepository.save(autor);
        return autor;
    }

    public void validaEmail(Autor autor, Errors errors){

        if (errors.hasErrors()){
            return;
        }

        Optional<Autor> emailExistente = autorRepository
                .findByEmail(autor.getEmail());

        if(emailExistente != null && !emailExistente.equals(autor)) {
            errors.rejectValue("email", null,
                    "Já existe um(a) outro(a) autor(a) com o mesmo email "
                            + autor.getEmail());
        }
    }

}
