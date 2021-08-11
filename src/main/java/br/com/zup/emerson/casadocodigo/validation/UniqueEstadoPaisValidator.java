package br.com.zup.emerson.casadocodigo.validation;

import br.com.zup.emerson.casadocodigo.controller.dto.EstadoForm;
import br.com.zup.emerson.casadocodigo.model.Estado;
import br.com.zup.emerson.casadocodigo.repository.EstadoRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UniqueEstadoPaisValidator implements ConstraintValidator<UniqueEstadoPais, EstadoForm> {

    private final EstadoRepository estadoRepository;

    public UniqueEstadoPaisValidator(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    @Override
    public boolean isValid(EstadoForm value, ConstraintValidatorContext context) {
        Optional<Estado> objEstado = estadoRepository.findByNomeEstadoAndPaisId(value.getNomeEstado(), value.getPaisId());
        return !objEstado.isPresent();
    }
}
