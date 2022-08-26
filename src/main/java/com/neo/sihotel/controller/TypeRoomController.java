package com.neo.sihotel.controller;

import com.neo.sihotel.model.Room;
import com.neo.sihotel.model.RoomType;
import com.neo.sihotel.service.RoomService;
import com.neo.sihotel.service.TypeRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.List;

@Controller
public class TypeRoomController {

    @Autowired
    TypeRoomService typeRoomService;

    @Autowired
    RoomService roomService;


    @PostMapping("/savetype")
    public String save(@RequestParam MultipartFile photoFile, RoomType roomType) throws Exception{
//        String photoName = roomType.getId() + roomType.getJenis() + Instant.now().toEpochMilli();
        String photoName = roomType.getId() + photoFile.getOriginalFilename().substring(photoFile.getOriginalFilename().length()-4);
        Path path = Paths.get("src/main/resources/static/images/" + photoName );
        try{
            Files.write(path, photoFile.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }

        //save employe to database
        roomType.setPhoto(photoName);
        typeRoomService.saveTypeKamar(roomType);
        return "redirect:/room";
    }


    @GetMapping("/updatetype/{id}")
    public String updatetyperoom(@PathVariable(value = "id") int id, Model model){
        //get kamar
        List<RoomType> roomTypes = null;
        List<Room> rooms = null;


        rooms = roomService.getAllRoom();
        model.addAttribute("rooms",rooms);

        roomTypes = typeRoomService.getAllTypeRoom();
        model.addAttribute("types",roomTypes);

        //set room
        RoomType type = typeRoomService.getTypeById(id);
        model.addAttribute("type", type);

        return "room";
    }

    @GetMapping("/deletetype/{id}")
    public String deleteTypeRoom(@PathVariable(value = "id") int id){
        //delete
        typeRoomService.deletetype(id);

        return "redirect:/room";
    }
}
