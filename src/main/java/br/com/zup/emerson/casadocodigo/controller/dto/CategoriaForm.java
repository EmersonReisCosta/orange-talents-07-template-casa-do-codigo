package br.com.zup.emerson.casadocodigo.controller.dto;

import br.com.zup.emerson.casadocodigo.model.Categoria;
import br.com.zup.emerson.casadocodigo.validation.UniqueValue;


import javax.annotation.ManagedBean;
import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import javax.validation.constraints.NotBlank;

public class CategoriaForm {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public CategoriaForm( @NotBlank String nome) {

        this.nome = nome;
    }

    @Deprecated
    public CategoriaForm(){

    }
    public String getNome() {
        return nome;
    }

}
