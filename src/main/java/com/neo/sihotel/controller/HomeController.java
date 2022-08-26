package com.neo.sihotel.controller;

import com.neo.sihotel.model.Reservasi;
import com.neo.sihotel.repository.ReservasiRepository;
import com.neo.sihotel.repository.TypeRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    TypeRoomRepository typeRoomRepository;


    @Autowired
    ReservasiRepository reservasiRepository;

    @GetMapping("/dashboard")
    public String dashboard(Model model){
        model.addAttribute("visitorsCheckout",reservasiRepository.countAllByCheckInTrue());
        model.addAttribute("visitorscheckin",reservasiRepository.countAllByCheckInFalse());
        model.addAttribute("jml",reservasiRepository.findAll().size());

        List<Reservasi> list = reservasiRepository.findAll();
        model.addAttribute("list",list);

        return "home";
    }

}
