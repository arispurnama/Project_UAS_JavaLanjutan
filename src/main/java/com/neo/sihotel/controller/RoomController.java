package com.neo.sihotel.controller;

import com.neo.sihotel.model.Room;
import com.neo.sihotel.model.RoomType;
import com.neo.sihotel.repository.TypeRoomRepository;
import com.neo.sihotel.service.RoomService;
import com.neo.sihotel.service.TypeRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RoomController {

    @Autowired
    RoomService roomService;

    @Autowired
    TypeRoomService typeRoomService;

    @Autowired
    private TypeRoomRepository typeRoomRepository;

    List<RoomType> roomTypes = null;
    List<Room> rooms = null;

    @GetMapping("/room")
    public String room(Model model , String keyword){
//        model.addAttribute("type",typeRoomRepository.findAll());
        if (keyword != null) {
            rooms = roomService.getByKeyword(keyword);
        }else{
            rooms = roomService.getAllRoom();
        }
        model.addAttribute("rooms",rooms);
        roomTypes = typeRoomService.getAllTypeRoom();

        model.addAttribute("types",roomTypes);
        model.addAttribute("type",new RoomType());

        return "room";
    }


    @GetMapping("/newkamar")
    public String newkamar(Model model){
        //create model attribut to dind form data
        List<RoomType> types = typeRoomRepository.getTypeRoom();
        model.addAttribute("types",types);
        model.addAttribute("room",new Room());

        return "formRoom";
    }

    @PostMapping("/saveroom")
    public String saveRoom(@ModelAttribute("room")Room roomDto){
        //save room
        roomService.saveKamar(roomDto);

        return "redirect:/room";
    }

    @GetMapping("/updateroom/{id}")
    public String updateroom(@PathVariable(value = "id") int id, Model model){
        //get kamar
        Room room = roomService.getKamarById(id);
        List<RoomType> types = typeRoomRepository.getTypeRoom();
        model.addAttribute("types",types);

        //set room
        model.addAttribute("room", room);

        return "formRoom";
    }

    @GetMapping("/deleteroom/{id}")
    public String deleteRoom(@PathVariable(value = "id") int id){
        //delete
        roomService.deleteRoom(id);

        return "redirect:/room";
    }
}
