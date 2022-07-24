package com.seziko.SEHMenu.daos;

import com.seziko.SEHMenu.entities.Firma;
import com.seziko.SEHMenu.entities.StokGiris;
import com.seziko.SEHMenu.entities.StokTipi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StokTipiDao extends JpaRepository<StokTipi, Integer> {


    StokTipi findById(int id);

}
