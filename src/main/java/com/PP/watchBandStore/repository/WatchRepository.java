package com.PP.watchBandStore.repository;

import com.PP.watchBandStore.beans.Watch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchRepository extends JpaRepository<Watch,Integer> {
}
