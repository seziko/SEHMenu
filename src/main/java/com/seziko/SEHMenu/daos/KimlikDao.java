package com.seziko.SEHMenu.daos;

import com.seziko.SEHMenu.entities.Firma;
import com.seziko.SEHMenu.entities.Kimlik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KimlikDao extends JpaRepository<Kimlik,Integer> {


    Kimlik getBytcKimlikNo(String tcKimlikNo);

    Kimlik findById(int id);

}
