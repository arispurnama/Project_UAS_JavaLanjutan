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
@Table(name = "checkout")
public class CheckOut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nota_id")
    private int notaID;

    @Column(name = "tanggal_check")
    private Date tanggalCheck;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "code_reservasi")
    private Reservasi codeReservasi;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_checkin")
    private CheckIn checkInId;

    @Column(name = "biaya_tambahan")
    private int biayaTambahan;
}
