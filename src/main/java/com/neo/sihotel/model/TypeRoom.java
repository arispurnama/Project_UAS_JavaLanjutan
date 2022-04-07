package com.neo.sihotel.model;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "type_room")
public class TypeRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id", nullable = false, unique = true)
    private Integer typeID;

    @Column(name = "jenis")
    private String jenis;

    @Column(name = "harga")
    private int harga;

    @Column(name = "kapasitas")
    private int kapasitas;

    @Column(name = "photo")
    private String photo;

    @OneToOne(mappedBy = "typeID")
    private Room room;
}
