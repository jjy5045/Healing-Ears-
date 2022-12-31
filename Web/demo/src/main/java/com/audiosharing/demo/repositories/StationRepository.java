package com.audiosharing.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.audiosharing.demo.models.entities.Station;

@Repository
public interface StationListRepository extends JpaRepository<Station, Long>{
	Optional<Station> findByStnId(Long id);
	List<Station> findAllByStnNameContains(String name);
	List<Station> findAll();
}
