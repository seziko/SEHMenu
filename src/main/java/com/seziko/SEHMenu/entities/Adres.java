package com.seziko.SEHMenu.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "adres")
public class Adres {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

  //  @ManyToOne
  //  @JoinColumn(name = "ulke_id")
  //  private Ulke ulke;
//
  //  @ManyToOne
  //  @JoinColumn(name = "il_id")
  //  private Il il;
//
  //  @ManyToOne
  //  @JoinColumn(name = "ilce_id")
  //  private Ilce ilce;

    @Column(name = "acik_adres")
    String acik_adres;
    @Column(name = "etar")
    Timestamp etar;

}
