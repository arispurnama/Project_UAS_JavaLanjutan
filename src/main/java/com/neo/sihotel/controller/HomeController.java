package com.neo.sihotel.controller;

import com.neo.sihotel.repository.ReservasiRepository;
import com.neo.sihotel.repository.TypeRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    TypeRoomRepository typeRoomRepository;


    @Autowired
    ReservasiRepository reservasiRepository;

    @GetMapping("/dashboard")
    public String dashboard(Model model){
        model.addAttribute("visitors",reservasiRepository.countByCheckInTrue());
        return "home";
    }

}
