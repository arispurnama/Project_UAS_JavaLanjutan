package com.neo.sihotel.model;

import lombok.*;

import javax.persistence.*;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "room")
public class Room {
    @Id
    @Column(name = "nomor_room")
    private String nomorRoom;

    @Column(name = "jenis")
    private String jenis;

    @Column(name = "status")
    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id")
    private TypeRoom typeID;

    @OneToOne(mappedBy = "nomorKamar")
    private CheckIn checkin;
}
