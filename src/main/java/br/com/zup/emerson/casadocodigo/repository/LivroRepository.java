package br.com.zup.emerson.casadocodigo.repository;

import br.com.zup.emerson.casadocodigo.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
