package com.example.Kel02.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Kel02.model.IjinKeluar;
import com.example.Kel02.model.User;
import com.example.Kel02.service.IjinKeluarService;
import com.example.Kel02.service.LoginService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/ijinkeluar")
public class IjinKeluarController {
	 @Autowired
    private  IjinKeluarService ijinkeluarService;
	 
	 @Autowired
	 private LoginService userService;


    @GetMapping
    public ResponseEntity<List<IjinKeluar>> getAllIjinKeluar() {
        List<IjinKeluar> ijinkeluarList = ijinkeluarService.getAllIjinKeluar();
        return new ResponseEntity<>(ijinkeluarList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IjinKeluar> getIjinKeluarById(@PathVariable Long id) {
        Optional<IjinKeluar> ijinkeluar = ijinkeluarService.getIjinKeluarById(id);
        return ijinkeluar.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<IjinKeluar> createIjinKeluar(@RequestBody IjinKeluar ijinkeluar) {
    	User user;
    	ijinkeluar.setStatus("Pending");
    	user = ijinkeluar.getUser();
    	User getnewUser = userService.getUserById(user.getId());
    	ijinkeluar.setUser(getnewUser);
        IjinKeluar createdIjinKeluar = ijinkeluarService.createIjinKeluar(ijinkeluar);
        return new ResponseEntity<>(createdIjinKeluar, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IjinKeluar> updateIjinKeluar(@PathVariable Long id, @RequestBody IjinKeluar updatedIjinKeluar) {
        IjinKeluar updated = ijinkeluarService.updateIjinKeluar(id, updatedIjinKeluar);
        return updated != null ?
                new ResponseEntity<>(updated, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIjinKeluar(@PathVariable Long id) {
        ijinkeluarService.deleteIjinKeluar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<IjinKeluar>> getIjinKeluarByUser(@PathVariable Long userId) {
        List<IjinKeluar> ijinkeluarList = ijinkeluarService.getIjinKeluarByUser(userId);

        if (ijinkeluarList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(ijinkeluarList, HttpStatus.OK);
        }
    }
    // New endpoint to update status
    @PutMapping("/{id}/status")
    public ResponseEntity<String> updateStatus(@PathVariable Long id, @RequestBody Map<String, String> statusUpdate) {
        String newStatus = statusUpdate.get("status");

        // Implementation to update status in the database based on id and newStatus
        IjinKeluar existingIjinKeluar = ijinkeluarService.findById(id);
        if (existingIjinKeluar != null) {
            existingIjinKeluar.setStatus(newStatus);
            ijinkeluarService.save(existingIjinKeluar);
            return ResponseEntity.ok("Status updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("IjinKeluar not found");
        }
    }
}
