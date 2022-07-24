package com.seziko.SEHMenu.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity
@Table(name="masa_order")
public class MasaOrder implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "masa_id")
    int masaId;

    @Column(name = "etar")
    Timestamp etar;

    @Column(name = "tutar")
    Double tutar;

    @Column(name = "kalan_tutar")
    Double kalanTutar;

    @Column(name = "kapanış_tarihi")
    Timestamp kapanisTarihi;


}
