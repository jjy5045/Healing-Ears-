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
import com.audiosharing.demo.repositories.ProductRepository;
import com.audiosharing.demo.repositories.ProductListRepository;

import java.util.List;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	
	
	
	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	
	
	@Transactional(readOnly = true)
	public Optional<Product> findByProductNoPk(Long productNoPk) {
		return productRepository.findByProductNoPk(productNoPk);
	}
	
	/*
	@Transactional
	public List<Product> findByStationNoPk(long stationNoPk) {
		//List<Product> ProductList = this.productRepository.findByStationNoPk(stationNoPk);
		return ProductList;
	}
	*/
	

	
	@Transactional
	public List<Product> findAll() {
		List<Product> ProductList = this.productRepository.findAll();
		return ProductList;
	}
	
	
	/*
	@Transactional
	public void rentBoolean(long productNoPk) {
		Optional<Product> oProduct = productRepository.findByProductNoPk(productNoPk);
		if(oProduct.isPresent()) {
			Product product= oProduct.get();
			
			if(product.isProductRentCheck()==false) {
				product.setProductRentCheck(true);	
				productRepository.save(product);
				return;
		}
			
			if(product.isProductRentCheck() == true) {
				product.setProductRentCheck(false);		
				productRepository.save(product);
				return;
			}
			
		}
	}
	*/
	
	
	@Transactional
	public int patch(long productNoPk, Product value) {
		Optional<Product> oProduct = productRepository.findByProductNoPk(productNoPk);
		if(oProduct.isPresent()) {
			Product product= oProduct.get();
			if(StringUtils.isNotBlank(value.getProductSerialNumber()))
				product.setProductSerialNumber(value.getProductSerialNumber());
			if(StringUtils.isNotBlank(value.getProductColor()))
				product.setProductColor(value.getProductColor());
			
			productRepository.save(product);
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
		
		Product product = Product.builder()
				.productSerialNumber(value.getProductSerialNumber())
				.productColor(value.getProductColor())
				.build();
		
		return productRepository.save(product);
		
	}
}
