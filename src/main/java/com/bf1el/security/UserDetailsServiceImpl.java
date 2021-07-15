package com.bf1el.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bf1el.model.Role;
import com.bf1el.model.User;
import com.bf1el.repository.UserRepository;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
    	String lowercaseLogin = username.toLowerCase(Locale.ENGLISH);
        User user = userRepository.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException(username);
        
        List<Role> roles = userRepository.findAuthorities(lowercaseLogin);
        
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        
        for (Iterator iterator = roles.iterator(); iterator.hasNext();) {
			Role role = (Role) iterator.next();
			GrantedAuthority a = new SimpleGrantedAuthority("ROLE_" + role.getRolName());
			grantedAuthorities.add(a);
		}

		if (user != null && user.getEnabled() != null && user.getEnabled() == true) {
			return new org.springframework.security.core.userdetails.User(lowercaseLogin,
					user.getPassword(), grantedAuthorities);

		} else {
			throw new RuntimeException("User " + lowercaseLogin + " was not found in the " + "database");
		}
        

    }
}
