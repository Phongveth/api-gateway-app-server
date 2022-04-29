package com.la.apigatewayappserver.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.la.apigatewayappserver.models.User;
import com.la.apigatewayappserver.models.SecurityUser;
import com.la.apigatewayappserver.repository.UserRepository;

@Service
public class LoginUserDetails implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		System.out.println(username);
		System.out.println("---Start Loading User ---");
		List<User> users = this.userRepository.findByUsername(username);
		if (users.size() == 0) {
			throw new UsernameNotFoundException("User details not found for the user : " + username);
		}
		System.out.println(users.get(0));
		return new SecurityUser(users.get(0));
	}



}
