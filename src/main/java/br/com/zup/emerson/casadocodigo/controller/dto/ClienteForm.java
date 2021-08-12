package br.com.zup.emerson.casadocodigo.controller.dto;

import br.com.zup.emerson.casadocodigo.model.Cliente;
import br.com.zup.emerson.casadocodigo.model.Estado;
import br.com.zup.emerson.casadocodigo.model.Pais;
import br.com.zup.emerson.casadocodigo.repository.EstadoRepository;
import br.com.zup.emerson.casadocodigo.repository.PaisRepository;
import br.com.zup.emerson.casadocodigo.validation.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class ClienteForm {


    @NotBlank
    @Email
    @UniqueValue(domainClass = Cliente.class, fieldName = "email")
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @UniqueValue(domainClass = Cliente.class, fieldName = "documento")
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    private Long paisId;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    private Long estadoId;

    public ClienteForm(String email, String nome, String sobrenome, String documento, String endereco, String complemento,
                               String cidade, Long paisId, String telefone, String cep, Long estadoId) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.paisId = paisId;
        this.telefone = telefone;
        this.cep = cep;
        this.estadoId = estadoId;
    }

    public Cliente converter(PaisRepository paisRepository, EstadoRepository estadoRepository) {
        Optional<Pais> paisObj = paisRepository.findById(this.paisId);
        @NotNull Pais pais = paisObj.get();

        Cliente cliente = new Cliente(this.email, this.nome, this.sobrenome, this.documento, this.endereco, this.complemento,
                this.cidade, pais, this.telefone, this.cep);

        if(estadoId != null) {
            Optional<Estado> estadoObj = estadoRepository.findByIdAndPaisId(this.estadoId, this.paisId);
            estadoObj.ifPresent(cliente::setEstado);
        }

        return cliente;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }
}
