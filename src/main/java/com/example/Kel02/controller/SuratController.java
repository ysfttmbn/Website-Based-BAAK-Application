package com.example.Kel02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Kel02.model.Surat;
import com.example.Kel02.model.User;
import com.example.Kel02.service.LoginService;
import com.example.Kel02.service.SuratService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/surat")
public class SuratController {
	 @Autowired
    private  SuratService suratService;
	 
	 @Autowired
	 private LoginService userService;


    @GetMapping
    public ResponseEntity<List<Surat>> getAllSurat() {
        List<Surat> suratList = suratService.getAllSurat();
        return new ResponseEntity<>(suratList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Surat> getSuratById(@PathVariable Long id) {
        Optional<Surat> surat = suratService.getSuratById(id);
        return surat.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Surat> createSurat(@RequestBody Surat surat) {
    	User user;
    	surat.setStatus("Pending");
    	user = surat.getUser();
    	User getnewUser = userService.getUserById(user.getId());
    	surat.setUser(getnewUser);
        Surat createdSurat = suratService.createSurat(surat);
        return new ResponseEntity<>(createdSurat, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Surat> updateSurat(@PathVariable Long id, @RequestBody Surat updatedSurat) {
        Surat updated = suratService.updateSurat(id, updatedSurat);
        return updated != null ?
                new ResponseEntity<>(updated, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSurat(@PathVariable Long id) {
        suratService.deleteSurat(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Surat>> getSuratByUser(@PathVariable Long userId) {
        List<Surat> suratList = suratService.getSuratByUser(userId);

        if (suratList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(suratList, HttpStatus.OK);
        }
    }
    // New endpoint to update status
    @PutMapping("/{id}/status")
    public ResponseEntity<String> updateStatus(@PathVariable Long id, @RequestBody Map<String, String> statusUpdate) {
        String newStatus = statusUpdate.get("status");

        // Implementation to update status in the database based on id and newStatus
        Surat existingSurat = suratService.findById(id);
        if (existingSurat != null) {
            existingSurat.setStatus(newStatus);
            suratService.save(existingSurat);
            return ResponseEntity.ok("Status updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Surat not found");
        }
    }
}
