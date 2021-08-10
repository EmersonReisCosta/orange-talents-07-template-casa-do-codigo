package br.com.zup.emerson.casadocodigo.controller;

import br.com.zup.emerson.casadocodigo.controller.dto.DetalheLivroDto;
import br.com.zup.emerson.casadocodigo.controller.dto.LivroDto;
import br.com.zup.emerson.casadocodigo.controller.dto.LivroForm;

import br.com.zup.emerson.casadocodigo.model.Livro;
import br.com.zup.emerson.casadocodigo.repository.AutorRepository;
import br.com.zup.emerson.casadocodigo.repository.CategoriaRepository;
import br.com.zup.emerson.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid LivroForm form){

        Livro livro = form.converter(autorRepository, categoriaRepository);
        livroRepository.save(livro);


        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<LivroDto> listar(){
        List<Livro> livros = livroRepository.findAll();

        List<LivroDto> livrosDtos = LivroDto.converter(livros);
        return livrosDtos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> exibir(@PathVariable Long id){
        Optional<Livro> livro = livroRepository.findById(id);

        if (livro.isPresent()){
            Livro livroConvertido = livro.get();
            DetalheLivroDto detalheLivroDto = new DetalheLivroDto(livroConvertido);
            return ResponseEntity.ok().body(detalheLivroDto);
        }
        return ResponseEntity.notFound().build();
    }
}
