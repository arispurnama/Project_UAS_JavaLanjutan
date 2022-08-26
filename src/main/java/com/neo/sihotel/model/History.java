package com.neo.sihotel.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Integer code;

    private String nama;

    private String jenisKelamin;

    private String noKtp;

    private String noTlpn;

    private String alamat;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tanggalOrder;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tanggalCheckin;

    private int lamaInap;

    private String catatan;

    private String email;

    private int tagihan;

    @Column(columnDefinition = "boolean default false")
    private boolean checkIn;

    private String room;

}
