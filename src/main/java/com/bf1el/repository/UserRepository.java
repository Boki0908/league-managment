package com.bf1el.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.bf1el.common.CustomRepository;
import com.bf1el.model.User;


@Repository
public interface UserRepository extends CustomRepository<User, Long>{
	
	User findOneByUserUsername(String name);

	Optional<User> findById(Long id);

	User save(User user);

	List<User> findAll();

}
