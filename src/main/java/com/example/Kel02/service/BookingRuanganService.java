package com.example.Kel02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Kel02.model.BookingRuangan;
import com.example.Kel02.repository.BookingRuanganRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class BookingRuanganService {
    private final BookingRuanganRepository bookingruanganRepository;

    @Autowired
    public BookingRuanganService(BookingRuanganRepository bookingruanganRepository) {
        this.bookingruanganRepository = bookingruanganRepository;
    }

    public List<BookingRuangan> getAllBookingRuangan() {
        return bookingruanganRepository.findAll();
    }

    public Optional<BookingRuangan> getBookingRuanganById(Long id) {
        return bookingruanganRepository.findById(id);
    }

    public BookingRuangan createBookingRuangan(BookingRuangan bookingruangan) {
        return bookingruanganRepository.save(bookingruangan);
    }

    public BookingRuangan updateBookingRuangan(Long id, BookingRuangan updatedBookingRuangan) {
        Optional<BookingRuangan> existingBookingRuangan = bookingruanganRepository.findById(id);
        if (existingBookingRuangan.isPresent()) {
            BookingRuangan bookingruangan = existingBookingRuangan.get();
            bookingruangan.setUser(updatedBookingRuangan.getUser());
            bookingruangan.setRuangan(updatedBookingRuangan.getRuangan());
            bookingruangan.setWaktu_booking(updatedBookingRuangan.getWaktu_booking());
            bookingruangan.setEnd_booking(updatedBookingRuangan.getEnd_booking());
            bookingruangan.setStatus(updatedBookingRuangan.getStatus());
            return bookingruanganRepository.save(bookingruangan);
        } else {
            // Handle the case when the BookingRuangan with the given id is not found
            return null;
        }
    }
	public BookingRuangan getBookingRuangan(long id) {
		return bookingruanganRepository.findById(id).get();
	}

    public void deleteBookingRuangan(Long id) {
        bookingruanganRepository.deleteById(id);
    }
    
    public List<BookingRuangan> getBookingRuanganByUser(Long userId) {
        return bookingruanganRepository.findByUserId(userId);
    }

	public BookingRuangan findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(BookingRuangan existingBookingRuangan) {
		// TODO Auto-generated method stub
		
	}
    
}
