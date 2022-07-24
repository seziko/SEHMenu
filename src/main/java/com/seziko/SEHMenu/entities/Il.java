package com.seziko.SEHMenu.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "il")
public class Il {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(name = "adi")
    String adi;
  //  @ManyToOne
  //  @JoinColumn(name = "ulke_id")
  //  private Ulke ulke;
    @Column(name = "plaka_kodu")
    String plakaKodu;

    @Column(name = "etar")
    Timestamp etar;

}
