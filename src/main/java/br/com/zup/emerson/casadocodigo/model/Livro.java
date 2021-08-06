package br.com.zup.emerson.casadocodigo.model;

import br.com.zup.emerson.casadocodigo.validation.UniqueValue;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
    private String resumo;
    @Column()
    private String sumario;
    private BigDecimal preco;
    private Integer pagina;
    private String isnb;
    private LocalDate dataPublicação;



}
