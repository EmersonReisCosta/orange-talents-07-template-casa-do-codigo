package br.com.zup.emerson.casadocodigo.controller;

import br.com.zup.emerson.casadocodigo.controller.dto.EstadoForm;
import br.com.zup.emerson.casadocodigo.model.Estado;
import br.com.zup.emerson.casadocodigo.repository.EstadoRepository;
import br.com.zup.emerson.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    PaisRepository paisRepository;
    @Autowired
    EstadoRepository estadoRepository;

    @PostMapping
    public ResponseEntity<Estado> cadastraEstado(@RequestBody @Valid EstadoForm form){
        Estado estado = form.converter(paisRepository);

        estadoRepository.save(estado);
        return ResponseEntity.ok(estado);
    }
}
