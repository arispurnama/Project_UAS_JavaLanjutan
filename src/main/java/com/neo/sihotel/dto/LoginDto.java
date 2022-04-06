package com.neo.sihotel.dto;

import com.sun.istack.internal.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {

    @NotNull
    private String email;

    @NotNull
    private String password;

}
