package com.neo.sihotel.dto;

import com.sun.istack.internal.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    @NotNull
    private int id;

    @NotNull
    private String name;

    @NotNull
    private String password;
    private String confirmPass;

    @NotNull
    private String email;

    @NotNull
    private Boolean admin;

}
