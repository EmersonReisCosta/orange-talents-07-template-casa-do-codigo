package br.com.zup.emerson.casadocodigo.controller.dto;

import br.com.zup.emerson.casadocodigo.model.Pais;

import javax.validation.constraints.NotBlank;

public class PaisForm {

    @NotBlank
    private String nomePais;

    public PaisForm(String nomePais) {
        this.nomePais = nomePais;
    }

    public String getNomePais() {
        return nomePais;
    }
}
