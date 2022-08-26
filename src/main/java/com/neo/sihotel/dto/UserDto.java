package com.neo.sihotel.dto;

import com.sun.istack.internal.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private Integer id;

    private String name;

    private String password;

    private String email;

    private Boolean admin;

}
