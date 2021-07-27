package com.bf1el.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
		
		public String getLoggedInUserRole() {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (!(authentication instanceof AnonymousAuthenticationToken)) {
			    Collection<? extends GrantedAuthority> roles = authentication.getAuthorities();
			    
			   
			    for(GrantedAuthority role: roles) {
			    	if(role.getAuthority().equals("ROLE_admin")) {
			    		return "ADMIN";
			    	}
			    }
			}
			return null;
		}
		
		public List<String> getLoggedRoles() {
			List<String> roles = new ArrayList<String>();
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (!(authentication instanceof AnonymousAuthenticationToken)) {
			    Collection<? extends GrantedAuthority> roles1 = authentication.getAuthorities();
			    
			   
			    for(GrantedAuthority role: roles1) {
			    	if(role.getAuthority() != null) {
			    		roles.add(role.getAuthority());
			    	}
			    }
			}
			return roles;
		}
		
		public Boolean userHasRole(List<String> roles) {
			if(roles == null || roles.size() == 0) {
				return false;
			}
			return true;
		}
}
