package com.neo.sihotel.controller;

import com.neo.sihotel.model.History;
import com.neo.sihotel.model.Reservasi;
import com.neo.sihotel.model.Room;
import com.neo.sihotel.model.User;
import com.neo.sihotel.repository.Historyrepository;
import com.neo.sihotel.repository.ReservasiRepository;
import com.neo.sihotel.service.ReservasiService;
import com.neo.sihotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CheckInController {

    ReservasiService reservasiService;
    RoomService roomService;

    @Autowired
    ReservasiRepository reservasiRepository;

    @Autowired
    Historyrepository historyrepository;

    List<Room> roomList = null;


    @Autowired
    public CheckInController(ReservasiService reservasiService, RoomService roomService) {
        this.reservasiService = reservasiService;
        this.roomService = roomService;
    }
//-----------------------------------------------------------------------------
    @GetMapping("/checkin")
    public String datacheeckin(Model model, String keyword){
        List<Reservasi> list = null;
        if (keyword != null) {
            list = reservasiRepository.findByKeyword(keyword);
        }else{
            list = reservasiRepository.getAllByCheckInFalse();
        }

        model.addAttribute("reservasi", list);

        return "check_in";
    }
//-----------------------------------------------------------

    @GetMapping("/check_in/{id}")
    public String checkInView(@PathVariable Integer id, Model model) {

        model.addAttribute("reservasi", reservasiService.getReservasiById(id));
        return "checkin";
    }

    @GetMapping("/deletereservasi/{id}")
    public String deletereservasi(@PathVariable Integer id, Model model) {
        reservasiRepository.deleteById(id);
        return "redirect:/checkin";
    }

    @PostMapping("/checkiin/{id}")
    public String checkIn(@PathVariable Integer id) {
        Reservasi  reservasi = reservasiRepository.getById(id);
        reservasi.setCheckIn(true);
        reservasiRepository.save(reservasi);
        reservasiService.getReservasiById(id).getRoom().setStatus("Terisi");

        return "redirect:/checkin";
    }

//------------------------------------------------------------------------
    @GetMapping("/checkout")
    public String datacheeckout(Model model, String keyword){
        List<Reservasi> list = null;
        if (keyword != null) {
            list = reservasiRepository.findByKeyword(keyword);
        }else{
            list = reservasiRepository.getAllByCheckInTrue();
        }

        model.addAttribute("reservasi", list);

        return "check_out";
    }

    @GetMapping("/check_out/{id}")
    public String checkOutView(@PathVariable Integer id, Model model) {

        model.addAttribute("reservasi", reservasiService.getReservasiById(id));
        return "checkout";
    }

    @PostMapping("/checkoout/{id}")
    public String checkOut(@PathVariable Integer id) {
        Reservasi reservasi = reservasiRepository.getById(id);
        reservasiRepository.delete(reservasi);


        reservasiService.getReservasiById(id).getRoom().setStatus("Kosong");

        History history = new History();
        history.setCode(reservasi.getCode());
        history.setCheckIn(reservasi.isCheckIn());
        history.setAlamat(reservasi.getAlamat());
        history.setCatatan(reservasi.getCatatan());
        history.setEmail(reservasi.getEmail());
        history.setJenisKelamin(reservasi.getJenisKelamin());
        history.setJumlahKamar(reservasi.getJumlahKamar());
        history.setLamaInap(reservasi.getLamaInap());
        history.setNoKtp(reservasi.getNoKtp());
        history.setTanggalCheckin(reservasi.getTanggalCheckin());
        history.setTagihan(reservasi.getTagihan());
        history.setRoom(String.valueOf(reservasi.getRoom()));
        history.setNoTlpn(reservasi.getNoTlpn());
        history.setTanggalOrder(reservasi.getTanggalOrder());
        history.setNama(reservasi.getNama());

        historyrepository.save(history);
        return "redirect:/checkout";
    }

}
