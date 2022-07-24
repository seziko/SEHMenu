package com.seziko.SEHMenu.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "organizasyon")
public class Organizasyon implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(name = "adi")
    String adi;
    @Column(name = "adres")
    String adres;
    @Column(name = "telefon")
    String telefon;
    @Column(name = "etar")
    Timestamp etar;

}
