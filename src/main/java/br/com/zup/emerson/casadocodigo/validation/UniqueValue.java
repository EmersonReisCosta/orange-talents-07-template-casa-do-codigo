package br.com.zup.emerson.casadocodigo.validation;

import javax.validation.Constraint;
import java.lang.annotation.*;
import java.lang.reflect.Field;

import javax.validation.Constraint;
import javax.validation.Payload;


@Documented
@Constraint()
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface UniqueValue {
    public String message() default "O campo deve ser unico";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default{};
    String fieldName();
    Class<?> domainClass();
}
