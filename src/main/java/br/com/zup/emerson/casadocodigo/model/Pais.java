package br.com.zup.emerson.casadocodigo.model;

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
}
