package com.electro.repositeries;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.electro.entities.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	// Optional<User> findByEmail(String email);
	
	 @Query("SELECT u FROM User u WHERE u.email = :email")
	    Optional<User> findByEmailCustomQuery(@Param("email") String email);

}
