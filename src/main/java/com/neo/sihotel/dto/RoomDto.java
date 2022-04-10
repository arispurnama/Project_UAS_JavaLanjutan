package com.neo.sihotel.dto;

import com.neo.sihotel.model.RoomType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class RoomDto {
    private int id;
    private String nomorRoom, jenis,status;
    private RoomType typeID;
}
