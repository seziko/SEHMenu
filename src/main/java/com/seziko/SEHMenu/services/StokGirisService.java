package com.seziko.SEHMenu.services;

import com.seziko.SEHMenu.entities.Firma;
import com.seziko.SEHMenu.entities.StokGiris;
import com.seziko.SEHMenu.results.DataResult;
import com.seziko.SEHMenu.results.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StokGirisService {

    DataResult<List<StokGiris>> findAll();

    Result add(StokGiris stokGiris);

    Result deleteById(int id);

    DataResult<StokGiris> getFindById(int id);



}
