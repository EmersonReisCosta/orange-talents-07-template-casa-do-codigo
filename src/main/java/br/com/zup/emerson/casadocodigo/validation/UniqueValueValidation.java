package br.com.zup.emerson.casadocodigo.validation;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueValidation implements ConstraintValidator<UniqueValue, String> {

private String atributo;
private Class<?> classe;

@PersistenceContext
private EntityManager entityManager;

@Override
public void initialize(UniqueValue constraintAnnotation) {
        this.atributo = constraintAnnotation.fieldName();
        this.classe = constraintAnnotation.domainClass();
}


@Override
public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        Query query = entityManager.createQuery("SELECT 1 FROM " + classe.getName() + " WHERE " + atributo + " = :value");
        query.setParameter("value", value);
        List<?> lista = query.getResultList();
        Assert.state(lista.size() <= 1, "Foi encontrada mais de uma "+classe+" com o atributo "+atributo+" = "+ value);
        return lista.isEmpty();
        }
}
