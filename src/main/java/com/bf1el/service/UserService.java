package com.bf1el.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bf1el.common.EntityNotFoundException;
import com.bf1el.model.Role;
import com.bf1el.model.User;
import com.bf1el.model.UserRole;
import com.bf1el.repository.RoleRepository;
import com.bf1el.repository.UserRepository;
import com.bf1el.repository.UserRoleRepository;

@Service
public class UserService {
		
		
		private UserRepository userRepository;
		
		
		private RoleRepository roleRepository;
		
		private UserRoleRepository userRoleRepository;
		
		
	    @Autowired
	    private BCryptPasswordEncoder bCryptPasswordEncoder;
		
		@Autowired
		public UserService(@Autowired UserRepository userRepository, @Autowired RoleRepository roleRepository,
				@Autowired UserRoleRepository userRoleRepository) {
			this.userRepository=userRepository;
			this.roleRepository = roleRepository;
			this.userRoleRepository = userRoleRepository;
		}
		
		public List<User>getAll(){
			return userRepository.findAll();
		}
		
		public User findById (Long id) {
			Optional <User> user=userRepository.findById(id);
			if(!user.isPresent()) {
				throw new EntityNotFoundException("User with id:" + id + " doesn't exists."); 
			}
			return user.get();
		}
		@Transactional
		public User create(User user) {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			user.setEnabled(true);
			User usr = userRepository.save(user);
			Role rol = roleRepository.findByRolName("user").get();
		    this.importRole(usr, rol);
			return usr;
			
		}
		
		public User findByUsername(String username) {
	        return userRepository.findByUsername(username);
	    }
		
		private void importRole(User user, Role role) {
			
			UserRole input = UserRole.builder()
					.user(user)
					.role(role)
					.build();
			
			this.userRoleRepository.save(input);
		}
}
