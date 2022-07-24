package com.seziko.SEHMenu.api;

import com.seziko.SEHMenu.entities.Stok;
import com.seziko.SEHMenu.results.DataResult;
import com.seziko.SEHMenu.results.Result;
import com.seziko.SEHMenu.services.StokService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.util.List;

@RestController
@RequestMapping("stokController")
public class StokController {

    private StokService stokService;

    @Autowired
    public StokController(StokService stokService) {
        this.stokService = stokService;
    }

    @PostMapping("stokEkle")
    Result add(Stok stok){
        return this.stokService.add(stok);
    }

    @GetMapping("/stokListele")
    DataResult<List<Stok>> findAll(){
        return this.stokService.findAll();
    }

    @PostMapping("stokSil")
    Result deleteById(int id){
        return this.stokService.deleteById(id);
    }

    @GetMapping("/findById")
    public DataResult<Stok> findById(int id){
        return this.stokService.getFindById(id);
    }
}
