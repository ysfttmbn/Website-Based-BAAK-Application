package com.example.Kel02.controller;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.Kel02.model.Produk;
import com.example.Kel02.service.ProdukService;

@RestController
@RequestMapping("/produk")
public class ProdukController {
	@Autowired
	ProdukService produkService;
	
	@GetMapping("")
	
	public List<Produk> list() {
		return produkService.listAllProduk();
	}

	@PostMapping("/")
	public void add(@RequestBody Produk produk) {
		produkService.saveProduk(produk);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Produk produk, @PathVariable Integer id) {
		try {
			produk.setId(id);
			produkService.saveProduk(produk);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		produkService.deleteProduk(id);
	}
	
	@GetMapping("/search/{namaProduk}")
	public List<Produk> search(@PathVariable String namaProduk) {
		return produkService.searchProduk(namaProduk);
	}
	
    @GetMapping("/index2")
    public String viewHomePage() {
        return "index2";
    }
}
