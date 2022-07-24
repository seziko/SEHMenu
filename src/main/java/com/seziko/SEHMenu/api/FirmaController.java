package com.seziko.SEHMenu.api;

import com.seziko.SEHMenu.entities.Firma;
import com.seziko.SEHMenu.results.DataResult;
import com.seziko.SEHMenu.results.Result;
import com.seziko.SEHMenu.services.FirmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/firmaController")
public class FirmaController {

    private FirmaService firmaService;

    @Autowired
    public FirmaController(FirmaService firmaService) {
        this.firmaService = firmaService;
    }

    @PostMapping("/firmaEkle")
    Result add(Firma firma){
        return this.firmaService.add(firma);
    }

    @GetMapping("/firmaListele")
    DataResult<List<Firma>> findAll(){
        return this.firmaService.findAll();
    }

    @PostMapping("/firmaSil")
    Result deleteById(int id){
        return this.firmaService.deleteById(id);
    }

    @GetMapping("/getById")
    DataResult<Firma> getFindById(@RequestParam int id){
        return this.firmaService.getFindById(id);
    }
}
