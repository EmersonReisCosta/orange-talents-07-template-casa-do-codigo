package br.com.zup.emerson.casadocodigo.controller;

import br.com.zup.emerson.casadocodigo.controller.dto.LivroForm;
import br.com.zup.emerson.casadocodigo.model.Livro;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @PostMapping
    public String cadastro(@RequestBody @Valid LivroForm form){

        return "livro cadastrado";
    }
}
