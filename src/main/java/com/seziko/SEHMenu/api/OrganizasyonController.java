package com.seziko.SEHMenu.api;

import com.seziko.SEHMenu.entities.Organizasyon;
import com.seziko.SEHMenu.results.DataResult;
import com.seziko.SEHMenu.results.Result;
import com.seziko.SEHMenu.results.SuccessResult;
import com.seziko.SEHMenu.services.OrganizasyonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/organizasyonController")
public class OrganizasyonController {
    @Autowired
    private OrganizasyonService organizasyonService;

    public OrganizasyonController(OrganizasyonService organizasyonService) {
        this.organizasyonService = organizasyonService;
    }

    @PostMapping("/organizasyonEkle")
    public Result add(Organizasyon organizasyon){
        return this.organizasyonService.add(organizasyon);
    }
    @GetMapping("/organizasyonListele")
    public DataResult<List<Organizasyon>> findAll(){
        return this.organizasyonService.findAll();
    }
    @PostMapping("/organizasyonSil")
    public Result deleteById(int id){
        return this.organizasyonService.deleteById(id);
    }
    @GetMapping("/findById")
    public DataResult<Organizasyon> findById(int id){
        return this.organizasyonService.getFindById(id);
    }
}
