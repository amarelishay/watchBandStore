package com.PP.watchBandStore.repository;

import com.PP.watchBandStore.beans.Band;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BandRepository extends JpaRepository<Band,Integer> {
    Band findByName(String name);

}
