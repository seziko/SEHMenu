package com.seziko.SEHMenu.services;

import com.seziko.SEHMenu.entities.MasaOrder;
import com.seziko.SEHMenu.results.DataResult;
import com.seziko.SEHMenu.results.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MasaOrderService {

    Result add(MasaOrder masaOrder);

    DataResult<List<MasaOrder>> findAll();


    DataResult<MasaOrder> getFindById(int id);

}
