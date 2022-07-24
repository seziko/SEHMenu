package com.seziko.SEHMenu.daos;

import com.seziko.SEHMenu.entities.Firma;
import com.seziko.SEHMenu.entities.MasaOrder;
import com.seziko.SEHMenu.results.DataResult;
import com.seziko.SEHMenu.results.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasaOrderDao extends JpaRepository<MasaOrder,Integer> {

    MasaOrder findById(int id);


}
