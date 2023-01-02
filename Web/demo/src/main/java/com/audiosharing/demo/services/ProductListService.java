package com.audiosharing.demo.services;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.audiosharing.demo.models.entities.Product;
import com.audiosharing.demo.models.entities.ProductList;
import com.audiosharing.demo.models.entities.User;
import com.audiosharing.demo.models.values.ProductValue;
import com.audiosharing.demo.models.values.ProductListValue;
import com.audiosharing.demo.models.values.UserValue;
import com.audiosharing.demo.repositories.ProductRepository;
import com.audiosharing.demo.repositories.ProductListRepository;

import java.util.List;

@Service
public class ProductListService {
	private final ProductListRepository productListRepository;
	
	@Autowired
	public ProductListService(ProductListRepository productListRepository) {
		this.productListRepository = productListRepository;
	}
	
	@Transactional(readOnly = true)
	public Optional<ProductList> findByProListId(Long productListNoPk) {
		return productListRepository.findByProductListNoPk(productListNoPk);
	}
	
	@Transactional
	public List<ProductList> findAll() {
		List<ProductList> ProductList= this.productListRepository.findAll();
		return ProductList;
	}
	
	@Transactional
	public ProductList save(ProductListValue value) {
		
		ProductList productList = ProductList.builder()
				.productListName(value.getProductListName())
				.productListCategory(value.getProductListCategory())
				.productListLine(value.getProductListLine())
				.productListType(value.getProductListType())
				.productListWearingType(value.getProductListWearingType())
				.productListCompany(value.getProductListCompany())
				.productListInfoBody(value.getProductListInfoBody())
				.productListRentPrice(value.getProductListRentPrice())
				.productListPrice(value.getProductListPrice()).build();

		return productListRepository.save(productList);
	}
}
