package br.com.zup.emerson.casadocodigo.controller.dto;

import br.com.zup.emerson.casadocodigo.model.Autor;
import br.com.zup.emerson.casadocodigo.model.Categoria;
import br.com.zup.emerson.casadocodigo.model.Livro;
import br.com.zup.emerson.casadocodigo.repository.AutorRepository;
import br.com.zup.emerson.casadocodigo.repository.CategoriaRepository;
import br.com.zup.emerson.casadocodigo.validation.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public class LivroForm {


    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @Size(max = 500)
    @NotBlank
    private String resumo;

    @NotBlank
    private String sumario;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @NotNull
    @Min(100)
    private Integer numeroPaginas;

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "isnb")
    private String isnb;

    @NotNull
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "autorId")
    private Autor autor;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "categoriaId")
    private Categoria categoria;

    public LivroForm(String titulo, String resumo, String sumario, BigDecimal preco, Integer numeroPaginas, String isnb, LocalDate dataPublicação, Autor autor, Categoria categoria) {

        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isnb = isnb;
        this.dataPublicacao = dataPublicacao;
        this.autor = autor;
        this.categoria = categoria;
    }

    public Livro converter(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        Optional<Autor> autorObj = autorRepository.findById(this.autor.getId());
        Optional<Categoria> categoriaObj = categoriaRepository.findById(this.categoria.getId());

        @NotNull Autor autor = autorObj.get();
        @NotNull Categoria categoria = categoriaObj.get();

        return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.numeroPaginas, this.isnb, this.dataPublicacao, this.autor, this.categoria);
    }


}
