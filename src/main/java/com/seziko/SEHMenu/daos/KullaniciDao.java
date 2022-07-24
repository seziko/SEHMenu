package com.seziko.SEHMenu.daos;

import com.seziko.SEHMenu.entities.Firma;
import com.seziko.SEHMenu.entities.Kullanici;
import com.seziko.SEHMenu.results.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KullaniciDao extends JpaRepository<Kullanici,Integer> {

    Kullanici getByKullaniciAdi(String kullaniciAdi);

    Kullanici getBySifre(String sifre);

    Kullanici findById(int id);


    @Query("From Kullanici Where kullanici_adi = :kullaniciAdi and sifre=:sifre")
    Kullanici getUserNameAndSifre(String kullaniciAdi, String sifre);


}
