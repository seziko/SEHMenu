package com.seziko.SEHMenu.api;

import com.seziko.SEHMenu.entities.Vardiya;
import com.seziko.SEHMenu.results.DataResult;
import com.seziko.SEHMenu.results.Result;
import com.seziko.SEHMenu.services.VardiyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vardiyaController")
public class VardiyaController {

    private VardiyaService vardiyaService;

    @Autowired
    public VardiyaController(VardiyaService vardiyaService) {
        this.vardiyaService = vardiyaService;
    }

    @PostMapping("/vardiyaEkle")
    Result add(Vardiya personelVardiya){
        return this.vardiyaService.add(personelVardiya);
    }
    @GetMapping("/vardiyaListele")
    DataResult<List<Vardiya>> findAll(){
        return this.vardiyaService.findAll();
    }
    @GetMapping("/vardiyaBul")
    DataResult<Vardiya> findById(int id){
        return this.vardiyaService.findById(id);
    }
    @PostMapping("/vardiyaSil")
    Result deleteById(int id){
        return this.vardiyaService.deleteById(id);
    }
}
