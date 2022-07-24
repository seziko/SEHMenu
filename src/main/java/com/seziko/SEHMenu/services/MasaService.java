package com.seziko.SEHMenu.services;

import com.seziko.SEHMenu.entities.Firma;
import com.seziko.SEHMenu.entities.Masa;
import com.seziko.SEHMenu.results.DataResult;
import com.seziko.SEHMenu.results.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MasaService {

    Result add(Masa masa);

    DataResult<List<Masa>> findAll();

    Result deleteById(int id);

    DataResult<Masa> getFindById(int id);

}
