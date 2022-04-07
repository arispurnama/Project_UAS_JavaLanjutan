package com.neo.sihotel.controller;

import com.neo.sihotel.model.Room;
import com.neo.sihotel.model.TypeRoom;
import com.neo.sihotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RoomController {

    @Autowired
    RoomService roomService;
    List<Room> list;

    @GetMapping("/room")
    public String room(Model model){
//        model.addAttribute("type",typeRoomRepository.findAll());
        list = roomService.getAllRoom();
        model.addAttribute("room",list);
        return "room";
    }
}
