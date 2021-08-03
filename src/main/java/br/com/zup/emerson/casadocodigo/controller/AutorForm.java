package br.com.zup.emerson.casadocodigo.controller;

import br.com.zup.emerson.casadocodigo.model.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorForm {

    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(max = 400)
    private String descricao;

    public AutorForm(@NotBlank String nome,
                            @NotBlank @Email String email,
                            @NotBlank @Size(max = 400) String descricao) {
        super();
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor converter() {
        return new Autor(this.nome,this.email,this.descricao);
    }

    public String getEmail() {
        return this.email;
    }

}
