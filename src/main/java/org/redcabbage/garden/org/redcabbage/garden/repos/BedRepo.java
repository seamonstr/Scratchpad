package org.redcabbage.garden.org.redcabbage.garden.repos;

import org.redcabbage.garden.model.Bed;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BedRepo {
    List<Bed> getAllBeds();
    List<Bed> findByName(String name);
    Bed getBed(int id);

    int addBed(Bed bed);

    void updateBed(Bed bed);
}
