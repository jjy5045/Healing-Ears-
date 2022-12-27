package com.audiosharing.demo.repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.audiosharing.demo.models.entities.ProductList;

@Repository
public interface ProductListRepository extends JpaRepository<ProductList, Long>{
	Optional<ProductList> findByProListId(Long id);
	List<ProductList> findAll();
}
