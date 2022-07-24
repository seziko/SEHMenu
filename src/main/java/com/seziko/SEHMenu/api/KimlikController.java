package com.seziko.SEHMenu.api;

import com.seziko.SEHMenu.entities.Kimlik;
import com.seziko.SEHMenu.results.DataResult;
import com.seziko.SEHMenu.results.Result;
import com.seziko.SEHMenu.services.KimlikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.List;

@RestController
@RequestMapping("/kimlikController")
public class KimlikController {

    private KimlikService kimlikService;

    public KimlikController(KimlikService kimlikService) {
        this.kimlikService = kimlikService;
    }

    @PostMapping("/kimlikEkle")
    public Result add(Kimlik kimlik){
        kimlik.setAdiSoyadi(kimlik.getAdi()+' '+kimlik.getSoyadi());
        return this.kimlikService.add(kimlik);
    }

    @GetMapping("/kimlikListele")
    public DataResult<List<Kimlik>> findAll(){
        return this.kimlikService.findAll();
    }


    @PostMapping("/kimlikSil")
    public Result deleteById(int id){
        return this.kimlikService.deleteById(id);
    }

    @GetMapping("/tcKimlikNoBul")
    public DataResult<Kimlik> getByTcKimlikNo(String tcKimlikNo){
        return this.kimlikService.getByTcKimlikNo(tcKimlikNo);
    }

    @GetMapping("/findById")
    public DataResult<Kimlik> findById(int id){
        return this.kimlikService.getFindById(id);
    }

}
