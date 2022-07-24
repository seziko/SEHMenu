package com.seziko.SEHMenu.bussines;

import com.seziko.SEHMenu.daos.PersonelDao;
import com.seziko.SEHMenu.entities.Personel;
import com.seziko.SEHMenu.results.*;
import com.seziko.SEHMenu.services.PersonelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PersonelManagement implements PersonelService {

    private PersonelDao personelDao;

    @Autowired
    public PersonelManagement(PersonelDao personelDao) {
        this.personelDao = personelDao;
    }

    @Override
    public Result add(Personel personel) {
        try {
            if(personel.getAdi() != null && personel.getSoyadi()  != null && personel.getDogumTarihi() != null
                    && personel.getCinsiyet() != null && personel.getTelefonNo() != null
                      && personel.getMail() != null && personel.getMaas() != null
                        && personel.getGorev() != null){
                personel.setAdiSoyadi(personel.getAdi()+' '+ personel.getSoyadi());
                personel.setEtar(Timestamp.valueOf(LocalDateTime.now()));
                this.personelDao.save(personel);
            }
        }catch (Exception exception){
            return new ErrorResult("Hatalı ve ya eksik bir işlem yaptınız. Hata detayını inceleyiniz.."+exception);
        }
        return new SuccessResult("Kayıt işlemi başarılı..");
    }

    @Override
    public DataResult<List<Personel>> findAll() {
        return new SuccessDataResult<List<Personel>>(this.personelDao.findAll(),"Personeller listelenmiştir..");
    }

    @Override
    public Result deleteById(int id) {
        try {
            if(id != 0 || String.valueOf(id) != null){
                this.personelDao.deleteById(id);
            }
        }catch (Exception exception){
            return new ErrorResult("Seçili kayıt bulunamamıştır..");
        }
        return new SuccessResult(id + " id li seçili kayıt silinmiştir..");
    }

    @Override
    public DataResult<Personel> findById(int id) {
        try {
            if(id != 0 || String.valueOf(id) != null){
                this.personelDao.findById(id);
            } else {
                return new ErrorDataResult<Personel>("Seçili kayıt bulunamamıştır..");
            }
        }catch (Exception exception){
            return new ErrorDataResult<Personel>("Seçili kayıt bulunamamıştır..");
        }
        return new SuccessDataResult<Personel>(this.personelDao.findById(id),id + " id li seçili kayıt listelenmiştir..");
    }

    @Override
    public DataResult<Personel> update(Personel personel, int id) {
        try {
            if(String.valueOf(personel.getId()) != null){
                personel.setEtar(personel.getEtar());
                personel.setAdiSoyadi(personel.getAdi() +" "+personel.getSoyadi());
                this.personelDao.save(personel);

            }
        }catch (Exception exception){
            return new ErrorDataResult<Personel>("Kayıt bulunamadı..");
        }
        return new SuccessDataResult<Personel>(this.personelDao.save(personel),"Kayıt güncellenmiştir..");
    }
}
