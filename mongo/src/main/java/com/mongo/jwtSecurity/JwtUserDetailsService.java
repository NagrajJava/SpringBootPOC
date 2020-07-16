package com.mongo.jwtSecurity;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mongo.security.UserCredtentials;
import com.mongo.security.UserPrincipal;
import com.mongo.security.UserPrincipalDetailsService;
import com.mongo.security.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

//	@Override
	// public UserDetails loadUserByUsername(String username) throws
	// UsernameNotFoundException {
//		if ("Nagraj".equals(username)) {
//			return new User("Nagraj", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//					new ArrayList<>());
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}

	private UserRepository userRepository;

	public JwtUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		UserCredtentials user = this.userRepository.findByUsername(s);
		UserPrincipal userPrincipal = new UserPrincipal(user);

		return userPrincipal;
	}
}
