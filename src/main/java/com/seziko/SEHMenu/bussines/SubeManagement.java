package com.seziko.SEHMenu.bussines;

import com.seziko.SEHMenu.daos.SubeDao;
import com.seziko.SEHMenu.entities.Sube;
import com.seziko.SEHMenu.results.*;
import com.seziko.SEHMenu.services.SubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SubeManagement implements SubeService {

    private SubeDao subeDao;

    @Autowired
    public SubeManagement(SubeDao subeDao) {
        this.subeDao = subeDao;
    }

    @Override
    public Result add(Sube sube) {
        try {
            if((sube.getOrganizasyonId() != 0 || String.valueOf(sube.getOrganizasyonId()) != null) && sube.getAdi() != null
                && (sube.getMasaSayisi() != 0 || String.valueOf(sube.getMasaSayisi()) != null))
            {
                sube.setEtar(Timestamp.valueOf(LocalDateTime.now()));
                this.subeDao.save(sube);
            }
        }catch (Exception exception){
            return new ErrorResult("Girmiş olduğunuz bilgileri kontrol ediniz..");
        }
        return new SuccessResult("Kayıt işlemi başarılı bir şekilde tamamlanmıştır..");
    }

    @Override
    public DataResult<List<Sube>> findAll() {
        return new SuccessDataResult<List<Sube>>(this.subeDao.findAll(),"Şubeler listelenmiştir..");
    }

    @Override
    public Result deleteById(int id) {
        try{
            if(id != 0 && String.valueOf(id)!= null){
                this.subeDao.deleteById(id);
            }
        }catch (Exception exception){
            return new ErrorResult("Seçili kayıt bulunamamıştır. Hata detayını inceleyiniz.."+exception);
        }
        return new SuccessResult("Secili kayıt silinmiştir..");
    }

    @Override
    public DataResult<Sube> getFindById(int id) {
        if(id != 0 || String.valueOf(id) != null){
            return new SuccessDataResult<Sube>(this.subeDao.findById(id),"Seçili kayıt listelenmiştir..");
        }else {
            return new ErrorDataResult<Sube>("Seçili kayıt listelenmemiştir..");
        }
    }
}
