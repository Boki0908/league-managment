package com.bf1el.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bf1el.common.CustomRepository;
import com.bf1el.model.Role;
import com.bf1el.model.User;


@Repository
public interface UserRepository extends CustomRepository<User, Long>{
	
	User findByUsername(String name);

	Optional<User> findById(Long id);

	User save(User user);

	List<User> findAll();
	
	@Query("SELECT r from UserRole ur INNER JOIN ur.role r INNER JOIN ur.user u WHERE u.username = :userName")
    List<Role> findAuthorities(@Param("userName") String username);


}
