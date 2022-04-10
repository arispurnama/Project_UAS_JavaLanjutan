package com.neo.sihotel.service;

import com.neo.sihotel.dto.TypeRoomDto;
import com.neo.sihotel.model.RoomType;

import java.util.List;

public interface TypeRoomService {
    public List<RoomType> getAllTypeRoom();


    void saveTypeKamar(RoomType roomType);

    RoomType getTypeById(int id);

    RoomType updateTypeRoom(TypeRoomDto typeRoomDto);

    boolean deletetype(int id);
}
