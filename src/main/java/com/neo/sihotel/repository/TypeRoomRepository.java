package com.neo.sihotel.repository;

import com.neo.sihotel.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeRoomRepository extends JpaRepository<RoomType, Integer> {
    @Query(value = "from RoomType ")
    List<RoomType> getTypeRoom();
}
