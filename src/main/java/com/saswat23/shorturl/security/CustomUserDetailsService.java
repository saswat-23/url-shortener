package com.saswat23.shorturl.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.saswat23.shorturl.model.UserModel;
import com.saswat23.shorturl.repo.UserDetailsRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserDetailsRepo userDetailsRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		List<UserModel> userList = userDetailsRepo.findByUsernameOrEmailId(username,username);
		
		if(userList.size() == 0 ) {
			throw new UsernameNotFoundException("No user with username/email ["+username+"] is registered!");
		}
		
		return User.builder()
			.username(userList.get(0).getUsername())
			.password(userList.get(0).getPassword())
			.build();
	}

}
