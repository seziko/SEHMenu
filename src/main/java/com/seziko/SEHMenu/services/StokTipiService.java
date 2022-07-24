package com.seziko.SEHMenu.services;

import com.seziko.SEHMenu.entities.Firma;
import com.seziko.SEHMenu.entities.StokTipi;
import com.seziko.SEHMenu.results.DataResult;
import com.seziko.SEHMenu.results.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StokTipiService {

    Result add(StokTipi stokTipi);

    DataResult<List<StokTipi>> findAll();

    Result deleteById (int id);

    DataResult<StokTipi> getFindById(int id);


}
