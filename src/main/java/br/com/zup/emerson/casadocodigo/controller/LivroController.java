package br.com.zup.emerson.casadocodigo.controller;

import br.com.zup.emerson.casadocodigo.controller.dto.LivroForm;

import br.com.zup.emerson.casadocodigo.model.Livro;
import br.com.zup.emerson.casadocodigo.repository.AutorRepository;
import br.com.zup.emerson.casadocodigo.repository.CategoriaRepository;
import br.com.zup.emerson.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    LivroRepository livroRepository;
    @Autowired
    AutorRepository autorRepository;
    @Autowired
    CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity<Void> cadastro(@RequestBody @Valid LivroForm form){

        Livro livro = form.converter(autorRepository, categoriaRepository);
        livroRepository.save(livro);


        return ResponseEntity.ok().build();
    }
}
