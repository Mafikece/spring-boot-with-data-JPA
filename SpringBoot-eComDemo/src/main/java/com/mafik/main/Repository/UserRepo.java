package com.mafik.main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mafik.main.Model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	@Query("SELECT e FROM User e WHERE e.userName = :userName and e.password= :password ")
	User findByUser(String userName, String password);
	
}
