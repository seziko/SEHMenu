package com.seziko.SEHMenu.services;

import com.seziko.SEHMenu.entities.Firma;
import com.seziko.SEHMenu.entities.Sube;
import com.seziko.SEHMenu.results.DataResult;
import com.seziko.SEHMenu.results.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubeService {

    Result add(Sube sube);

    DataResult<List<Sube>> findAll();

    Result deleteById(int id);

    DataResult<Sube> getFindById(int id);

}
