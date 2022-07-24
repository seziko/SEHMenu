package com.seziko.SEHMenu.daos;

import com.seziko.SEHMenu.entities.Firma;
import com.seziko.SEHMenu.entities.Sube;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubeDao extends JpaRepository<Sube,Integer> {

    Sube findById(int id);

}
