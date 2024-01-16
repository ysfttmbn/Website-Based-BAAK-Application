package com.example.Kel02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Kel02.model.BookingRuangan;


@Repository
public interface BookingRuanganRepository extends JpaRepository<BookingRuangan, Long> {
	List<BookingRuangan> findByUserId(Long userId);
}
