package com.seziko.SEHMenu.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "stok")
public class Stok {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(name = "kodu")
    String kodu;
    @Column(name = "adi")
    String adi;
    @Column(name = "etar")
    Timestamp etar;
    @Column(name = "stok_tipi")
    int stokTipi;
}
