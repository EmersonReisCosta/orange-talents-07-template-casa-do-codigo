package br.com.zup.emerson.casadocodigo.model;

import br.com.zup.emerson.casadocodigo.validation.UniqueValue;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nomeEstado;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "paisId")
    private Pais pais;


    public Estado(String nomeEstado, Pais pais) {
        this.nomeEstado = nomeEstado;
        this.pais = pais;
    }

    @Deprecated
    public Estado() {
    }

    public Long getId() {
        return id;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public Pais getPais() {
        return pais;
    }
}
