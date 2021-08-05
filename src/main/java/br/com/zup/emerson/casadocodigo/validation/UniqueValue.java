package br.com.zup.emerson.casadocodigo.validation;

import javax.validation.Constraint;
import java.lang.annotation.*;

import javax.validation.Payload;


@Documented
@Constraint(validatedBy = UniqueValueValidation.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface UniqueValue {
    public String message() default "{br.com.zup.emerson.casadocodigo.validation.uniquevalue}";

    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default{};
    String fieldName();
    Class<?> domainClass();
}
