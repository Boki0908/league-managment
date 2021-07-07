package com.bf1el.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bf1el.common.EntityNotFoundException;
import com.bf1el.model.User;
import com.bf1el.repository.UserRepository;

@Service
public class UserService {
		
		@Autowired
		private UserRepository userRepository;
		
		@Autowired
		public UserService(UserRepository userRepository) {
			this.userRepository=userRepository;
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
			
			User usr = userRepository.save(user);
			return usr;
			
		}
}
