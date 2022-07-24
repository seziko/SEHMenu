package com.seziko.SEHMenu.services;

import com.seziko.SEHMenu.daos.FirmaDao;
import com.seziko.SEHMenu.entities.Firma;
import com.seziko.SEHMenu.entities.Kimlik;
import com.seziko.SEHMenu.results.DataResult;
import com.seziko.SEHMenu.results.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FirmaService {


    Result add(Firma firma);

    DataResult<List<Firma>> findAll();

    Result deleteById(int id);

    DataResult<Firma> getFindById(int id);




}
