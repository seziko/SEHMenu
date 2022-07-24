package com.seziko.SEHMenu.bussines;

import com.seziko.SEHMenu.daos.KategoriDao;
import com.seziko.SEHMenu.entities.Kategori;
import com.seziko.SEHMenu.results.*;
import com.seziko.SEHMenu.services.KategoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class KategoriManagement implements KategoriService {

    private KategoriDao kategoriDao;

    @Autowired
    public KategoriManagement(KategoriDao kategoriDao) {
        this.kategoriDao = kategoriDao;
    }

    @Override
    public Result add(Kategori kategori) {
        kategori.setEtar(Timestamp.valueOf(LocalDateTime.now()));
        this.kategoriDao.save(kategori);
        return new SuccessDataResult<Kategori>(kategori,"Kategori eklenmiştir..");
    }

    @Override
    public DataResult<List<Kategori>> findAll() {
        return new SuccessDataResult<List<Kategori>>(this.kategoriDao.findAll(),"Kategoriler listelenmiştir.");
    }

    @Override
    public Result deleteById(int id) {
        try {
            this.kategoriDao.deleteById(id);
        }catch (Exception exception){
            return new ErrorResult("Kategori silinememiştir. Lütfen kontrol ediniz..");
        }
        return new SuccessResult("Kategori silinmiştir.");
    }

    @Override
    public DataResult<Kategori> getFindById(int id) {
        try {
            if(id != 0 || String.valueOf(id) != null){
                this.kategoriDao.findById(id);
        }
        }catch (Exception exception){
            return new ErrorDataResult<Kategori>("Seçili kayıt bulunamamıştır.Hata detayını inceleyiniz.."+exception);
        }
        return new SuccessDataResult<Kategori>(this.kategoriDao.findById(id),"Seçili kayıt listelenmiştir..");
    }
}
