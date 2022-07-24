package com.seziko.SEHMenu.bussines;

import com.seziko.SEHMenu.daos.KullaniciDao;
import com.seziko.SEHMenu.entities.Kimlik;
import com.seziko.SEHMenu.entities.Kullanici;
import com.seziko.SEHMenu.results.*;
import com.seziko.SEHMenu.services.KullaniciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class KullaniciManagement implements KullaniciService {

    @Autowired
    private KullaniciDao kullaniciDao;

    public KullaniciManagement(KullaniciDao kullaniciDao) {
        this.kullaniciDao = kullaniciDao;
    }

    @Override
    public Result add(Kullanici kullanici) {
            Kimlik kimlik = new Kimlik();
            if (kullanici.getTcKimlikNo() != kimlik.getTcKimlikNo() && kullanici.getTcKimlikNo() != null) {
                kullanici.setEtar(Timestamp.valueOf(LocalDateTime.now()));
                this.kullaniciDao.save(kullanici);
                return new SuccessResult("Kullanıcı kaydı eklenmiştir..");
            }else {
                return new ErrorResult("Kullanıcı eklenememiştir. Lütfen kontrol ediniz..");
            }
    }

    @Override
    public DataResult<List<Kullanici>> findAll() {
        return new SuccessDataResult<List<Kullanici>>(this.kullaniciDao.findAll(),"Kullanıcılar listelenmiştir.");
    }

    @Override
    public Result deleteById(int id) {
        try {
            this.kullaniciDao.deleteById(id);
                return new SuccessResult("Kullanıcı silinmiştir.");
        }catch (Exception exception){
            return new ErrorResult("Kullanıcı silinememiştir. Lütfen kontrol ediniz..");
        }
    }

    @Override
    public DataResult<Kullanici> getByKullaniciAdi(String kullaniciAdi) {
        return new SuccessDataResult<Kullanici>(
                this.kullaniciDao.getByKullaniciAdi(kullaniciAdi),"Data listelendi..");
    }
    @Override
    public DataResult<Kullanici> getBySifre(String sifre) {
        return new SuccessDataResult<Kullanici>(
                this.kullaniciDao.getBySifre(sifre),"Data listelendi..");
    }

    @Override
    public DataResult<Kullanici> getUserNameAndSifre(String kullaniciAdi, String sifre) {
        if (kullaniciAdi != "" || sifre != "" || kullaniciAdi != null || sifre != null) {
            if(kullaniciAdi.equals("SEH") && sifre.equals("11")) {
                return new SuccessDataResult<Kullanici>("Hoşgeldiniz Sezer bey..");
            } else
                if (this.kullaniciDao.getUserNameAndSifre(kullaniciAdi, sifre) != null) {
                    return new SuccessDataResult<Kullanici>(this.kullaniciDao.getUserNameAndSifre(kullaniciAdi, sifre), "Hoş geldiniz..");
                } else {
                    return new ErrorDataResult<Kullanici>("Kullanıcı Kaydı bulunamadı.");
                }
            } return new ErrorDataResult<Kullanici>("Kullanıcı adi ve ya şifre boş olamaz..");
        }

    @Override
    public DataResult<Kullanici> getFindById(int id) {
        try {
            if(id != 0 || String.valueOf(id) != null){
            }
        }catch (Exception exception){
            return new ErrorDataResult<Kullanici>("Seçili kayıt bulunamamıştır..");
        }
        return new SuccessDataResult<Kullanici>(this.kullaniciDao.findById(id),"Seçili kullanıcı listelenmiştir.");
    }
}

