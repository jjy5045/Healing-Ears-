package com.audiosharing.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.audiosharing.demo.models.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByUserId(Long id);
	Optional<User> findByUserEmailAndUserPassword(String Email, String password);
	List<User> findAllByUserNameContains(String name);
	List<User> findAll();
}
