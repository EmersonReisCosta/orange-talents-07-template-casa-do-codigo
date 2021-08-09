package br.com.zup.emerson.casadocodigo.controller.dto;

import br.com.zup.emerson.casadocodigo.model.Autor;
import br.com.zup.emerson.casadocodigo.model.Livro;

import java.math.BigDecimal;

public class DetalheLivroDto {

    private String titulo;
    private Autor autor;
    private BigDecimal preco;
    private String resumo;
    private String sumario;
    private String isbn;
    private Integer numeroPaginas;

    public DetalheLivroDto(Livro livro) {
        this.titulo = livro.getTitulo();
        this.autor = livro.getAutor();
        this.preco = livro.getPreco();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.isbn = livro.getIsnb();
        this.numeroPaginas = livro.getNumeroPaginas();
    }
}
