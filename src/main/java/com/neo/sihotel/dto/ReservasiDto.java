package com.neo.sihotel.dto;

import com.neo.sihotel.model.Reservasi;
import com.neo.sihotel.model.Room;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class ReservasiDto {
    private int code, lamaInap, tagihan;
    private String nama, jenisKelamin,alamat,email, noKtp, noTlpn, catatan, photoKtp;
    private LocalDate tanggalOrder, tanggalCheckin;
    private Room id;
}
