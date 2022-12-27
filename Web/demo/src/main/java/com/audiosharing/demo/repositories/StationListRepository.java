package com.audiosharing.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.audiosharing.demo.models.entities.StationList;

@Repository
public interface StationListRepository extends JpaRepository<StationList, Long>{
	Optional<StationList> findByStnId(Long id);
	List<StationList> findAllByStnNameContains(String name);
	List<StationList> findAll();
}
