package com.bf1el.repository;

import com.bf1el.common.CustomRepository;
import com.bf1el.model.UserRole;

public interface UserRoleRepository extends CustomRepository<UserRole, Long>{

	
	UserRole save(UserRole input);
}
