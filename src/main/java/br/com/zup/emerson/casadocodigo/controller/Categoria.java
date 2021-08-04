package br.com.zup.emerson.casadocodigo.controller;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String nome;

    public Categoria(@NotBlank String nome) {
        this.nome = nome;
    }

    @Deprecated
    public Categoria() {}

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
