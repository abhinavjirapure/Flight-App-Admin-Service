package com.flight.admin.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.flight.admin.entity.UserLoginEntity;
import com.flight.admin.repository.UserLoginRepository;

@Service
public class JWTUserDetailsService implements UserDetailsService{

	@Autowired
	UserLoginRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserLoginEntity> resp = repo.findByUserName(username);
		if (resp.isPresent()) {
			UserLoginEntity user = resp.get();
			return new User(user.getUserName(), bcryptPassword(user.getPassword()), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}


	public static String bcryptPassword(String password) {

		PasswordEncoder encoder = new BCryptPasswordEncoder();

		return encoder.encode(password);
	}

}
