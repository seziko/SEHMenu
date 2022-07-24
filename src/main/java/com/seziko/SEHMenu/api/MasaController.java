package com.seziko.SEHMenu.api;

import com.seziko.SEHMenu.entities.Masa;
import com.seziko.SEHMenu.results.DataResult;
import com.seziko.SEHMenu.results.Result;
import com.seziko.SEHMenu.services.MasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/masaController")
public class MasaController {

    private MasaService masaService;

    @Autowired
    public MasaController(MasaService masaService) {
        this.masaService = masaService;
    }

    @PostMapping("/masaEkle")
    public Result add(Masa masa){
        return this.masaService.add(masa);
    }

    @GetMapping("/masaListele")
    public DataResult<List<Masa>> findAll(){
        return this.masaService.findAll();
    }

    @PostMapping("/masaSil")
    public Result deleteById(int id){
        return this.masaService.deleteById(id);
    }

    @GetMapping("/findById")
    public DataResult<Masa> findById(int id){
        return this.masaService.getFindById(id);
    }
}
