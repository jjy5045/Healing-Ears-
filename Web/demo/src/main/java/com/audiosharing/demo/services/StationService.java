package com.audiosharing.demo.services;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.audiosharing.demo.models.entities.Station;
import com.audiosharing.demo.models.entities.User;
import com.audiosharing.demo.models.values.StationValue;
import com.audiosharing.demo.repositories.StationRepository;

@Service
public class StationService {
	private final StationRepository stationRepository;
	
	@Autowired
	public StationService(StationRepository stationListRepository) {
		this.stationRepository = stationListRepository;
	}
	
	@Transactional(readOnly = true)
	public Optional<Station> findByStationId(Long stationNoPk) {
		return stationRepository.findByStationNoPk(stationNoPk);
	}
	
	@Transactional
	public Station save(StationValue value) {
		Station station = Station.builder()
				.stationName(value.getStationName())
				.stationLatitude(value.getStationLatitude())
				.stationLongitude(value.getStationLongitude())
				.stationSido(value.getStationSido())
				.stationSigungu(value.getStationSigungu())
				.stationEubmyendong(value.getStationEubmyendong())
				.stationAdressNum(value.getStationAdressNum())
				.stationAdressLaod(value.getStationAdressLaod())
				.stationImageName(value.getStationImageName())
				.stationImageRealname(value.getStationImageRealname())
				.stationImagePath(value.getStationImagePath())
				.build();
		
		return stationRepository.save(station);
	}
	
	@Transactional
	public int delete(long stationNoPk) {
		Optional<Station> oStation= stationRepository.findByStationNoPk(stationNoPk);
		if(oStation.isPresent()) {
			stationRepository.delete(oStation.get());
			return 1;
		}
		return 0;
	}
	
	@Transactional
	public List<Station> findAll() {
		List<Station> station = this.stationRepository.findAll();
		return station;
	}
	
}
