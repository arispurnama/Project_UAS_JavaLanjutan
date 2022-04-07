package com.neo.sihotel.service;

import com.neo.sihotel.model.Room;
import com.neo.sihotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImple implements RoomService{

    RoomRepository roomRepository;

    @Autowired
    public RoomServiceImple(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> getAllRoom() {
        return (List<Room>) roomRepository.findAll();
    }
}
