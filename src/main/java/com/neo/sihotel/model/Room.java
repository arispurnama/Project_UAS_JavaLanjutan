package com.neo.sihotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id")
    private TypeRoom typeID;

    @OneToOne(mappedBy = "nomorKamar")
    private CheckIn checkin;
}
