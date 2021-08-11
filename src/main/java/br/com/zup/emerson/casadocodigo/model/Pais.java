package br.com.zup.emerson.casadocodigo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nomePais;

    @JsonIgnore
    @OneToMany(mappedBy = "pais")
    private List<Estado> estados = new ArrayList<>();

    public Pais(String nomePais) {
        this.nomePais = nomePais;
    }

    @Deprecated
    public Pais() {
    }

    public String getNomePais() {
        return nomePais;
    }

    public Long getId() {
        return id;
    }

    public void adicionaEstado(Estado estado) {
        this.estados.add(estado);
    }
}
