package com.seziko.SEHMenu.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "vardiya")
public class Vardiya {

    @Id
    @Column(name = "id")
    int id;
    @Column(name = "vardiya")
    String vardiya;
    @Column(name = "etar")
    Timestamp etar;
}
