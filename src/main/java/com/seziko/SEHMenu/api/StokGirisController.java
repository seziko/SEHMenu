package com.seziko.SEHMenu.api;

import com.seziko.SEHMenu.entities.StokGiris;
import com.seziko.SEHMenu.results.DataResult;
import com.seziko.SEHMenu.results.Result;
import com.seziko.SEHMenu.services.StokGirisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stokGirisController")
public class StokGirisController {

    private StokGirisService stokGirisService;

    @Autowired
    public StokGirisController(StokGirisService stokGirisService) {
        this.stokGirisService = stokGirisService;
    }

    @PostMapping("/stokGirisEkle")
    public Result add(StokGiris stokGiris){
        return this.stokGirisService.add(stokGiris);
    }

    @GetMapping("/stokGirisListele")
    public DataResult<List<StokGiris>> findAll(){
        return this.stokGirisService.findAll();
    }

    @PostMapping("/stokGirisSil")
    public Result deleteById(int id){
        return this.stokGirisService.deleteById(id);
    }

    @GetMapping("/findById")
    public DataResult<StokGiris> findById(int id){
        return this.stokGirisService.getFindById(id);
    }
}
