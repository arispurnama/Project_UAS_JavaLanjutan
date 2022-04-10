package com.neo.sihotel.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TypeRoomDto {
    private int id, harga, kapasitas;
    private String jenis, photo;
}
