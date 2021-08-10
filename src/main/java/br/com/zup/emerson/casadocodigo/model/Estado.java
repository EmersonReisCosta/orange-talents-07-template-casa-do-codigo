package br.com.zup.emerson.casadocodigo.model;

import br.com.zup.emerson.casadocodigo.validation.UniqueValue;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nomeEstado;

    @ManyToOne
    @JoinColumn(name = "paisId")
    private Pais pais;
}
