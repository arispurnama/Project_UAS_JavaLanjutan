package com.neo.sihotel.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Integer id;

    private String jenis;

    private int harga;

    private int kapasitas;

    private String photo;

    @OneToMany(mappedBy = "type")
    private List<Room> rooms;
}
