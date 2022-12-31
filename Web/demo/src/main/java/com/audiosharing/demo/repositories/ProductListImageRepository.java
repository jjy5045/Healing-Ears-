package com.audiosharing.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.audiosharing.demo.models.entities.ProductListImage;

@Repository
public interface ProductListImageRepository extends JpaRepository<ProductListImage, Long> {
	Optional<ProductListImage> findByProductListImageNoPk(Long productListImageNoPk);
	List<ProductListImage> findAll();
}
