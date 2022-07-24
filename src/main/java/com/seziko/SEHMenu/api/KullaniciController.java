package com.seziko.SEHMenu.api;

import com.seziko.SEHMenu.daos.KullaniciDao;
import com.seziko.SEHMenu.entities.Kullanici;
import com.seziko.SEHMenu.results.DataResult;
import com.seziko.SEHMenu.results.Result;
import com.seziko.SEHMenu.results.SuccessDataResult;
import com.seziko.SEHMenu.services.KullaniciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kullaniciController")
public class KullaniciController {

    private KullaniciService kullaniciService;

    @Autowired
    public KullaniciController(KullaniciService kullaniciService) {
        this.kullaniciService = kullaniciService;
    }

    @PostMapping("/kullaniciEkle")
    public Result add(Kullanici kullanici){
        return this.kullaniciService.add(kullanici);
    }

    @GetMapping("/kullaniciListele")
    public DataResult<List<Kullanici>> findAll(){
        return this.kullaniciService.findAll();
    }

    @PostMapping("/kullaniciSil")
    public Result deleteById(int id){
        return this.kullaniciService.deleteById(id);
    }

    @GetMapping("/getByKullaniciAdi")
    public DataResult<Kullanici> getByKullaniciAdi(@RequestParam String kullaniciAdi) {
        return this.kullaniciService.getByKullaniciAdi(kullaniciAdi);
    }
    @GetMapping("/findById")
    public DataResult<Kullanici> findById(int id){
        return this.kullaniciService.getFindById(id);
    }

   @PostMapping("/login")
    public DataResult<Kullanici> getUserNameAndPassword(String kullaniciAdi,String sifre){
        return this.kullaniciService.getUserNameAndSifre(kullaniciAdi,sifre);
   }
}
