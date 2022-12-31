package com.audiosharing.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.audiosharing.demo.models.entities.Product;

@Repository
public interface ProductDetailRepository extends JpaRepository<Product, Long>{
	Optional<Product> findByProDetailId(Long id);
	List<Product> findAll();
	List<Product> findByStationListStnId(Long id);
	

}
