package com.seziko.SEHMenu.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ulke")
public class Ulke {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(name = "adi")
    String adi;
    @Column(name = "ulke_kodu")
    String ulkeKodu;

}
