package com.saswat23.shorturl.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saswat23.shorturl.model.UserModel;

@Repository
public interface UserDetailsRepo extends JpaRepository<UserModel, Integer>{

	List<UserModel> findByUsername(String username);
	
	List<UserModel> findByUsernameOrEmailId(String username, String emailId);

}
