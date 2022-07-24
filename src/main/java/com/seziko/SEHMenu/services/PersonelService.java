package com.seziko.SEHMenu.services;

import com.seziko.SEHMenu.daos.PersonelDao;
import com.seziko.SEHMenu.entities.Personel;
import com.seziko.SEHMenu.results.DataResult;
import com.seziko.SEHMenu.results.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonelService {

    Result add(Personel personel);

    DataResult<List<Personel>> findAll();

    Result deleteById(int id);

    DataResult<Personel> findById(int id);

    DataResult<Personel> update(Personel personel,int id);


}
