package br.com.zup.emerson.casadocodigo.controller.dto;

import br.com.zup.emerson.casadocodigo.model.Estado;
import br.com.zup.emerson.casadocodigo.model.Pais;
import br.com.zup.emerson.casadocodigo.validation.UniqueValue;

import javax.validation.constraints.NotBlank;

public class EstadoForm {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nomePais")
    private String nomeEstado;

    private Pais pais;

    public EstadoForm(Estado estado) {
        this.nomeEstado = estado.getNomeEstado();
        this.pais = estado.getPais();
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
}
