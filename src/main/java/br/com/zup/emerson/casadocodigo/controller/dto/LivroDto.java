package br.com.zup.emerson.casadocodigo.controller.dto;

import br.com.zup.emerson.casadocodigo.model.Livro;
import br.com.zup.emerson.casadocodigo.repository.LivroRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LivroDto {

    private Long id;
    private String titulo;

    public LivroDto(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }



    public static List<LivroDto> converter(List<Livro> livros) {
        List<LivroDto> livroDtos = new ArrayList<>();
        livroDtos.addAll(livros.stream().map(livro -> new LivroDto(livro.getId(), livro.getTitulo())).collect(Collectors.toList()));
        return livroDtos;
    }

    @Deprecated
    public LivroDto() {
    }



}
