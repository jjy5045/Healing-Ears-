package com.audiosharing.demo.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.audiosharing.demo.repositories.StationDockRepository;
import com.audiosharing.demo.models.entities.StationDock;

@Service
public class StationDockService {
	private final StationDockRepository stationDockRepository;
	
	@Autowired
	public StationDockService(StationDockRepository stationDockRepository) {
		this.stationDockRepository = stationDockRepository;
	}
	
	@Transactional(readOnly = true)
	public Optional<StationDock> findByStationNoPk(Long stationDockNoPk) {
		return stationDockRepository.findByStationDockNoPk(stationDockNoPk);
	}

	@Transactional
	public StationDock save(StationDock value) {
		StationDock stationdock = StationDock.builder()
				.stationDockName(value.getStationDockName())
				.stationDockQr(value.getStationDockQr())
				.station(value.getStation())
				.product(value.getProduct())
				.build();
		
		return stationDockRepository.save(value);
	}
}
