package com.example.Kel02.model;


import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="booking_ruangan")
public class BookingRuangan {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_mahasiswa")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "id_ruangan")
	private Ruangan ruangan;
	
	@JoinColumn(name = "waktu_booking")
	private LocalDateTime waktu_booking;
	
	@JoinColumn(name = "end_booking")
	private LocalDateTime end_booking;
	
	@JoinColumn(name = "status")
	private String status;
	
	public BookingRuangan() {
		super();
	}

	public BookingRuangan(Long id, User user, Ruangan ruangan, LocalDateTime waktu_booking, LocalDateTime end_booking,
			String status) {
		super();
		this.id = id;
		this.user = user;
		this.ruangan = ruangan;
		this.waktu_booking = waktu_booking;
		this.end_booking = end_booking;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Ruangan getRuangan() {
		return ruangan;
	}

	public void setRuangan(Ruangan ruangan) {
		this.ruangan = ruangan;
	}

	public LocalDateTime getWaktu_booking() {
		return waktu_booking;
	}

	public void setWaktu_booking(LocalDateTime waktu_booking) {
		this.waktu_booking = waktu_booking;
	}

	public LocalDateTime getEnd_booking() {
		return end_booking;
	}

	public void setEnd_booking(LocalDateTime end_booking) {
		this.end_booking = end_booking;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	
}
