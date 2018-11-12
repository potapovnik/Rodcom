package ru.relex.itschool.services.validation;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EventName implements ConstraintValidator<Event_name,String> {
    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        if (name.length()<10){return false;}
        return true;
    }
}
