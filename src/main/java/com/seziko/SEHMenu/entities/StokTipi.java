package com.seziko.SEHMenu.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "stok_tipi")
public class StokTipi {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "adi")
    String adi;
    @Column(name = "durum")
    String durum;
    @Column(name = "kodu")
    String kodu;
    @Column(name = "etar")
    Timestamp etar;


}
