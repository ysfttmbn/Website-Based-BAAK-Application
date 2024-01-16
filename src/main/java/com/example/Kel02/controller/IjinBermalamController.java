package com.example.Kel02.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Kel02.model.IjinBermalam;
import com.example.Kel02.model.User;
import com.example.Kel02.service.IjinBermalamService;
import com.example.Kel02.service.LoginService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/ijinbermalam")
public class IjinBermalamController {
	 @Autowired
    private  IjinBermalamService ijinbermalamService;
	 
	 @Autowired
	 private LoginService userService;


    @GetMapping
    public ResponseEntity<List<IjinBermalam>> getAllIjinBermalam() {
        List<IjinBermalam> ijinbermalamList = ijinbermalamService.getAllIjinBermalam();
        return new ResponseEntity<>(ijinbermalamList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IjinBermalam> getIjinBermalamById(@PathVariable Long id) {
        Optional<IjinBermalam> ijinbermalam = ijinbermalamService.getIjinBermalamById(id);
        return ijinbermalam.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<IjinBermalam> createIjinBermalam(@RequestBody IjinBermalam ijinbermalam) {
    	User user;
    	ijinbermalam.setStatus("Pending");
    	user = ijinbermalam.getUser();
    	User getnewUser = userService.getUserById(user.getId());
    	ijinbermalam.setUser(getnewUser);
        IjinBermalam createdIjinBermalam = ijinbermalamService.createIjinBermalam(ijinbermalam);
        return new ResponseEntity<>(createdIjinBermalam, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IjinBermalam> updateIjinBermalam(@PathVariable Long id, @RequestBody IjinBermalam updatedIjinBermalam) {
        IjinBermalam updated = ijinbermalamService.updateIjinBermalam(id, updatedIjinBermalam);
        return updated != null ?
                new ResponseEntity<>(updated, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIjinBermalam(@PathVariable Long id) {
        ijinbermalamService.deleteIjinBermalam(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<IjinBermalam>> getIjinBermalamByUser(@PathVariable Long userId) {
        List<IjinBermalam> ijinbermalamList = ijinbermalamService.getIjinBermalamByUser(userId);

        if (ijinbermalamList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(ijinbermalamList, HttpStatus.OK);
        }
    }
    // New endpoint to update status
    @PutMapping("/{id}/status")
    public ResponseEntity<String> updateStatus(@PathVariable Long id, @RequestBody Map<String, String> statusUpdate) {
        String newStatus = statusUpdate.get("status");

        // Implementation to update status in the database based on id and newStatus
        IjinBermalam existingIjinBermalam = ijinbermalamService.findById(id);
        if (existingIjinBermalam != null) {
            existingIjinBermalam.setStatus(newStatus);
            ijinbermalamService.save(existingIjinBermalam);
            return ResponseEntity.ok("Status updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("IjinBermalam not found");
        }
    }
}
