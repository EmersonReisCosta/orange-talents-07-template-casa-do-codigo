package br.com.zup.emerson.casadocodigo.repository;

import br.com.zup.emerson.casadocodigo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
