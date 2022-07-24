package com.seziko.SEHMenu.services;

import com.seziko.SEHMenu.entities.Vardiya;
import com.seziko.SEHMenu.results.DataResult;
import com.seziko.SEHMenu.results.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VardiyaService {

    Result add(Vardiya personelVardiya);

    DataResult<List<Vardiya>> findAll();

    DataResult<Vardiya> findById(int id);

    Result deleteById(int id);

}
