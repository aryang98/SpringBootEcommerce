package com.aryan.ecommerce.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aryan.ecommerce.entity.User;
import com.aryan.ecommerce.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// Fetch the user from the database or any source
		User user = userRepository.findOneByEmail(email);

		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + email);
		}

		// Return a UserDetails object, typically a custom implementation
		return new CustomUserDetails(user); // This wraps your User object into UserDetails
	}
}
