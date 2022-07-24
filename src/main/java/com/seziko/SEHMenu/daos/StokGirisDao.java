package com.seziko.SEHMenu.daos;

import com.seziko.SEHMenu.entities.Firma;
import com.seziko.SEHMenu.entities.StokGiris;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StokGirisDao extends JpaRepository<StokGiris,Integer> {

    StokGiris findById(int id);


}
