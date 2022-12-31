package com.audiosharing.demo.services;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.audiosharing.demo.models.entities.Product;
import com.audiosharing.demo.models.entities.Rent;
import com.audiosharing.demo.models.values.RentValue;
import com.audiosharing.demo.repositories.RentRepository;

import java.util.List;

@Service
public class RentService {
	private final RentRepository rentRepository;

	@Autowired
	public RentService(RentRepository rentRepository) {
		this.rentRepository = rentRepository;
	}
	
	public Optional<Rent> findByRentNoPk(Long rentNoPk) {
		return rentRepository.findByRentNoPk(rentNoPk);
	}

	@Transactional
	public List<Rent> findAll() {
		List<Rent> RentList = this.rentRepository.findAll();
		return RentList;
	}

	@Transactional
	public Rent save(RentValue value) {
		Rent rent = Rent.builder().user(value.getUser()).product(value.getProduct())
				//.rentTime(value.getRentTime()).rentPayment(value.getRentPayment())
				//.rentAdditionalPayment(value.getRentAdditionalPayment()).rentReviewFit(value.getRentReviewFit())
				//.rentReviewDesign(value.getRentReviewDesign()).rentReviewSound(value.getRentReviewSound())
				//.rentReviewBody(value.getRentReviewBody())
				.build();

		return rentRepository.save(rent);
	}
	
	/*
	@Transactional
	public void rentFinishBoolean(long id) {
		Optional<ProductRent> oProductRent = productRentRepository.findByRentId(id);
		if (!oProductRent.isEmpty()) {
			ProductRent productRent = oProductRent.get();
			// 대여중 상태라면 
			if (productRent.== false) {
				// 반납상태로 변경
				productRent.setRentFinishCheck(true);
				productRentRepository.save(productRent);
				return;
			}
		}
	}
	*/
}
	
	

	
	