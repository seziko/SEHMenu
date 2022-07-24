package com.seziko.SEHMenu.daos;

import com.seziko.SEHMenu.entities.Vardiya;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VardiyaDao extends JpaRepository<Vardiya,Integer> {

    Vardiya findById(int id);
}
