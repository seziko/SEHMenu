package com.seziko.SEHMenu.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "ilce")
public class Ilce {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "adi")
    String adi;

   // @OneToMany
   // @JoinColumn(name = "il_id")
   // private Il il;
   @Column(name = "etar")
   Timestamp etar;
}
