package br.com.zup.emerson.casadocodigo.controller.dto;

import br.com.zup.emerson.casadocodigo.model.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

public class AutorDto {
    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Max(value = 400)
    private String descricao;

    public AutorDto(Autor autor) {
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
        this.email = autor.getEmail();
    }

}
