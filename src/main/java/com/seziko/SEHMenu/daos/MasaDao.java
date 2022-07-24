package com.seziko.SEHMenu.daos;

import com.seziko.SEHMenu.entities.Firma;
import com.seziko.SEHMenu.entities.Masa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasaDao extends JpaRepository<Masa,Integer> {

    Masa findById(int id);

}
