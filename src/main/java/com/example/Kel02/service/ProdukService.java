package com.example.Kel02.service;

import java.util.List;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.Kel02.model.Produk;
import com.example.Kel02.model.User;
import com.example.Kel02.repository.ProdukRepository;

@Service
@Transactional
public class ProdukService {
	@Autowired
	private ProdukRepository produkRepository;

	public List<Produk> listAllProduk() {
		return produkRepository.findAll();
	}

	public void saveProduk(Produk produk) {
		produkRepository.save(produk);
	}

	public Produk getProduk(long id) {
		return produkRepository.findById(id).get();
	}

	public void deleteProduk(long id) {
		produkRepository.deleteById(id);
	}

	public List<Produk> searchProduk(String namaProduk) {
		return produkRepository.findByNamaProdukContaining(namaProduk);
	}

	public Produk getSelectedProduk() {
		// TODO Auto-generated method stub
		return null;
	}
	public Produk getProdukById(Long id) {
	    return produkRepository.findById(id).orElse(null);
	}

}
