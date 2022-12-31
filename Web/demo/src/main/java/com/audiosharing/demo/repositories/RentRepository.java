package com.audiosharing.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.audiosharing.demo.models.entities.Rent;

@Repository
public interface ProductRentRepository extends JpaRepository<Rent, Long>{
	Optional<Rent> findByRentId(Long id);
	List<Rent> findAll();
	//Optional<ProductRent> findByRentUseCheckAndProDetailId(int useCheck, ProductDetail proDetailID);
}
