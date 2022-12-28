package com.audiosharing.demo.services;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.audiosharing.demo.models.entities.Product;
import com.audiosharing.demo.models.entities.ProductList;
import com.audiosharing.demo.models.entities.Rent;
import com.audiosharing.demo.models.values.ProductValue;
import com.audiosharing.demo.models.values.ProductListValue;
import com.audiosharing.demo.models.values.RentValue;
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
	public Optional<Product> findByProDetailId(Long id) {
		return productDetailRepository.findByProDetailId(id);
	}
	
	@Transactional
	public List<Product> findByStationId(long id) {
		List<Product> ProductDetailList = this.productDetailRepository. findByStationListStnId(id);
		return ProductDetailList;
	}
	

	
	@Transactional
	public List<Product> findAll() {
		List<Product> ProductDetailList = this.productDetailRepository.findAll();
		return ProductDetailList;
	}
	
	
	@Transactional
	public void rentBoolean(long id) {
		Optional<Product> oProductDetail = productDetailRepository.findByProDetailId(id);
		if(oProductDetail.isPresent()) {
			Product productDetail = oProductDetail.get();
			
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
	public int patch(long id, Product value) {
		Optional<Product> oProductDetail = productDetailRepository.findByProDetailId(id);
		if(oProductDetail.isPresent()) {
			Product productDetail = oProductDetail.get();
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
	public Product save(Product value) {
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
		
		Product productDetail = Product.builder()
				.stationList(value.getStationList())
				.productList(value.getProductList())
				.proDetailNumber(value.getProDetailNumber())
				.proDetailQR(value.getProDetailQR()).build();
		
		return productDetailRepository.save(productDetail);
		
	}
}
