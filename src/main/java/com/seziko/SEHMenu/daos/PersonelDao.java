package com.seziko.SEHMenu.daos;

import com.seziko.SEHMenu.entities.Personel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonelDao extends JpaRepository<Personel,Integer> {


    Personel findById(int id);
}
