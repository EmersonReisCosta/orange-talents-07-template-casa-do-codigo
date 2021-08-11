package br.com.zup.emerson.casadocodigo.repository;

import br.com.zup.emerson.casadocodigo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
