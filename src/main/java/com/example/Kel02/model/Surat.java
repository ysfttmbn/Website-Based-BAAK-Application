	package com.example.Kel02.model;
	
	
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.JoinColumn;
	import jakarta.persistence.ManyToOne;
	import jakarta.persistence.Table;
	
	@Entity
	@Table(name="surat")
	public class Surat {
		@Id
		@GeneratedValue( strategy = GenerationType.IDENTITY)
		private Long id;
	
		
		@ManyToOne
		@JoinColumn(name = "id_mahasiswa")
		private User user;
		
		
		@JoinColumn(name = "keperluan")
		private String keperluan;
		
		@JoinColumn(name = "deskripsi")
		private String deskripsi;
		
		@JoinColumn(name = "status")
		private String status;
		
		public Surat() {
		}
	
		public Surat(Long id, User user, String keperluan, String deskripsi, String status) {
			this.id = id;
			this.user = user;
			this.keperluan = keperluan;
			this.deskripsi = deskripsi;
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
	
		public String getDeskripsi() {
			return deskripsi;
		}
	
		public void setDeskripsi(String deskripsi) {
			this.deskripsi = deskripsi;
		}
	
		public String getStatus() {
			return status;
		}
	
		public void setStatus(String status) {
			this.status = status;
		}
	
		@Override
		public String toString() {
			return "Surat [id=" + id + ", user=" + user + ", keperluan=" + keperluan + ", deskripsi=" + deskripsi
					+ ", status=" + status + "]";
		}
		
		
	}
