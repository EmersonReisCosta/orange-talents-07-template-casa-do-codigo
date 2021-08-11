package br.com.zup.emerson.casadocodigo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueEstadoPaisValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE})
public @interface UniqueEstadoPais {
    String message() default "Já existe um estado com esse nome para o país informado";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
