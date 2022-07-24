package com.seziko.SEHMenu.bussines;

import com.seziko.SEHMenu.daos.OrganizasyonDao;
import com.seziko.SEHMenu.entities.Organizasyon;
import com.seziko.SEHMenu.results.*;
import com.seziko.SEHMenu.services.OrganizasyonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.sasl.SaslClient;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class OrganizasyonManagement implements OrganizasyonService {

    private OrganizasyonDao organizasyonDao;

    @Autowired
    public OrganizasyonManagement(OrganizasyonDao organizasyonDao) {
        this.organizasyonDao = organizasyonDao;
    }

    public Result add(Organizasyon organizasyon){
        try {
            if(organizasyon.getAdi() != null && organizasyon.getAdres() != null && organizasyon.getTelefon() != null){
                organizasyon.setEtar(Timestamp.valueOf(LocalDateTime.now()));
                this.organizasyonDao.save(organizasyon);
                return new SuccessResult("Kayıt işlemi başarılı..");
            }    else{
                return new ErrorResult("Zorunlu alanları doldurunuz..");
            }
        }catch (Exception exception){
            return new ErrorResult("Girmiş olduğunuz bilgileri kontrol ediniz.. Hata detayını inceleyin.."+exception);
        }
    }

    @Override
    public DataResult<List<Organizasyon>> findAll() {
        return new SuccessDataResult<List<Organizasyon>>(this.organizasyonDao.findAll(),"Organizasyonlar listelenmiştir.");
    }

    @Override
    public Result deleteById(int id) {
        try {
            if(id != 0){
                this.organizasyonDao.deleteById(id);
            }
        }catch (Exception exception){
            return new ErrorResult("Seçili kayıt bulunamamıştır..");
        }
        return new SuccessResult("Seçilen kayıt silinmiştir.");
    }

    @Override
    public DataResult<Organizasyon> getFindById(int id) {
        if(id != 0 || String.valueOf(id) != null){
            return new SuccessDataResult<Organizasyon>(this.organizasyonDao.findById(id),"Seçili kayıt listelenmiştir..");
        } else {
            return new ErrorDataResult<Organizasyon>("Seçili kayıt bulunamamıştır..");
        }
    }
}
