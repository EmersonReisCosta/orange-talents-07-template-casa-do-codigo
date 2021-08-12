package br.com.zup.emerson.casadocodigo.repository;

import br.com.zup.emerson.casadocodigo.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
    Optional<Estado> findByNomeEstadoAndPaisId(String nomeEstado, Long id);

    Optional<Estado> findByIdAndPaisId(Long estadoId, Long paisId);
}
