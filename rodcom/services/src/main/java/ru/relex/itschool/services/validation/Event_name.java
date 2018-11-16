package ru.relex.itschool.services.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EventName.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Event_name {
    String message() default "EventName";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
