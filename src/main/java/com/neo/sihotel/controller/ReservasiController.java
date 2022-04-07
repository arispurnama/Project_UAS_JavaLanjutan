package com.neo.sihotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservasiController {

    @GetMapping("/reservasi")
    public String reservasi() {

        return "reservasi";
    }

}
