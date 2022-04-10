package com.neo.sihotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("modals")
public class ModelController {
    @GetMapping("/modal1")
    public String modal1() {
        return "modal1";
    }
}
