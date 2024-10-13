package com.saswat23.shorturl.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saswat23.shorturl.model.UserModel;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Integer> {

}
