package br.com.zup.emerson.casadocodigo.controller;

import br.com.zup.emerson.casadocodigo.controller.dto.ClienteDto;
import br.com.zup.emerson.casadocodigo.controller.dto.ClienteForm;
import br.com.zup.emerson.casadocodigo.model.Cliente;
import br.com.zup.emerson.casadocodigo.repository.ClienteRepository;
import br.com.zup.emerson.casadocodigo.repository.EstadoRepository;
import br.com.zup.emerson.casadocodigo.repository.PaisRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteRepository repository;
    private PaisRepository paisRepository;
    private EstadoRepository estadoRepository;

    @PostMapping
    public ResponseEntity<ClienteDto> cadastrar(@RequestBody @Valid ClienteForm clienteCadastroForm) {
        Cliente cliente = clienteCadastroForm.converter(paisRepository, estadoRepository);
        repository.save(cliente);
        return ResponseEntity.ok().body(new ClienteDto(cliente.getId()));
    }

}
