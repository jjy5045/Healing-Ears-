package com.audiosharing.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.audiosharing.demo.models.entities.ProductDetail;
import com.audiosharing.demo.models.values.ProductDetailValue;
import com.audiosharing.demo.repositories.ProductListRepository;
import com.audiosharing.demo.services.ProductDetailService;
import com.audiosharing.demo.services.ProductListService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(value = "/productDetail", produces = { MediaType.APPLICATION_JSON_VALUE })
@RestController
public class ProductDetailController {
	private final ProductDetailService productDetailService;
	private final ProductListService productListService;
	private final ObjectMapper mapper;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<String> findByProDetailId(@PathVariable("id") long id) throws JsonProcessingException {
		Optional<ProductDetail> oProductDetail = productDetailService.findByProDetailId(id);
		String result = null;
		if(oProductDetail.isPresent()) {
			result = mapper.writeValueAsString(oProductDetail);
		} else {
			result = "False";
		}
		
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	
	
	@GetMapping("/station/{id}")
	public ResponseEntity<Map<String, Object>> findByStnIdAllProDetailId(@PathVariable("id") long id) throws JsonProcessingException {
		Map<String, Object> response = new HashMap<>();
		
		List<ProductDetail> LProductDetail = productDetailService.findByStationId(id);
		
		if(!LProductDetail.isEmpty()) {
			response.put("result", "SUCCESS");
			response.put("productDetail", LProductDetail );
		} else {
			response.put("result", "FAIL");
		}
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public Map<String, Object> findAll() {
		Map<String, Object> response = new HashMap<>();
		
		List<ProductDetail> LProductDetail = productDetailService.findAll();
		if (!LProductDetail.isEmpty()) {
			response.put("result", "SUCCESS");
			response.put("productDetail", LProductDetail);
		} else {
			response.put("result", "FAIL");
			response.put("reason", "등록된 제품이 없습니다.");
		}
		
		return response;
	}
	
	@PostMapping("")
	public Map<String, Object> save(@RequestBody ProductDetailValue value) {
		Map<String, Object> response = new HashMap<>();

		ProductDetail productDetail = productDetailService.save(value);
		
		//productDetail.getProductList()
		
		if (productDetail != null) {
			response.put("result", "SUCCESS");
			response.put("productDetail", productDetail);
		} else {
			response.put("result", "FAIL");
			response.put("reason", "제품 등록 성공");
		}

		return response;
	}
}
