package com.seziko.SEHMenu.bussines;

import com.seziko.SEHMenu.daos.KimlikDao;
import com.seziko.SEHMenu.entities.Kimlik;
import com.seziko.SEHMenu.results.*;
import com.seziko.SEHMenu.services.KimlikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class KimlikManagement implements KimlikService {

    private KimlikDao kimlikDao;

    @Autowired
    public KimlikManagement(KimlikDao kimlikDao) {
        this.kimlikDao = kimlikDao;
    }

    @Override
    public Result add(Kimlik kimlik) {
        try {
            kimlik.setEtar(Timestamp.valueOf(LocalDateTime.now()));
             this.kimlikDao.save(kimlik);
         }catch (Exception exception){
            return new ErrorResult("Kimlik kaydı eklenememiştir. Lütfen bilgileri kontrol ediniz...");
         }
        return new SuccessResult("Kimlik kaydı eklenmiştir..");
    }

    public DataResult<List<Kimlik>> findAll(){
        return new SuccessDataResult<List<Kimlik>>(this.kimlikDao.findAll(),"tüm liste yüklenmiştir.");
    }

    public Result deleteById(int id){
        try {
            this.kimlikDao.deleteById(id);
        }catch (Exception exception){
            return new ErrorResult("Kimlik kaydı silinememiştir. Lütfen kontrol ediniz..");
        }
        return new SuccessResult("Kimlik kaydı silinmiştir.") ;
    }

    @Override
    public DataResult<Kimlik> getByTcKimlikNo(String tcKimlikNo) {
        try{
            return new SuccessDataResult<Kimlik>(this.kimlikDao.getBytcKimlikNo(tcKimlikNo),"Kimlik numarası listelenmiştir.");
        } catch (Exception exception){
            return new ErrorDataResult<Kimlik>(this.kimlikDao.getBytcKimlikNo(tcKimlikNo),"Girmiş olduğunuz TC Kimlik Numarası bulunamamıştır.");
        }
    }

    @Override
    public DataResult<Kimlik> getFindById(int id) {
        try {
            if(id != 0 || String.valueOf(id) != null){
                this.kimlikDao.findById(id);
            }
        }catch (Exception exception){
            return new ErrorDataResult<Kimlik>(this.kimlikDao.findById(id),"Seçili kayıt bulunamamıştır..");
        }
        return new SuccessDataResult<Kimlik>(this.kimlikDao.findById(id),"Seçili kayıt listelenmiştir..");
    }
}
