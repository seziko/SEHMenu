package com.seziko.SEHMenu.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "personel")
public class Personel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;
    @Column(name = "adi")
    String adi;
    @Column(name = "soyadi")
    String soyadi;
    @Column(name = "cinsiyet")
    String cinsiyet;
    @Column(name = "dogum_tarihi")
    Date dogumTarihi;
    @Column(name = "adi_soyadi")
    String adiSoyadi;
    @Column(name = "etar")
    Timestamp etar;
    @Column(name = "telefon")
    String telefonNo;
    @Column(name = "mail")
    String mail;
    @Column(name = "gorev")
    String gorev;
    @Column(name = "maas")
    String maas;
}
