package com.seziko.SEHMenu.bussines;

import com.seziko.SEHMenu.daos.StokDao;
import com.seziko.SEHMenu.entities.Stok;
import com.seziko.SEHMenu.results.*;
import com.seziko.SEHMenu.services.StokService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class StokManagement implements StokService {

    private StokDao stokDao;

    @Autowired
    public StokManagement(StokDao stokDao) {
        this.stokDao = stokDao;
    }

    @Override
    public Result add(Stok stok) {
        try {
            if (stok.getAdi() != null && stok.getKodu() != null) {
                if (stok.getStokTipi() != 0) {
                    stok.setEtar(Timestamp.valueOf(LocalDateTime.now()));
                    this.stokDao.save(stok);
                    return new SuccessResult("Stok başarılı bir şekilde kayıt edilmiştir.");
                } else {
                    return new ErrorResult("Stok Tipi alanı boş olamaz..");
                }
            }else {
                return new ErrorResult("Stok kayıt edilemedi. Zorunlu alanları kontrol ediniz..");
            }
        } catch (Exception exception) {
            return new ErrorResult("Stok kayıt edilemedi. Zorunlu alanları kontrol ediniz..");
        }
    }

    @Override
    public DataResult<List<Stok>> findAll() {
        return new SuccessDataResult<List<Stok>>(this.stokDao.findAll(),"Stok listelenmiştir.");
    }

    @Override
    public Result deleteById(int id) {
            try {
                if(String.valueOf(id) != null){
                    this.stokDao.deleteById(id);
                }else {
                    return  new ErrorResult("Silinecek kayıt bulunamadı..");
                }
            }catch (Exception exception){
                return new ErrorResult("Stok silinemedi. Bilgileri kontrol ediniz..");
            }
        return new SuccessResult("Stok başarılı bir şekilde silinmiştir.");
    }

    @Override
    public DataResult<Stok> getFindById(int id) {
        if(id != 0 || String.valueOf(id) != null){
            return new SuccessDataResult<Stok>(this.stokDao.findById(id),"Seçili kayıt listelenmiştir..");
        }else {
            return new ErrorDataResult<Stok>("Seçili kayıt bulunamamıştır..");
        }
    }
}
