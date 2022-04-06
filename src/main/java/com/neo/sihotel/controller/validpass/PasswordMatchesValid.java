package com.neo.sihotel.controller.validpass;

public interface PasswordMatchesValid extends ConstraintValidator<PasswordMatches, Object> {
    void initialize(PasswordMatches constraintAnnotation);

    <ConstraintValidatorContext> boolean isValid(Object obj, ConstraintValidatorContext context);
}
