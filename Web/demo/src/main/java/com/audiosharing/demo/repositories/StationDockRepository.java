package com.audiosharing.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.audiosharing.demo.models.entities.StationDock;

@Repository
public interface StationDockRepository extends JpaRepository<StationDock, Long> {
	Optional<StationDock> findByStationDockNoPk(Long stationDockNoPk);
	List<StationDock> findAll();
}
