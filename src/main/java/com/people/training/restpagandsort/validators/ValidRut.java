package com.people.training.restpagandsort.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {RutValidator.class})
@Documented
public @interface ValidRut {
    String message() default "Invalid student rut";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
