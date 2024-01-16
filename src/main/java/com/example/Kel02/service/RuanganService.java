package com.example.Kel02.service;

import java.util.List;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.Kel02.model.Ruangan;
import com.example.Kel02.repository.RuanganRepository;

@Service
@Transactional
public class RuanganService {
	@Autowired
	private RuanganRepository produkRepository;

	public List<Ruangan> listAllRuangan() {
		return produkRepository.findAll();
	}

	public void saveRuangan(Ruangan produk) {
		produkRepository.save(produk);
	}

	public Ruangan getRuangan(long id) {
		return produkRepository.findById(id).get();
	}

	public void deleteRuangan(long id) {
		produkRepository.deleteById(id);
	}

	public List<Ruangan> searchRuangan(String namaRuangan) {
		return produkRepository.findByNamaRuanganContaining(namaRuangan);
	}

	public Ruangan getSelectedRuangan() {
		// TODO Auto-generated method stub
		return null;
	}
	public Ruangan getRuanganById(Long id) {
	    return produkRepository.findById(id).orElse(null);
	}

}
