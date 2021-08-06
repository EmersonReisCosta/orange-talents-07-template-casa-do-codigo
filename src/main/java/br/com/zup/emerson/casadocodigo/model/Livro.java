package br.com.zup.emerson.casadocodigo.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String titulo;
    @Size(max = 500)
    @NotBlank
    private String resumo;
    @NotBlank
    private String sumario;
    @NotNull
    @Min(20)
    private BigDecimal preco;
    @Min(100)
    private Integer numeroPaginas;
    @NotBlank
    private String isnb;
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicação;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "autorId")
    private Autor autor;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "categoriaId")
    private Categoria categoria;



}
