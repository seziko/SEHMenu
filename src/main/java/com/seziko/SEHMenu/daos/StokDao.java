package com.seziko.SEHMenu.daos;

import com.seziko.SEHMenu.entities.Firma;
import com.seziko.SEHMenu.entities.Stok;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StokDao extends JpaRepository<Stok,Integer> {

    Stok findById(int id);

}
