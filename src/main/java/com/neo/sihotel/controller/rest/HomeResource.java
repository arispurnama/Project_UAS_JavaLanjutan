package com.neo.sihotel.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @GetMapping("/user")
    public String user(){
        return ("<h1>Hello World User</h1>");
    }
    @GetMapping("/admin")
    public String admin(){
        return "home";
    }

}
