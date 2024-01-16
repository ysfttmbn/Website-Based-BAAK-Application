package com.example.Kel02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Kel02.model.User;

@Repository
public interface LoginRepository extends JpaRepository<User, Long> {
	User findByUsernameAndPassword(String username, String password);
}
