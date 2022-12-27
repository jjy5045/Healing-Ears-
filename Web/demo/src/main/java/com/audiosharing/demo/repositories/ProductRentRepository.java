package com.audiosharing.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.audiosharing.demo.models.entities.ProductRent;

@Repository
public interface ProductRentRepository extends JpaRepository<ProductRent, Long>{
	Optional<ProductRent> findByRentId(Long id);
	List<ProductRent> findAll();
	//Optional<ProductRent> findByRentUseCheckAndProDetailId(int useCheck, ProductDetail proDetailID);
}
