package com.seziko.SEHMenu.bussines;

import com.seziko.SEHMenu.daos.MasaDao;
import com.seziko.SEHMenu.entities.Kullanici;
import com.seziko.SEHMenu.entities.Masa;
import com.seziko.SEHMenu.results.*;
import com.seziko.SEHMenu.services.MasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MasaManagement implements MasaService {

    private MasaDao masaDao;

    @Autowired
    public MasaManagement(MasaDao masaDao) {
        this.masaDao = masaDao;
    }

    @Override
    public Result add(Masa masa) {
        try {
            if(masa.getMasaNo() != null && (masa.getSubeId() != 0 || String.valueOf(masa.getSubeId()) != null)){
                masa.setEtar(Timestamp.valueOf(LocalDateTime.now()));
                masa.setStatus("Boş");
                this.masaDao.save(masa);
            }
        }catch (Exception exception){
            return new ErrorResult("Masa kaydı tamamlanamamıştır. Hata detayını inceleyiniz.."+exception);
        }
        return new SuccessResult("Kayıt işlemi tamamlanmıştır.");
    }

    @Override
    public DataResult<List<Masa>> findAll() {
        return new SuccessDataResult<List<Masa>>(this.masaDao.findAll(),"Masalar listelenmiştir..");
    }

    @Override
    public Result deleteById(int id) {
        try {
            if(id != 0 || String.valueOf(id) != null){
                this.masaDao.deleteById(id);
            }
        }catch (Exception exception){
            return  new ErrorResult("Seçili kayıt bulunamamıştır. Hata detayını inceleyiniz.."+exception);
        }
        return new SuccessResult("Seçili kayıt silinmiştir..");
    }

    @Override
    public DataResult<Masa> getFindById(int id) {
        try {
            if(id != 0 || String.valueOf(id) != null){

            }
        }catch (Exception exception){
            return new ErrorDataResult<Masa>("Seçili kayıt bulunamamıştır..");
        }
        return new SuccessDataResult<Masa>(this.masaDao.findById(id),"Seçili kayıt listelenmiştir.");
    }
}
