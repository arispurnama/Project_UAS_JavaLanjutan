package com.neo.sihotel.service;

import com.neo.sihotel.dto.MailResponseDto;
import com.neo.sihotel.dto.ReservasiDto;
import com.neo.sihotel.model.Reservasi;

import java.util.List;

public interface ReservasiService {
    MailResponseDto sendMail(ReservasiDto reservasiDto);

    List<Reservasi> getAllReservasi();

    void saveReservasi(Reservasi reservasi);

    Reservasi getReservasiById(int id);

    Reservasi updateReservasi(ReservasiDto reservasiDto);

    boolean deleteReservasi(int id);

    Reservasi insert(ReservasiDto reservasiDto);

}
