package com.neo.sihotel.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nomor;

    private String status;

    @OneToMany(mappedBy = "room")
    private List<Reservasi> reservasis;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "type_id")
    @ManyToOne
    private RoomType type;

}
