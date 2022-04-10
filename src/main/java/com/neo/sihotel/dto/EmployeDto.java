package com.neo.sihotel.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class EmployeDto {
    private int employeID;
    private String name, gender, email, addres, jabatan;
}
