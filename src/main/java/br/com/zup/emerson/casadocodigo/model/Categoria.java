package br.com.zup.emerson.casadocodigo.model;

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

    public Categoria(Long id, @NotBlank String nome) {
        this.id = id;
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
