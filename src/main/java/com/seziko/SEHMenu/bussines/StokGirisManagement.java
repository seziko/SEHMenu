package com.seziko.SEHMenu.bussines;

import com.seziko.SEHMenu.daos.StokGirisDao;
import com.seziko.SEHMenu.entities.StokGiris;
import com.seziko.SEHMenu.results.*;
import com.seziko.SEHMenu.services.StokGirisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class StokGirisManagement implements StokGirisService {

    private StokGirisDao stokGirisDao;

    @Autowired
    public StokGirisManagement(StokGirisDao stokGirisDao) {
        this.stokGirisDao = stokGirisDao;
    }

    @Override
    public DataResult<List<StokGiris>> findAll() {
        return new SuccessDataResult<List<StokGiris>>(this.stokGirisDao.findAll(),"Stok Girişleri listelendi.");
    }

    @Override
    public Result add(StokGiris stokGiris) {
        try {
            if(stokGiris.getMakbuzNo() != 0 && stokGiris.getMakbuz_tarihi() != null
            && stokGiris.getFirma_id() != 0 && stokGiris.getAlis_fiyat() != 0 && stokGiris.getStok_id() != 0
            && stokGiris.getGirisTarihi() != null && stokGiris.getMiktar()!= 0){
                stokGiris.setEtar(Timestamp.valueOf(LocalDateTime.now()));
                this.stokGirisDao.save(stokGiris);
                return new SuccessResult("Kayıt işlemi başarılı bir şekilde tamamlanmıştır.");
            }else {
                return new ErrorResult("Zorunlu alanların doldurulması gerekmektedir.");
            }
        } catch (Exception exception){
            return new ErrorResult("Kayıt yapılamamıştır. Hata detaylarını inceleyiniz. "+exception);
        }
    }

    @Override
    public Result deleteById(int id) {

        try {
            if(id != 0){
                this.stokGirisDao.deleteById(id);
                return new SuccessResult("Silme işlemi tamamlanmıştır.");
            } else {
                return new ErrorResult("Seçili kayıt bulunamamıştır..");
        }
        } catch (Exception exception){
            return new ErrorResult("Silme işlemi tamamlanamamıştır. Hata detayını inceleyiniz.. "+exception);
        }
    }

    @Override
    public DataResult<StokGiris> getFindById(int id) {
        if(id != 0 || String.valueOf(id) != null){
            return new SuccessDataResult<StokGiris>(this.stokGirisDao.findById(id),"Seçili kayıt listelenmiştir..");
        }else {
            return new ErrorDataResult<StokGiris>("Seçili kayıt bulunamamıştır..");
        }
    }
}
