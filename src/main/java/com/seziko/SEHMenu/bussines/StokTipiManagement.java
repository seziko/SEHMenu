package com.seziko.SEHMenu.bussines;

import com.seziko.SEHMenu.daos.StokTipiDao;
import com.seziko.SEHMenu.entities.StokTipi;
import com.seziko.SEHMenu.results.*;
import com.seziko.SEHMenu.services.StokTipiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class StokTipiManagement implements StokTipiService {

    private StokTipiDao stokTipiDao;
    @Autowired
    public StokTipiManagement(StokTipiDao stokTipiDao) {
        this.stokTipiDao = stokTipiDao;
    }

    @Override
    public Result add(StokTipi stokTipi) {
        if(stokTipi.getAdi() != null){
            stokTipi.setEtar(Timestamp.valueOf(LocalDateTime.now()));
            stokTipi.setDurum(String.valueOf(1));
            this.stokTipiDao.save(stokTipi);
            return new SuccessResult("Stok Tipi kayıt edildi..");
        }
        return new ErrorResult("Adı alanı boş bırakılamaz..");
    }

    @Override
    public DataResult<List<StokTipi>> findAll() {
        return new SuccessDataResult<List<StokTipi>>(this.stokTipiDao.findAll(),"Stok Tipi listelenmiştir..");
    }

    @Override
    public Result deleteById(int id) {
        StokTipi stokTipi = new StokTipi();
        try {
            if(String.valueOf(id) != null) {
                this.stokTipiDao.deleteById(id);
                return new SuccessResult("Stok tipi başarılı bir şekilde silinmiştir.");
            }else {
                return new ErrorResult("Silinecek bir kayıt bulunamadı..");
            }
        } catch (Exception exception) {
            return new ErrorResult("Stok Tipi silinemedi. Lütfen bilgileri kontrol ediniz..");
        }
    }

    @Override
    public DataResult<StokTipi> getFindById(int id) {
        if(id != 0 || String.valueOf(id) != null){
            return new SuccessDataResult<StokTipi>(this.stokTipiDao.findById(id),"Seçili kayıt listelenmiştir..");
        }else {
            return new ErrorDataResult<StokTipi>("Seçili kayıt bulunamamıştır..");
        }
    }
}
