package com.audiosharing.demo.services;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.audiosharing.demo.models.entities.ProductDetail;
import com.audiosharing.demo.models.entities.ProductList;
import com.audiosharing.demo.models.entities.ProductRent;
import com.audiosharing.demo.models.values.ProductDetailValue;
import com.audiosharing.demo.models.values.ProductListValue;
import com.audiosharing.demo.models.values.ProductRentValue;
import com.audiosharing.demo.repositories.ProductDetailRepository;
import com.audiosharing.demo.repositories.ProductListRepository;

import java.util.List;

@Service
public class ProductDetailService {
	private final ProductDetailRepository productDetailRepository;
	
	
	
	@Autowired
	public ProductDetailService(ProductDetailRepository productDetailRepository) {
		this.productDetailRepository = productDetailRepository;
	}
	
	
	
	@Transactional(readOnly = true)
	public Optional<ProductDetail> findByProDetailId(Long id) {
		return productDetailRepository.findByProDetailId(id);
	}
	
	@Transactional
	public List<ProductDetail> findByStationId(long id) {
		List<ProductDetail> ProductDetailList = this.productDetailRepository. findByStationListStnId(id);
		return ProductDetailList;
	}
	

	
	@Transactional
	public List<ProductDetail> findAll() {
		List<ProductDetail> ProductDetailList = this.productDetailRepository.findAll();
		return ProductDetailList;
	}
	
	
	@Transactional
	public void rentBoolean(long id) {
		Optional<ProductDetail> oProductDetail = productDetailRepository.findByProDetailId(id);
		if(oProductDetail.isPresent()) {
			ProductDetail productDetail = oProductDetail.get();
			
			if(productDetail.isProDetailRentCheck()==false) {
				productDetail.setProDetailRentCheck(true);	
				productDetailRepository.save(productDetail);
				return;
		}
			
			if(productDetail.isProDetailRentCheck() == true) {
				productDetail.setProDetailRentCheck(false);		
				productDetailRepository.save(productDetail);
				return;
			}
			
		}
	}
	
	
	
	
	@Transactional
	public int patch(long id, ProductDetailValue value) {
		Optional<ProductDetail> oProductDetail = productDetailRepository.findByProDetailId(id);
		if(oProductDetail.isPresent()) {
			ProductDetail productDetail = oProductDetail.get();
			if(StringUtils.isNotBlank(value.getProDetailNumber()))
				productDetail.setProDetailNumber(value.getProDetailNumber());
			if(StringUtils.isNotBlank(value.getProDetailQR()))
				productDetail.setProDetailNumber(value.getProDetailQR());
			
			productDetailRepository.save(productDetail);
			return 1;
		}
		
		return 0;
	}
	
	
	@Transactional
	public ProductDetail save(ProductDetailValue value) {
		//long a = value.getProListId();
		//if(productListRepository.findByProListId(value.getProListId())) 
		/*
		if(productListRepository.findByProListId(value.getProListId()) != null)
		{
			ProductDetail productDetail = ProductDetail.builder()
					.productList(productListRepository. findByProListId(value.getProListId()).get())
					.proDetailNumber(value.getProDetailNumber())
					.proDetailQR(value.getProDetailQR()).build();
			
			return productDetailRepository.save(productDetail);
		} else {
			return null;
		}
		*/
		
		ProductDetail productDetail = ProductDetail.builder()
				.stationList(value.getStationList())
				.productList(value.getProductList())
				.proDetailNumber(value.getProDetailNumber())
				.proDetailQR(value.getProDetailQR()).build();
		
		return productDetailRepository.save(productDetail);
		
	}
}
