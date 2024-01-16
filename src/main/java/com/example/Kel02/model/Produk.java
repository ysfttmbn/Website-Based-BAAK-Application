package com.example.Kel02.model;

import jakarta.persistence.*;

@Entity
@Table(name = "produk")
public class Produk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nama_produk")
    private String namaProduk;
    
    private String harga; // Change the data type to int
    private String ukuran;

    public Produk() {
        super();
    }

    public Produk(String namaProduk, String harga, String ukuran) {
        super();
        this.namaProduk = namaProduk;
        this.harga = harga;
        this.ukuran = ukuran;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamaProduk() { // Corrected method name to follow Java conventions
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }


    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    @Override
    public String toString() {
        return "Produk [id=" + id + ", namaProduk=" + namaProduk + ", harga=" +
                harga + ",  ukuran=" + ukuran + "]";
    }
	 public static Produk fromString(String produkId) {
	        Produk produk = new Produk();
	        produk.setId(Long.parseLong(produkId));
	        return produk;
	    }
}
