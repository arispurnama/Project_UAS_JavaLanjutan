package com.neo.sihotel.controller;

import com.neo.sihotel.dto.ReservasiDto;
import com.neo.sihotel.model.Employee;
import com.neo.sihotel.model.Reservasi;
import com.neo.sihotel.model.Room;
import com.neo.sihotel.repository.ReservasiRepository;
import com.neo.sihotel.service.ReservasiService;
import com.neo.sihotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.List;

@Controller
public class ReservasiController {

    ReservasiRepository reservasiRepository;
    ReservasiService reservasiService;
    ReservasiDto reservasiDto = new ReservasiDto();
    List<Room> listRoom = null;
    public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/resource/static/images";

    @Autowired
    RoomService roomService;

    @Autowired
    public ReservasiController(ReservasiRepository reservasiRepository, ReservasiService reservasiService) {
        this.reservasiRepository = reservasiRepository;
        this.reservasiService = reservasiService;
    }

    @GetMapping("/newreservasi")
    public String newReservasi(Model model) {
        //create model attribut to bind form data
        listRoom = roomService.getAllRoom();
        model.addAttribute("rooms",listRoom);
        model.addAttribute("reservasi", new Reservasi());

        return "reservasi";
    }

    @PostMapping("/savereservasi")
    public String saveEmploye( @ModelAttribute("reservasi") Reservasi reservasi) throws IOException {
//        String photoName = @RequestParam MultipartFile filePhotoKtp,reservasi.getCode() + reservasi.getNama() + Instant.now().toEpochMilli();
//
//        Path path = Paths.get("src/main/resources/static/images/" + photoName + ".jpg");
//        Files.write(path, filePhotoKtp.getBytes());
//
//        //save employe to database
//        reservasi.setPhotoKtp(photoName);
//        reservasiService.sendMail(reservasiDto);
        reservasiService.saveReservasi(reservasi);

        return "redirect:/dashboard";
    }



}
