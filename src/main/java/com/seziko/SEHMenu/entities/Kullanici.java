package com.seziko.SEHMenu.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "kullanici")
public class Kullanici {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "kullanici_adi")
    String kullaniciAdi;

    @Column(name = "sifre")
    String sifre;

   // @OneToOne(cascade = CascadeType.ALL)
   // @JoinColumn(name = "kimlik_id",referencedColumnName = "id")
   // private Kimlik kimlik;

    @Column(name = "etar")
    Timestamp etar;

    @Column(name = "tc_kimlik_no")
    String tcKimlikNo;



}
