package com.seziko.SEHMenu.daos;

import com.seziko.SEHMenu.entities.Firma;
import com.seziko.SEHMenu.results.DataResult;
import com.seziko.SEHMenu.results.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;

public interface FirmaDao extends JpaRepository<Firma,Integer> {

    Firma findById(int id);

}
