package br.com.zup.emerson.casadocodigo.controller;

import br.com.zup.emerson.casadocodigo.exception.NegocioException;
import br.com.zup.emerson.casadocodigo.model.Categoria;
import br.com.zup.emerson.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity<Categoria> cadastraCategoria(@RequestBody @Valid Categoria categoria){
//        Categoria categoria = form.converter();
        Optional<Categoria> verificaNome = categoriaRepository.findByNome(categoria.getNome());
        if (verificaNome != null && !verificaNome.equals(categoria.getNome())){
            throw new NegocioException("A categoria já está cadastrada!");
        }
        categoriaRepository.save(categoria);
        return ResponseEntity.ok().body(categoria);
    }
}