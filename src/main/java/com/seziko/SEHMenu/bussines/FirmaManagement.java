package com.seziko.SEHMenu.bussines;

import com.seziko.SEHMenu.daos.FirmaDao;
import com.seziko.SEHMenu.entities.Firma;
import com.seziko.SEHMenu.results.*;
import com.seziko.SEHMenu.services.FirmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FirmaManagement implements FirmaService {

    private FirmaDao firmaDao;

    @Autowired
    public FirmaManagement(FirmaDao firmaDao) {
        this.firmaDao = firmaDao;
    }

    @Override
    public Result add(Firma firma) {
            if(firma.getAdi() != null || firma.getKodu() != null || firma.getIban() != null || firma.getVergiDairesi() != null
            || firma.getVergiNumarasi() != null) {
                if (firma.getGsmTelefon() != null || firma.getSirketTelefon() != null) {
                    firma.setEtar(Timestamp.valueOf(LocalDateTime.now()));
                    firmaDao.save(firma);
                    return new SuccessResult("Firma başarılı bir şekilde kayıt edilmiştir.");
                }else {
                    return new ErrorResult("Gsm Telefon ve ya Şirket telefonu alanlarından en az birini doldurmanız gerekmektedir.");
                }
            }
        return new ErrorResult("Zorunlu alanların doldurulması zorunludur..");
    }

    @Override
    public DataResult<List<Firma>> findAll() {
        return new SuccessDataResult<List<Firma>>(this.firmaDao.findAll(),"Firmalar listelenmiştir.");
    }

    @Override
    public Result deleteById(int id){
        try {
            Firma firma = new Firma();
            if(id != 0){
            this.firmaDao.deleteById(id);
            return new SuccessResult("Firma başarılı bir şekilde silinmiştir.");}
            else {
                return new ErrorResult("Seçili kayıt bulunamamıştır. Bilgileri kontrol edinizi..");
            }
        }catch (Exception exception){
            return new ErrorResult("Seçili bir kayıt bulunamamıştır.");
        }
    }

    @Override
    public DataResult<Firma> getFindById(int id) {
        Firma firma = new Firma();
        if(this.firmaDao.findById(id)!=null) {
            return new SuccessDataResult<Firma>(this.firmaDao.findById(id), "Seçili id listelenmiştir.");
        }else {
            return new ErrorDataResult<Firma>("Seçili id'ye ait kayıt bulunamamıştır.");
        }
    }
}
