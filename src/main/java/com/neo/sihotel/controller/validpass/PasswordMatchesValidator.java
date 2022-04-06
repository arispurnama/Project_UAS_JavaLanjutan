package com.neo.sihotel.controller.validpass;

import com.neo.sihotel.dto.UserDto;

public class PasswordMatchesValidator implements PasswordMatchesValid {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public <ConstraintValidatorContext> boolean isValid(Object obj, ConstraintValidatorContext context){
        UserDto user = (UserDto) obj;
        return user.getPassword().equals(user.getConfirmPass());
    }
}
