package com.seziko.SEHMenu.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "iletisim")
public class Iletisim {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "gsm_telefon")
    String gsmTelefon;

    @Column(name = "ev_telefon")
    String evTelefon;

    @Column(name = "eposta")
    String ePosta;

    @Column(name = "etar")
    Timestamp etar;
}
