package br.com.zup.emerson.casadocodigo.controller;


import br.com.zup.emerson.casadocodigo.controller.dto.PaisForm;
import br.com.zup.emerson.casadocodigo.model.Pais;
import br.com.zup.emerson.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity<Pais> cadastrarPais(@RequestBody @Valid PaisForm form){
        Pais pais = new Pais(form.getNomePais());

        paisRepository.save(pais);
        return ResponseEntity.ok().body(pais);
    }
}
