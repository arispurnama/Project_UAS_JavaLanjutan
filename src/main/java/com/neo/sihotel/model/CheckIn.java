package com.neo.sihotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "checkin")
public class CheckIn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checkin_ID")
    private int checkinID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "code_reservasi")
    private TypeRoom codeReservasi;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nomor_kamar")
    private TypeRoom nomorKamar;

    @Column(name = "catatan")
    private String catatan;

    @Column(name = "biaya_lainnya")
    private int biayaLainnya;

    @Column(name = "tagihan")
    private int tagihan;

    @OneToOne(mappedBy = "checkInId")
    private CheckOut checkout;
}
