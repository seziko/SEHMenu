package com.seziko.SEHMenu.entities;

import lombok.Data;
import org.hibernate.annotations.CollectionId;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "masa")
public class Masa implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "sube_id")
    int subeId;

    @Column(name="masa_no")
    String masaNo;

    @Column(name = "etar")
    Timestamp etar;
    @Column(name = "status")
    String status;
}
