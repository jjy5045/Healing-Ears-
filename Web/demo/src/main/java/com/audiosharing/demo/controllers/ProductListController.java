package com.audiosharing.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.audiosharing.demo.models.entities.ProductDetail;
import com.audiosharing.demo.models.entities.ProductList;
import com.audiosharing.demo.models.values.ProductDetailValue;
import com.audiosharing.demo.models.values.ProductListValue;
import com.audiosharing.demo.repositories.ProductListRepository;
import com.audiosharing.demo.services.ProductListService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RequestMapping(value = "/productList", produces = { MediaType.APPLICATION_JSON_VALUE })
@RestController
public class ProductListController {
	private final ProductListService productListService;
	
	// 제품 전체 검색
	@GetMapping("/all")
	public Map<String, Object> findAll() {
		Map<String, Object> response = new HashMap<>();
		
		List<ProductList> LProductList = productListService.findAll();
		if (!LProductList.isEmpty()) {
			response.put("result", "SUCCESS");
			response.put("productList", LProductList);
		} else {
			response.put("result", "FAIL");
			response.put("reason", "등록된 제품이 없습니다.");
		}
		
		return response;
	}
	
	@PostMapping("")
	public Map<String, Object> save(@RequestBody ProductListValue value) {
		Map<String, Object> response = new HashMap<>();

		ProductList productList = productListService.save(value);
		if (productList != null) {
			response.put("result", "SUCCESS");
			response.put("productList", productList);
		} else {
			response.put("result", "FAIL");
			response.put("reason", "제품 등록 성공");
		}

		return response;
	}
}
