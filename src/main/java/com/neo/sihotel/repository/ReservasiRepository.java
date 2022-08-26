package com.neo.sihotel.repository;

import com.neo.sihotel.model.Reservasi;
import com.neo.sihotel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservasiRepository extends JpaRepository<Reservasi, Integer> {

    List<Reservasi> getAllByCheckInFalse();
    List<Reservasi> getAllByCheckInTrue();

    Long countAllByCheckInFalse();
    Long countAllByCheckInTrue();

    @Query(value = "select * from reservasi where code like %:keyword% or jenis_kelamin like %:keyword% or email like %:keyword% or nama like %:keyword% or no_ktp like %:keyword% or tanggal_order like %:keyword% ", nativeQuery = true)
    List<Reservasi> findByKeyword(@Param("keyword") String keyword);

}
