package br.com.zup.emerson.casadocodigo.controller.dto;

import br.com.zup.emerson.casadocodigo.model.Autor;
import br.com.zup.emerson.casadocodigo.model.Estado;
import br.com.zup.emerson.casadocodigo.model.Pais;
import br.com.zup.emerson.casadocodigo.repository.EstadoRepository;
import br.com.zup.emerson.casadocodigo.repository.PaisRepository;
import br.com.zup.emerson.casadocodigo.validation.UniqueValue;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class EstadoForm {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nomePais")
    private String nomeEstado;

    private Pais pais;

    public EstadoForm(String nomeEstado, Pais pais) {
        this.nomeEstado = nomeEstado;
        this.pais = pais;
    }

    @Deprecated
    public EstadoForm() {
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public Pais getPais() {
        return pais;
    }

    public Estado converter(PaisRepository paisRepository){
        Optional<Pais> paisObj = paisRepository.findById(this.pais.getId());

        @NotNull Pais pais = paisObj.get();
        return new Estado(this.nomeEstado, this.pais);
    }
}
