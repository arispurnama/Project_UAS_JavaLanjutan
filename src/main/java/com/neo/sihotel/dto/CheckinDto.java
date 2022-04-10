package com.neo.sihotel.dto;

import com.neo.sihotel.model.RoomType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CheckinDto {
    private int checkiID;
    private RoomType codeReservasi;
    private RoomType nomorKamar;
    private int biayaLainnya;
    private int tagihan;
}
