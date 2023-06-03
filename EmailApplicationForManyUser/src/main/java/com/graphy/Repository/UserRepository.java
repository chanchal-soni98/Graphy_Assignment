package com.graphy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.graphy.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface UserRepository extends JpaRepository<User, Integer>{
	Page<User> findAll(Pageable pageable);

	User findByEmail(String email);
}
