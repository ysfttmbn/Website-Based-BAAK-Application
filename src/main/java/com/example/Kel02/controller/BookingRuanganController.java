package com.example.Kel02.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Kel02.model.BookingRuangan;
import com.example.Kel02.model.Ruangan;
import com.example.Kel02.model.User;
import com.example.Kel02.service.BookingRuanganService;
import com.example.Kel02.service.LoginService;
import com.example.Kel02.service.RuanganService;


@RestController
@RequestMapping("/bookingruangan")
public class BookingRuanganController {
	 @Autowired
    private  BookingRuanganService bookingruanganService;
	 
	 @Autowired
	 private LoginService userService;

	 @Autowired
	 private RuanganService ruanganService;


    @GetMapping
    public ResponseEntity<List<BookingRuangan>> getAllBookingRuangan() {
        List<BookingRuangan> bookingruanganList = bookingruanganService.getAllBookingRuangan();
        return new ResponseEntity<>(bookingruanganList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingRuangan> getBookingRuanganById(@PathVariable Long id) {
        Optional<BookingRuangan> bookingruangan = bookingruanganService.getBookingRuanganById(id);
        return bookingruangan.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<BookingRuangan> createBookingRuangan(@RequestBody BookingRuangan bookingruangan) {
    	User user;
    	Ruangan ruangan;
    	user = bookingruangan.getUser();
    	ruangan = bookingruangan.getRuangan();
    	ruangan.setStatus("Pending");
    	User getnewUser = userService.getUserById(user.getId());
    	Ruangan getnewRuangan = ruanganService.getRuanganById(ruangan.getId());
    	bookingruangan.setUser(getnewUser);
    	bookingruangan.setRuangan(getnewRuangan);
        BookingRuangan createdBookingRuangan = bookingruanganService.createBookingRuangan(bookingruangan);
        return new ResponseEntity<>(createdBookingRuangan, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingRuangan> updateBookingRuangan(@PathVariable Long id, @RequestBody BookingRuangan updatedBookingRuangan) {
        BookingRuangan updated = bookingruanganService.updateBookingRuangan(id, updatedBookingRuangan);
        return updated != null ?
                new ResponseEntity<>(updated, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookingRuangan(@PathVariable Long id) {
        bookingruanganService.deleteBookingRuangan(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BookingRuangan>> getBookingRuanganByUser(@PathVariable Long userId) {
        List<BookingRuangan> bookingruanganList = bookingruanganService.getBookingRuanganByUser(userId);

        if (bookingruanganList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(bookingruanganList, HttpStatus.OK);
        }
    }
    // New endpoint to update status

}
