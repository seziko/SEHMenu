package com.seziko.SEHMenu.api;

import com.seziko.SEHMenu.entities.Personel;
import com.seziko.SEHMenu.results.DataResult;
import com.seziko.SEHMenu.results.Result;
import com.seziko.SEHMenu.services.PersonelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.List;

@RestController
@RequestMapping("/personelController")
public class PersonelController {

    private PersonelService personelService;

    @Autowired
    public PersonelController(PersonelService personelService) {
        this.personelService = personelService;
    }

    @PostMapping("/personelEkle")
    Result add(Personel personel){
        return this.personelService.add(personel);
    }
    @GetMapping("/personelListele")
    DataResult<List<Personel>> findAll(){
        return this.personelService.findAll();
    }
    @PostMapping("/personelSil")
    Result deleteById(int id){
        return this.personelService.deleteById(id);
    }
    @GetMapping("/personelBul")
    DataResult<Personel> findById(int id){
        return this.personelService.findById(id);
    }
    @PostMapping("/personelGuncelle")
    DataResult<Personel> update(Personel personel,@RequestParam int id){
        return this.personelService.update(personel,id);
    }

}
