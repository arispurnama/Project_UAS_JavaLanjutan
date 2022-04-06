package com.neo.sihotel.controller.validpass;

public @interface Constraint {
    Class<PasswordMatchesValidator> validatedBy();
}
