package br.com.zup.emerson.casadocodigo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @PostMapping
    public ResponseEntity<ClienteDto> cadastrar(@RequestBody @Valid ClienteForm clienteCadastroForm) {

    }

}
