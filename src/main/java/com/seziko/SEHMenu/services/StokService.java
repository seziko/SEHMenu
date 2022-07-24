package com.seziko.SEHMenu.services;

import com.seziko.SEHMenu.daos.StokDao;
import com.seziko.SEHMenu.entities.Firma;
import com.seziko.SEHMenu.entities.Stok;
import com.seziko.SEHMenu.results.DataResult;
import com.seziko.SEHMenu.results.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StokService {



    Result add(Stok stok);

    DataResult<List<Stok>> findAll();

    Result deleteById(int id);

    DataResult<Stok> getFindById(int id);



}
