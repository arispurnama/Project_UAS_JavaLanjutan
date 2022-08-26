package com.neo.sihotel.service.implement;

import com.neo.sihotel.dto.MailResponseDto;
import com.neo.sihotel.dto.ReservasiDto;
import com.neo.sihotel.model.Reservasi;
import com.neo.sihotel.repository.ReservasiRepository;
import com.neo.sihotel.service.ReservasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Optional;

@Service
public class ReservasiServiceImple implements ReservasiService {
    ReservasiRepository reservasiRepository;
    JavaMailSender sender;

    @Autowired
    public ReservasiServiceImple(ReservasiRepository reservasiRepository, JavaMailSender sender) {
        this.reservasiRepository = reservasiRepository;
        this.sender = sender;
    }

    @Override
    public MailResponseDto sendMail(Reservasi reservasiDto) {
        MailResponseDto responseDto = new MailResponseDto();
        MimeMessage mimeMessage = sender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            helper.setTo(reservasiDto.getEmail());
            helper.setSubject("Reservasi Hotel");
            helper.setFrom("arispurnama1605@gmail.com");
            helper.setText(" <div>\n" +
                    "    <p>SELAMAT DATANG DI HOTEL KAMI</p>\n" +
                    "    <p>Kami Ucapkan Terima Kasih Mau Berkunjung</p>\n" +
                    "    <table  border=\"1\">\n" +
                    "        <tr>\n" +
                    "            <td>Nama</td>\n" +
                    "            <td>Nomor KTP</td>\n" +
                    "            <td>Nomor Telepon</td>\n" +
                    "            <td>Alamat</td>\n" +
                    "            <td>Lama Inap</td>\n" +
                    "        </tr>\n" +
                    "        <tr>\n" +
                    "            <td>"+ reservasiDto.getNama()+"</td>\n" +
                    "            <td> "+reservasiDto.getNoKtp()+"</td>\n" +
                    "            <td>"+reservasiDto.getNoTlpn()+"</td>\n" +
                    "            <td>"+reservasiDto.getAlamat()+"</td>\n" +
                    "            <td>"+reservasiDto.getLamaInap()+"</td>\n" +
                    "        </tr>\n" +
                    "    </table>\n" +
                    "</div>    \n",true);

            sender.send(mimeMessage);
            responseDto.setPesan("Email Berhasil Terkirim Ke - " + reservasiDto.getEmail());
            responseDto.setStatus(Boolean.TRUE);
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            responseDto.setPesan("Email Gagal Terkirim");
            responseDto.setStatus(Boolean.FALSE);
        }

        return responseDto;
    }

    @Override
    public List<Reservasi> getAllReservasi() {
        return reservasiRepository.findAll();
    }

    @Override
    public void saveReservasi(Reservasi reservasi) {
        reservasi.setTagihan(reservasi.getLamaInap() * reservasi.getRoom().getType().getHarga());
        this.reservasiRepository.save(reservasi);
    }

    @Override
    public Reservasi getReservasiById(int id) {
        Optional<Reservasi> reservasi = reservasiRepository.findById(id);
        Reservasi data = null;
        if (reservasi.isPresent()) {
            data = reservasi.get();
        } else {
            throw new RuntimeException("Reservasi is not found");
        }
        return data;
    }

    @Override
    public Reservasi updateReservasi(ReservasiDto reservasiDto) {
        Reservasi reservasi = reservasiRepository.getById(reservasiDto.getCode());
        Reservasi result = new Reservasi();
        try {
            reservasi.setNama(reservasiDto.getNama());
            reservasi.setJenisKelamin(reservasiDto.getJenisKelamin());
            reservasi.setAlamat(reservasiDto.getAlamat());
            reservasi.setNoKtp(reservasiDto.getNoKtp());
            reservasi.setNoTlpn(reservasiDto.getNoTlpn());
            reservasi.setCatatan(reservasiDto.getCatatan());
            reservasi.setEmail(reservasiDto.getEmail());
//            reservasi.setPhotoKtp(reservasiDto.getPhotoKtp());
            reservasi.setTanggalOrder(reservasiDto.getTanggalOrder());
            reservasi.setTanggalCheckin(reservasiDto.getTanggalCheckin());

            result = reservasiRepository.save(reservasi);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deleteReservasi(int id) {
        reservasiRepository.deleteById(id);
        return true;
    }

    @Override
    public Reservasi insert(ReservasiDto reservasiDto) {
        Reservasi reservasi = new Reservasi();
        Reservasi result = new Reservasi();
        try {
            reservasi.setNama(reservasiDto.getNama());
            reservasi.setJenisKelamin(reservasiDto.getJenisKelamin());
            reservasi.setAlamat(reservasiDto.getAlamat());
            reservasi.setNoKtp(reservasiDto.getNoKtp());
            reservasi.setNoTlpn(reservasiDto.getNoTlpn());
            reservasi.setCatatan(reservasiDto.getCatatan());
            reservasi.setEmail(reservasiDto.getEmail());
//            reservasi.setPhotoKtp(reservasiDto.getPhotoKtp());
            reservasi.setTanggalOrder(reservasiDto.getTanggalOrder());
            reservasi.setTanggalCheckin(reservasiDto.getTanggalCheckin());

            result = reservasiRepository.save(reservasi);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }



}
