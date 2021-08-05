package br.com.zup.emerson.casadocodigo.controller.dto;

import br.com.zup.emerson.casadocodigo.model.Categoria;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

public class CategoriaForm {

    private Long id;

    @NotBlank
    private String nome;

    public CategoriaForm(Long id, @NotBlank String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Deprecated
    public CategoriaForm(){

    }
    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    public Categoria converter(){
        return new Categoria(this.id ,this.nome);
    }
}
