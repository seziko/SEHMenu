package com.seziko.SEHMenu.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "firma")
public class Firma {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "kodu")
    String kodu;

    @Column(name = "adi")
    String adi;

    @Column(name = "vergi_numarasi")
    String vergiNumarasi;

    @Column(name = "vergiDairesi")
    String vergiDairesi;

    @Column(name = "iban")
    String iban;

    @Column(name = "adres")
    String adres;

    @Column(name = "gsm_telefon")
    String gsmTelefon;

    @Column(name = "sirket_telefon")
    String sirketTelefon;

    @Column(name = "etar")
    Timestamp etar;
}
