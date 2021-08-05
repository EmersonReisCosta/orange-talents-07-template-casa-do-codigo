package br.com.zup.emerson.casadocodigo.validation;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Documented
@Constraint(Vali)
@Target({FIELD})
@Retention(RUNTIME)
public @interface UniqueValue {
}
