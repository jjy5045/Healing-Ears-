package com.audiosharing.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.audiosharing.demo.models.values.ProductRentValue;
import com.audiosharing.demo.services.ProductRentService;
import com.audiosharing.demo.services.UserService;
import com.audiosharing.demo.models.entities.ProductDetail;
import com.audiosharing.demo.models.entities.ProductRent;
import com.audiosharing.demo.services.ProductDetailService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(value = "/productRent", produces = { MediaType.APPLICATION_JSON_VALUE })
@RestController
public class ProductRentController {
	private final ProductRentService productRentService;
	private final ProductDetailService productDetailService;

	@GetMapping("/all")
	public Map<String, Object> findAll() {
		Map<String, Object> response = new HashMap<>();

		List<ProductRent> LProductRent = productRentService.findAll();
		if (!LProductRent.isEmpty()) {
			response.put("result", "SUCCESS");
			response.put("productRent", LProductRent);
		} else {
			response.put("result", "FAIL");
			response.put("reason", "등록된 예약건이 없습니다.");
		}

		return response;
	}

	@PostMapping("/rent")
	public Map<String, Object> Rent(@RequestBody ProductRentValue value) {
		Map<String, Object> response = new HashMap<>();

		Optional<ProductDetail> oProductDetail = productDetailService
				.findByProDetailId(value.getProductDetail().getProDetailId());

		// 제품이 존재하면
		if (oProductDetail.isPresent()) {
			// 제품 상태가 대여 가능하다면
			if (oProductDetail.get().isProDetailRentCheck() == false) {
				response.put("result", "SUCCESS");

				// 제품 Rent 생성
				ProductRent productRent = productRentService.save(value);

				// 제품의 상태를 대여중으로 변경
				productDetailService.rentBoolean(value.getProductDetail().getProDetailId());
				
				response.put("result", "SUCCESS");
				response.put("productRent", productRent);
				return response;
			}
			// 대여중인 상품이라면
			else {
				response.put("result", "FAIL");
				response.put("reason", "이미 대여중인 상품입니다.");
				return response;
			}
		}

		// 해당 제품이 존재하지 않다면
		response.put("result", "FAIL");
		response.put("reason", "존재하지 않는 상품입니다.");
		return response;
	}

	@PostMapping("/finish")
	public Map<String, Object> RentFinish(@RequestBody ProductRentValue value) {
		Map<String, Object> response = new HashMap<>();

		Optional<ProductDetail> oProductDetail = productDetailService
				.findByProDetailId(value.getProductDetail().getProDetailId());
		// Optional<ProductRent> oProductRent =
		// productRentService.findByRentId(value.get);
		// int rentState = productRentService.rentFinishBoolean((Long)
		// value.getProductDetail().getProDetailId());
		// boolean productState = value.getProductDetail().isProDetailRentCheck();
		// int productState =
		// productDetailService.rentBoolean((Long)value.getProductDetail().getProDetailId());
		// productDetail.getProductList()

		if (oProductDetail.get().isProDetailRentCheck() == true) {
			// Rent 상태 종료로 변경
			//productRentService.rentFinishBoolean(value.getRentId());
			// 제품 상태를 대기중으로 변경
			productDetailService.rentBoolean(value.getProductDetail().getProDetailId());
			response.put("result", "SUCCESS");
		} else {
			response.put("result", "FAIL");
			response.put("reason", "이미 반납된 상태입니다.");
		}

		return response;
	}

	/*
	 * @PostMapping("/rent") public Map<String, Object> Rent(@RequestBody
	 * ProductRentValue value) { Map<String, Object> response = new HashMap<>();
	 * 
	 * ProductRent productRent = productRentService.save(value); int rentState =
	 * productRentService.rentFinishBoolean((Long)value.getProductDetail().
	 * getProDetailId()); //int productState =
	 * productDetailService.rentBoolean((Long)value.getProductDetail().
	 * getProDetailId()); //productDetail.getProductList()
	 * 
	 * if (productRent != null) { response.put("result", "SUCCESS");
	 * response.put("productRent", productRent); } else { response.put("result",
	 * "FAIL"); response.put("reason", "이미 대여중인 상품입니다."); }
	 * 
	 * return response; }
	 * 
	 * 
	 * @PostMapping("/finish") public Map<String, Object> RentFinish(@RequestBody
	 * ProductRentValue value) { Map<String, Object> response = new HashMap<>();
	 * 
	 * ProductRent productRent = productRentService.save(value); int rentState =
	 * productRentService.rentFinishBoolean((Long)value.getProductDetail().
	 * getProDetailId()); int productState =
	 * productDetailService.rentBoolean((Long)value.getProductDetail().
	 * getProDetailId()); //productDetail.getProductList()
	 * 
	 * if (rentState == 2 && productState == 2 && productRent != null) {
	 * response.put("result", "SUCCESS"); response.put("productRent", productRent);
	 * } else { response.put("result", "FAIL"); response.put("reason", "에러"); }
	 * 
	 * return response; }
	 */

}
