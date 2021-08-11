package br.com.zup.emerson.casadocodigo.controller.dto;

import br.com.zup.emerson.casadocodigo.model.Estado;
import br.com.zup.emerson.casadocodigo.model.Pais;

import br.com.zup.emerson.casadocodigo.repository.PaisRepository;
import br.com.zup.emerson.casadocodigo.validation.UniqueEstadoPais;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@UniqueEstadoPais
public class EstadoForm {

    @NotBlank

    private String nomeEstado;

    private Pais pais;

    @NotNull
    private Long paisId = pais.getId();

    public EstadoForm(String nomeEstado, Pais pais) {
        this.nomeEstado = nomeEstado;
        this.pais = pais;
    }

    @Deprecated
    public EstadoForm() {
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public Long getPaisId() {

        return paisId;
    }


    public Estado converter(PaisRepository paisRepository){
        Optional<Pais> paisObj = paisRepository.findById(pais.getId());
        @NotNull Pais pais = paisObj.get();

        Estado estado = new Estado(nomeEstado, pais);
        pais.adicionaEstado(estado);
        return estado;
    }


//    public Estado converter(PaisRepository paisRepository) {
//        Optional<Pais> objPais = paisRepository.findById(pais.getId());
//        @NotBlank Pais pais = objPais.get();
//        Estado estado = new Estado(nomeEstado, pais);
//        pais.adicionaEstado(estado);
//        return estado;
//    }


}
