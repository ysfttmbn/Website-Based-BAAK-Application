package com.example.Kel02.model;




import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name="ijin_bermalam")
public class IjinBermalam {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_mahasiswa")
	private User user;
	
	
	@JoinColumn(name = "keperluan")
	private String keperluan;
	
	@JoinColumn(name = "waktu_berangkat")
	private LocalDateTime waktu_berangkat;
	
	@JoinColumn(name = "waktu_kembali")
	private LocalDateTime waktu_kembali;
	
	@JoinColumn(name = "status")
	private String status;
	
	public IjinBermalam() {
		super();
	}

	public IjinBermalam(Long id, User user, String keperluan, LocalDateTime waktu_berangkat,
			LocalDateTime waktu_kembali, String status) {
		super();
		this.id = id;
		this.user = user;
		this.keperluan = keperluan;
		this.waktu_berangkat = waktu_berangkat;
		this.waktu_kembali = waktu_kembali;
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

	public String getKeperluan() {
		return keperluan;
	}

	public void setKeperluan(String keperluan) {
		this.keperluan = keperluan;
	}

	public LocalDateTime getWaktu_berangkat() {
		return waktu_berangkat;
	}

	public void setWaktu_berangkat(LocalDateTime waktu_berangkat) {
		this.waktu_berangkat = waktu_berangkat;
	}

	public LocalDateTime getWaktu_kembali() {
		return waktu_kembali;
	}

	public void setWaktu_kembali(LocalDateTime waktu_kembali) {
		this.waktu_kembali = waktu_kembali;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "IjinBermalam [id=" + id + ", user=" + user + ", keperluan=" + keperluan + ", waktu_berangkat="
				+ waktu_berangkat + ", waktu_kembali=" + waktu_kembali + ", status=" + status + "]";
	}

	

	
	
	
}
