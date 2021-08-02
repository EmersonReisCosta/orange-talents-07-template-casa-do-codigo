package br.com.zup.emerson.casadocodigo.controller;

import br.com.zup.emerson.casadocodigo.model.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

public class AutorForm {

    private Long id;


    private String nome;

    private String email;
    private String descricao;


    public Autor converter() {
        return new Autor(this.id, this.nome, this.email, this.descricao);
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }
}
