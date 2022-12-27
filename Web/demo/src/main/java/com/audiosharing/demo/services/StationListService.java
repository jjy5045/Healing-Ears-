package com.audiosharing.demo.services;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.audiosharing.demo.models.entities.StationList;
import com.audiosharing.demo.models.entities.User;
import com.audiosharing.demo.models.values.StationListValue;
import com.audiosharing.demo.repositories.StationListRepository;

@Service
public class StationListService {
	private final StationListRepository stationListRepository;
	
	@Autowired
	public StationListService(StationListRepository stationListRepository) {
		this.stationListRepository = stationListRepository;
	}
	
	@Transactional(readOnly = true)
	public Optional<StationList> findByStnId(Long id) {
		return stationListRepository.findByStnId(id);
	}
	
	@Transactional
	public StationList save(StationListValue value) {
		StationList stationList = StationList.builder()
				.stnName(value.getStnName())
				.stnLatitude(value.getStnLatitude())
				.stnLongitude(value.getStnLongitude())
				.stnSido(value.getStnSido())
				.stnSigungu(value.getStnSigungu())
				.stnEubmyendong(value.getStnEubmyendong())
				.stnAdressNum(value.getStnAdressNum())
				.stnAdressLaod(value.getStnAdressLaod())
				.stnImageName(value.getStnImageName())
				.stnImageRealname(value.getStnImageRealname())
				.stnImagePath(value.getStnImagePath())
				.build();
		
		return stationListRepository.save(stationList);
	}
	
	@Transactional
	public int delete(long id) {
		Optional<StationList> oStationList = stationListRepository.findByStnId(id);
		if(oStationList.isPresent()) {
			stationListRepository.delete(oStationList.get());
			return 1;
		}
		return 0;
	}
	
	@Transactional
	public List<StationList> findAll() {
		List<StationList> stationList = this.stationListRepository.findAll();
		return stationList;
	}
	
}
