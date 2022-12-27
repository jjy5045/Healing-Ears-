package com.audiosharing.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.audiosharing.demo.models.entities.ProductDetail;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long>{
	Optional<ProductDetail> findByProDetailId(Long id);
	List<ProductDetail> findAll();
	List<ProductDetail> findByStationListStnId(Long id);
	

}
