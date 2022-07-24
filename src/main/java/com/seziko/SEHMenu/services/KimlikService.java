package com.seziko.SEHMenu.services;

import com.seziko.SEHMenu.daos.KimlikDao;
import com.seziko.SEHMenu.entities.Firma;
import com.seziko.SEHMenu.entities.Kimlik;
import com.seziko.SEHMenu.results.DataResult;
import com.seziko.SEHMenu.results.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KimlikService{


    Result add(Kimlik kimlik);

    DataResult<List<Kimlik>> findAll();

    Result deleteById(int id);

    DataResult<Kimlik> getByTcKimlikNo(String tcKimlikNo);

    DataResult<Kimlik> getFindById(int id);




}
