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
    private String nomeEstado;

    @OneToMany(mappedBy = "pais")
    private List<Estado> estados = new ArrayList<>();

    public Pais(String nomeEstado, List<Estado> estados) {
        this.nomeEstado = nomeEstado;
        this.estados = estados;
    }

    @Deprecated
    public Pais() {
    }
}
