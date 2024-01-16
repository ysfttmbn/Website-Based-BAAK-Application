package com.example.Kel02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Kel02.model.User;
import com.example.Kel02.repository.RegistrasiRepository;

@Service
public class RegistrasiService {

	@Autowired
	private RegistrasiRepository repo;

	public User register(String username, String password, String roles, String noktp,String nim, String namalengkap,
			String nohp) {
		User user = repo.findByUsernameAndPassword(username, password);
		if (user == null) {
			user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setRoles("mahasiswa");
			user.setKtp(noktp);
			user.setNim(nim);
			user.setNama(namalengkap);
			user.setHp(nohp);
			repo.save(user);
		}
		return user;
	}

}
