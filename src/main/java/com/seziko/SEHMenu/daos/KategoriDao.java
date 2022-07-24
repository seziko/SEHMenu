package com.seziko.SEHMenu.daos;

import com.seziko.SEHMenu.entities.Firma;
import com.seziko.SEHMenu.entities.Kategori;
import com.seziko.SEHMenu.results.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KategoriDao extends JpaRepository<Kategori,Integer> {

    Kategori findById(int id);


}
