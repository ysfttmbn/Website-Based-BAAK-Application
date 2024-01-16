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

import com.example.Kel02.model.Ruangan;
import com.example.Kel02.service.RuanganService;

@RestController
@RequestMapping("/ruangan")
public class RuanganController {
	@Autowired
	RuanganService ruanganService;
	
	@GetMapping("")
	
	public List<Ruangan> list() {
		return ruanganService.listAllRuangan();
	}

	@PostMapping("/")
	public void add(@RequestBody Ruangan ruangan) {
		ruanganService.saveRuangan(ruangan);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Ruangan ruangan, @PathVariable Integer id) {
		try {
			ruangan.setId(id);
			ruanganService.saveRuangan(ruangan);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		ruanganService.deleteRuangan(id);
	}
	
	@GetMapping("/search/{namaRuangan}")
	public List<Ruangan> search(@PathVariable String namaRuangan) {
		return ruanganService.searchRuangan(namaRuangan);
	}
	
    @GetMapping("/index2")
    public String viewHomePage() {
        return "index2";
    }
}
