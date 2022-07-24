package com.seziko.SEHMenu.daos;

import com.seziko.SEHMenu.entities.Firma;
import com.seziko.SEHMenu.entities.Organizasyon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizasyonDao extends JpaRepository<Organizasyon,Integer> {

    Organizasyon findById(int id);

}
