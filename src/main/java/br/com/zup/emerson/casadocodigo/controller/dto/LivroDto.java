package br.com.zup.emerson.casadocodigo.controller.dto;

import br.com.zup.emerson.casadocodigo.model.Livro;
import br.com.zup.emerson.casadocodigo.repository.LivroRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LivroDto {

    private Long id;
    private String titulo;

    public void converter(List<Livro> livros) {
       
                                                          
    }

    public LivroDto(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }
}
