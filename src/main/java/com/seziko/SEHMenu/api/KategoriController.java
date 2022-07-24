package com.seziko.SEHMenu.api;

import com.seziko.SEHMenu.daos.KategoriDao;
import com.seziko.SEHMenu.entities.Kategori;
import com.seziko.SEHMenu.results.DataResult;
import com.seziko.SEHMenu.results.Result;
import com.seziko.SEHMenu.results.SuccessDataResult;
import com.seziko.SEHMenu.services.KategoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kategoriController")
public class KategoriController {

    private KategoriService kategoriService;

    @Autowired
    public KategoriController(KategoriService kategoriService) {
        this.kategoriService = kategoriService;
    }

    @PostMapping("/kategoriEkle")
    public Result add(Kategori kategori){
        return this.kategoriService.add(kategori);
    }

    @GetMapping("/tumKategoriListele")
    public DataResult<List<Kategori>> findAll(){
    return this.kategoriService.findAll();
    }

    @PostMapping("/kategoriSil")
    public Result deleteById(int id){
        return this.kategoriService.deleteById(id);
    }

    @GetMapping("/findById")
    public DataResult<Kategori> findById(int id){
        return this.kategoriService.getFindById(id);
    }
}
