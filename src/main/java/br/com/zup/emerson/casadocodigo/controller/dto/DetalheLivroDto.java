package br.com.zup.emerson.casadocodigo.controller.dto;

import br.com.zup.emerson.casadocodigo.model.Autor;
import br.com.zup.emerson.casadocodigo.model.Livro;
import br.com.zup.emerson.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DetalheLivroDto {
    @Autowired
    private LivroRepository livroRepository;
    private String titulo;
    private String autor;
    private BigDecimal preco;
    private String resumo;
    private String sumario;
    private String isbn;
    private Integer numeroPaginas;

    public DetalheLivroDto(Livro livro) {
        this.titulo = livro.getTitulo();
        this.autor = livro.getAutor().getNome();
        this.preco = livro.getPreco();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.isbn = livro.getIsnb();
        this.numeroPaginas = livro.getNumeroPaginas();
    }

    @Deprecated
    public DetalheLivroDto() {}

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }


}
