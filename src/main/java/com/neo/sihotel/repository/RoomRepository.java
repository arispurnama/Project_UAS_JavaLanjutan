package com.neo.sihotel.repository;

import com.neo.sihotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    @Query(value = "from Room ")
    public List<Room> getKamar();

    @Query(value = "select * from room where id like %:keyword% or jenis like %:keyword% or status like %:keyword% or nomor like %:keyword% ", nativeQuery = true)
    List<Room> findByKeyword(@Param("keyword") String keyword);
}
