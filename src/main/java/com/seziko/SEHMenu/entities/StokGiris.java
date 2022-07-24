package com.seziko.SEHMenu.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "stok_giris")
public class StokGiris {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(name = "stok_id")
    int stok_id;
    @Column(name = "firma_id")
    int firma_id;
    @Column(name = "alis_fiyat")
    double alis_fiyat;
    @Column(name = "carpan")
    int carpan;
    @Column(name = "miktar")
    int miktar;
    @Column(name = "etar")
    Timestamp etar;
    @Column(name = "makbuz_no")
    int makbuzNo;
    @Column(name = "makbuz_tarihi")
    Date makbuz_tarihi;
    @Column(name = "giris_tarihi")
    Date girisTarihi;
}
