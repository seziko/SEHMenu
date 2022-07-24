package com.seziko.SEHMenu.bussines;

import com.seziko.SEHMenu.daos.MasaOrderDao;
import com.seziko.SEHMenu.entities.Masa;
import com.seziko.SEHMenu.entities.MasaOrder;
import com.seziko.SEHMenu.results.*;
import com.seziko.SEHMenu.services.MasaOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MasaOrderManagement implements MasaOrderService {

    private MasaOrderDao masaOrderDao;

    @Autowired
    public MasaOrderManagement(MasaOrderDao masaOrderDao) {
        this.masaOrderDao = masaOrderDao;
    }


    @Override
    public Result add(MasaOrder masaOrder) {
        try {
            if((masaOrder.getMasaId()!= 0 || String.valueOf(masaOrder.getMasaId())!=null)){
                masaOrder.setEtar(Timestamp.valueOf(LocalDateTime.now()));
                this.masaOrderDao.save(masaOrder);
            }
        }catch (Exception exception){
            return new ErrorResult("Hatalı bir işlem yaptınız. Hata detayını inceleyiniz.."+exception);
        }
        return new SuccessResult("Order başarılı bir şekilde açılmıştır..");
    }

    @Override
    public DataResult<List<MasaOrder>> findAll() {
        return new SuccessDataResult<List<MasaOrder>>(this.masaOrderDao.findAll(),"Orderlar listelenmiştir.");
    }
    @Override
    public DataResult<MasaOrder> getFindById(int id) {
        if(id != 0 || String.valueOf(id) != null){
            return new SuccessDataResult<MasaOrder>(this.masaOrderDao.findById(id),"Seçili id listelenmiştir.");
        }else {
            return new ErrorDataResult<MasaOrder>("Seçili kayıt bulunamamıştır..");
        }
    }

}
