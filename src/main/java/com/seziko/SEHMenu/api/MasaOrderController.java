package com.seziko.SEHMenu.api;

import com.seziko.SEHMenu.entities.MasaOrder;
import com.seziko.SEHMenu.results.DataResult;
import com.seziko.SEHMenu.results.Result;
import com.seziko.SEHMenu.services.MasaOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/masaOrderController")
public class MasaOrderController {

    private MasaOrderService masaOrderService;

    @Autowired
    public MasaOrderController(MasaOrderService masaOrderService) {
        this.masaOrderService = masaOrderService;
    }

    @PostMapping("/masaOrderEkle")
    public Result add(MasaOrder masaOrder){
        return this.masaOrderService.add(masaOrder);

    }

    @GetMapping("/masaOrderListele")
    public DataResult<List<MasaOrder>> findAll(){
        return this.masaOrderService.findAll();
    }

    @GetMapping("/findById")
    public DataResult<MasaOrder> findById(int id){
        return this.masaOrderService.getFindById(id);
    }


}
