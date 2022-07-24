package com.seziko.SEHMenu.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "kimlik")
public class Kimlik {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(name = "tc_kimlik_no")
    String tcKimlikNo;
    @Column(name = "adi")
    String adi;
    @Column(name = "soyadi")
    String soyadi;
    @Column(name = "adi_soyadi")
    String adiSoyadi;
    @Column(name = "anne_adi")
    String anneAdi;
    @Column(name = "baba_adi")
    String babaAdi;
    @Column(name = "cinsiyet")
    String cinsiyet;
    @Column(name = "dogum_tarihi")
    Date dogumTarihi;

    @Column(name = "etar")
    Timestamp etar;

}
