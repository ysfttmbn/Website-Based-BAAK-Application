package com.example.Kel02.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToOne
	@JoinColumn(name = "id_mahasiswa")
	private User user;
	
	
	@ManyToOne
	@JoinColumn(name = "id_produk")
	private Produk produk;
	
	
	@JoinColumn(name = "jenis_pembayaran")
	private String jenisPembayaran;
	
	
	@JoinColumn(name = "akun_pengirim")
	private String akunPengirim;
	
	@JoinColumn(name = "total")
	private String total;
	
	public Order() {
		super();
	}

	public Order(Long id, User user, Produk produk, String jenisPembayaran, String akunPengirim, String total,
			String status) {
		super();
		this.id = id;
		this.user = user;
		this.produk = produk;
		this.jenisPembayaran = jenisPembayaran;
		this.akunPengirim = akunPengirim;
		this.total = total;
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

	public Produk getProduk() {
		return produk;
	}

	public void setProduk(Produk produk) {
		this.produk = produk;
	}

	public String getJenisPembayaran() {
		return jenisPembayaran;
	}

	public void setJenisPembayaran(String jenisPembayaran) {
		this.jenisPembayaran = jenisPembayaran;
	}

	public String getAkunPengirim() {
		return akunPengirim;
	}

	public void setAkunPengirim(String akunPengirim) {
		this.akunPengirim = akunPengirim;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}


	@Override
	public String toString() {
		return "Order [id=" + id + ", user=" + user + ", produk=" + produk + ", jenisPembayaran=" + jenisPembayaran
				+ ", akunPengirim=" + akunPengirim + ", total=" + total + "]";
	}



	
}