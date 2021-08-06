package br.com.zup.emerson.casadocodigo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String nome;
    //    O Json Ignore resolve o problema de recursividade do código.
    @JsonIgnore
    @OneToMany(mappedBy = "categoria")
    private List<Livro> livros = new ArrayList<>();

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
