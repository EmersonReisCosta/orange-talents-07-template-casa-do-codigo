package br.com.zup.emerson.casadocodigo.controller.dto;

import br.com.zup.emerson.casadocodigo.model.Pais;
import br.com.zup.emerson.casadocodigo.validation.UniqueValue;

import javax.validation.constraints.NotBlank;

public class PaisForm {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nomePais")
    private String nomePais;

    public PaisForm(@NotBlank String nomePais) {
        this.nomePais = nomePais;
    }

    @Deprecated
    public PaisForm() {
    }

    public String getNomePais() {
        return nomePais;
    }
}
