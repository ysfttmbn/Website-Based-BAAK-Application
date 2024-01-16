package com.example.Kel02.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Kel02.model.Surat;
import com.example.Kel02.model.User;
import com.example.Kel02.repository.LoginRepository;
import com.example.Kel02.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class LoginService {

	@Autowired
	private LoginRepository repo;
	@Autowired
	private UserRepository userRepository;
	
	public User login(String username, String password) {
		User user = repo.findByUsernameAndPassword(username, password);
		return user;
	}
	public User getUserById(Long id) {
	    return repo.findById(id).orElse(null);
	}
	public String loginUser(User user, HttpSession session) {
        User dbUser = userRepository.findByUsername(user.getUsername());
        if ("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())) {
            User adminUser = new User();
            adminUser.setUsername("admin");
            session.setAttribute("user", adminUser);
            return "admin-index";
        } else if (dbUser != null && user.getPassword().equals(dbUser.getPassword())) {
            session.setAttribute("user", dbUser);
            return "mahasiswa-index";
        }
        return "Username atau password salah";
    }
}