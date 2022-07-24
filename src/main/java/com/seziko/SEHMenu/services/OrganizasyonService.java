package com.seziko.SEHMenu.services;

import com.seziko.SEHMenu.entities.Firma;
import com.seziko.SEHMenu.entities.Organizasyon;
import com.seziko.SEHMenu.results.DataResult;
import com.seziko.SEHMenu.results.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrganizasyonService {

    Result add(Organizasyon organizasyon);

    DataResult<List<Organizasyon>> findAll();

    Result deleteById(int id);

    DataResult<Organizasyon> getFindById(int id);



}
