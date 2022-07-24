package com.seziko.SEHMenu.services;

import com.seziko.SEHMenu.entities.Firma;
import com.seziko.SEHMenu.entities.Kullanici;
import com.seziko.SEHMenu.results.DataResult;
import com.seziko.SEHMenu.results.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KullaniciService {

    Result add(Kullanici kullanici);

    DataResult<List<Kullanici>> findAll();

    Result deleteById(int id);

    DataResult<Kullanici> getByKullaniciAdi(String kullaniciAdi);


    DataResult<Kullanici> getBySifre(String sifre);

    DataResult<Kullanici> getFindById(int id);

    DataResult<Kullanici> getUserNameAndSifre(String kullaniciAdi, String sifre);


}
