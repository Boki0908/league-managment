package com.bf1el.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.bf1el.common.CustomRepository;
import com.bf1el.model.Role;


@Repository
public interface RoleRepository extends CustomRepository<Role, Long>{
	
	Optional<Role> findByRolName(String rolName);;

}
