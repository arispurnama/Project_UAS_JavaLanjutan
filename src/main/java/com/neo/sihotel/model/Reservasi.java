package com.neo.sihotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "reservasi")
public class Reservasi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code")
    private int code;

    @Column(name = "nama")
    private String nama;

    @Column(name = "jenis_kelamin")
    private String jenisKelamin;

    @Column(name = "tanggal_order")
    private Date tanggalOrder;

    @Column(name = "tanggal_Checkin")
    private Date tanggalCheckin;

    @Column(name = "tanggal_checkout")
    private Date tanggalCheckout;

    @Column(name = "catatan")
    private String catatan;

    @Column(name = "photo_ktp")
    private String photoKtp;

    @OneToOne(mappedBy = "codeReservasi")
    private CheckIn checkin;

    @OneToOne(mappedBy = "codeReservasi")
    private CheckOut checkout;

}
