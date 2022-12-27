package com.audiosharing.demo.services;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.audiosharing.demo.models.entities.ProductDetail;
import com.audiosharing.demo.models.entities.ProductRent;
import com.audiosharing.demo.models.values.ProductRentValue;
import com.audiosharing.demo.repositories.ProductRentRepository;

import java.util.List;

@Service
public class ProductRentService {
	private final ProductRentRepository productRentRepository;

	@Autowired
	public ProductRentService(ProductRentRepository productRentRepository) {
		this.productRentRepository = productRentRepository;
	}
	
	public Optional<ProductRent> findByRentId(Long id) {
		return productRentRepository.findByRentId(id);
	}

	@Transactional
	public List<ProductRent> findAll() {
		List<ProductRent> ProductRentList = this.productRentRepository.findAll();
		return ProductRentList;
	}

	@Transactional
	public ProductRent save(ProductRentValue value) {
		ProductRent productRent = ProductRent.builder().user(value.getUser()).productDetail(value.getProductDetail())
				//.rentTime(value.getRentTime()).rentPayment(value.getRentPayment())
				//.rentAdditionalPayment(value.getRentAdditionalPayment()).rentReviewFit(value.getRentReviewFit())
				//.rentReviewDesign(value.getRentReviewDesign()).rentReviewSound(value.getRentReviewSound())
				//.rentReviewBody(value.getRentReviewBody())
				.build();

		return productRentRepository.save(productRent);
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
	
	

	
	