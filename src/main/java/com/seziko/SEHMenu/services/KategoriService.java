package com.seziko.SEHMenu.services;

import com.seziko.SEHMenu.daos.KategoriDao;
import com.seziko.SEHMenu.entities.Firma;
import com.seziko.SEHMenu.entities.Kategori;
import com.seziko.SEHMenu.results.DataResult;
import com.seziko.SEHMenu.results.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KategoriService {

    Result add(Kategori kategori);

    DataResult<List<Kategori>> findAll();

    Result deleteById(int id);

    DataResult<Kategori> getFindById(int id);
}
