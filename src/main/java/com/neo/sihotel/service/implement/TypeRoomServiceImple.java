package com.neo.sihotel.service.implement;

import com.neo.sihotel.dto.TypeRoomDto;
import com.neo.sihotel.model.RoomType;
import com.neo.sihotel.repository.TypeRoomRepository;
import com.neo.sihotel.service.TypeRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeRoomServiceImple implements TypeRoomService {

    TypeRoomRepository typeRoomRepository;

    @Autowired
    public TypeRoomServiceImple(TypeRoomRepository typeRoomRepository) {
        this.typeRoomRepository = typeRoomRepository;
    }

    @Override
    public List<RoomType> getAllTypeRoom() {
        return typeRoomRepository.findAll();
    }

    @Override
    public void saveTypeKamar(RoomType roomType) {
        this.typeRoomRepository.save(roomType);
    }

    @Override
    public RoomType getTypeById(int id) {
        Optional<RoomType> typeRoom = typeRoomRepository.findById(id);
        RoomType data = null;
        if (typeRoom.isPresent()){
            data = typeRoom.get();
        }else{
            throw new RuntimeException("Type Room is not found");
        }
        return data;
    }

    @Override
    public RoomType updateTypeRoom(TypeRoomDto typeRoomDto) {
        RoomType roomType = typeRoomRepository.getById(typeRoomDto.getId());
        RoomType result = new RoomType();
        try{
            roomType.setJenis(typeRoomDto.getJenis());
            roomType.setHarga(typeRoomDto.getHarga());
            roomType.setKapasitas(roomType.getKapasitas());
            roomType.setPhoto(typeRoomDto.getPhoto());

            result = typeRoomRepository.save(roomType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deletetype(int id) {
        typeRoomRepository.deleteById(id);
        return true;
    }
}
