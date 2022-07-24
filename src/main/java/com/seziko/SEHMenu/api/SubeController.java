package com.seziko.SEHMenu.api;

import com.seziko.SEHMenu.entities.Sube;
import com.seziko.SEHMenu.results.DataResult;
import com.seziko.SEHMenu.results.Result;
import com.seziko.SEHMenu.services.SubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subeController")
public class SubeController {

    private SubeService subeService;

    @Autowired
    public SubeController(SubeService subeService) {
        this.subeService = subeService;
    }

    @PostMapping("subeEkle")
    public Result add(Sube sube){
        return this.subeService.add(sube);
    }
    @GetMapping("/subeListele")
    public DataResult<List<Sube>> findAll(){
        return this.subeService.findAll();
    }
    @PostMapping("/subeSil")
    public Result deleteById(int id){
        return this.subeService.deleteById(id);
    }

    @GetMapping("/findById")
    public DataResult<Sube> findById(int id){
        return this.subeService.getFindById(id);
    }

}
