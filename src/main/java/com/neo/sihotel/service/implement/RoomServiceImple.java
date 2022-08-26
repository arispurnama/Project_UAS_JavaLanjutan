package com.neo.sihotel.service.implement;

import com.neo.sihotel.dto.RoomDto;
import com.neo.sihotel.model.Room;
import com.neo.sihotel.repository.RoomRepository;
import com.neo.sihotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImple implements RoomService {
    @Autowired
    RoomRepository roomRepository;

//    @Autowired
//    public RoomServiceImple(RoomRepository roomRepository) {
//        this.roomRepository = roomRepository;
//    }

    @Override
    public List<Room> getAllRoom() {
        return (List<Room>) roomRepository.findAll();
    }

    @Override
    public void saveKamar(Room room) {
        this.roomRepository.save(room);
    }

    @Override
    public Room getKamarById(int id) {
        Optional<Room> room = roomRepository.findById(id);
        Room data = null;
        if (room.isPresent()){
            data = room.get();
        }else{
            throw new RuntimeException("Room is not found");
        }
        return data;
    }

    @Override
    public Room updateRoom(RoomDto roomDto) {
        Room room = roomRepository.getById(roomDto.getId());
        Room result = new Room();
        try{
            room.setNomor(roomDto.getNomorRoom());
            room.setType(roomDto.getTypeID());
            room.setStatus(roomDto.getStatus());

            result = roomRepository.save(room);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deleteRoom(int id) {
        roomRepository.deleteById(id);
        return true;
    }
//
    @Override
    public List<Room> getByKeyword(String keyword){
        return roomRepository.findByKeyword(keyword);
    }

}
