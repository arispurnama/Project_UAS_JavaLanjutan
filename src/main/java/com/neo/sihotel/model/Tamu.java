package com.neo.sihotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tamu")
public class Tamu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tamu_id")
    private int tamuID;

    @Column(name = "nama")
    private String nama;

    @Column(name = "jenis_kelamin")
    private String jenisKelamin;

    @Column(name = "alamat")
    private String alamat;

    @Column(name="no_ktp")
    private String noKtp;

    @Column(name = "no_tlpn")
    private String noTlpn;

}
