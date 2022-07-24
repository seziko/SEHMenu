package com.seziko.SEHMenu.api;

import com.seziko.SEHMenu.entities.StokTipi;
import com.seziko.SEHMenu.results.DataResult;
import com.seziko.SEHMenu.results.Result;
import com.seziko.SEHMenu.services.StokTipiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("stokTipiController")
public class StoKTipiController{

    private StokTipiService stokTipiService;

    @Autowired
    public StoKTipiController(StokTipiService stokTipiService) {
        this.stokTipiService = stokTipiService;
    }

    @PostMapping("stokTipiEkle")
    Result add(StokTipi stokTipi){
        return this.stokTipiService.add(stokTipi);
    }

    @GetMapping("/stokTipiListele")
    DataResult<List<StokTipi>> findAll(){
        return this.stokTipiService.findAll();
    }

    @PostMapping("stokTipiSil")
    Result deleteById(int id){
        return this.stokTipiService.deleteById(id);
    }

    @GetMapping("/findById")
    public DataResult<StokTipi> findById(int id){
        return this.stokTipiService.getFindById(id);
    }
}
