package com.seziko.SEHMenu.bussines;

import com.seziko.SEHMenu.daos.VardiyaDao;
import com.seziko.SEHMenu.entities.Vardiya;
import com.seziko.SEHMenu.results.*;
import com.seziko.SEHMenu.services.VardiyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VardiyaManagement implements VardiyaService {

    private VardiyaDao vardiyaDao;

    @Autowired
    public VardiyaManagement(VardiyaDao vardiyaDao) {
        this.vardiyaDao = vardiyaDao;
    }

    @Override
    public Result add(Vardiya personelVardiya) {
        try {
            if(personelVardiya.getVardiya() != null){
                personelVardiya.setEtar(Timestamp.valueOf(LocalDateTime.now()));
                this.vardiyaDao.save(personelVardiya);
        }
        }catch (Exception exception){
            return new ErrorResult("Hatalı bir işlem yaptınız.. Hata detayını kontrol ediniz.. " + exception);
        }
        return new SuccessResult("Vardiya kaydı tamamlanmıştır..");
    }

    @Override
    public DataResult<List<Vardiya>> findAll() {
        return new SuccessDataResult<List<Vardiya>>(this.vardiyaDao.findAll(),"Vardiyalar listelenmiştir..");
    }

    @Override
    public DataResult<Vardiya> findById(int id) {
        if(id != 0 || String.valueOf(id) != null){
            return new SuccessDataResult<Vardiya>(this.vardiyaDao.findById(id),"Seçili kayıt listelenmiştir.");
        } else {
            return new ErrorDataResult<Vardiya>("Seçili kayıt bulunamamıştır..");
        }
    }

    @Override
    public Result deleteById(int id) {
        if(id != 0 || String.valueOf(id) != null){
            return new SuccessResult("Seçili kayıt silinmiştir..");
        } else {
            return new ErrorResult("Seçili kayıt bulunamamıştır..");
        }
    }
}
