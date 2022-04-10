package com.neo.sihotel.service;

import com.neo.sihotel.dto.RoomDto;
import com.neo.sihotel.model.Room;

import java.util.List;

public interface RoomService {
    public List<Room> getAllRoom();

    void saveKamar(Room room);

    Room getKamarById(int id);


    Room updateRoom(RoomDto roomDto);

    boolean deleteRoom(int id);

    //
    List<Room> getByKeyword(String keyword);
}
