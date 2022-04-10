package com.neo.sihotel.controller;

import com.neo.sihotel.model.RoomType;
import com.neo.sihotel.service.TypeRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;

@Controller
public class TypeRoomController {

    @Autowired
    TypeRoomService typeRoomService;

    public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/resource/images";

    @PostMapping("/savetype")
    public String save(@RequestParam MultipartFile photo, RoomType roomType) throws Exception{
        String photoName = roomType.getId() + roomType.getJenis() + Instant.now().toEpochMilli();

        Path path = Paths.get("src/main/resources/static/images/" + photoName + ".jpg");
        Files.write(path, photo.getBytes());

        //save employe to database
        roomType.setPhoto(photoName);

        typeRoomService.saveTypeKamar(roomType);
        return "redirect:/room";
    }

    @GetMapping("/newtype")
    public String newType(Model model){
        //create model attribut to dind form data
        model.addAttribute("type",new RoomType());

        return "formRoom";
    }

    @GetMapping("/updatetype")
    public String updateroom(@PathVariable(value = "id") int id, Model model){
        //get kamar
        RoomType room = typeRoomService.getTypeById(id);

        //set room
        model.addAttribute("type", room);

        return "formRoom";
    }
}
