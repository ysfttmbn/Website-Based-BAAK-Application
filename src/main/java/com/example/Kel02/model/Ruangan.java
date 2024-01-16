package com.example.Kel02.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ruangan")
public class Ruangan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	@Column(name = "nama_ruangan")
	private String namaRuangan;
	
	@Column(name = "status")
    private String status;

    public Ruangan() {
        super();
    }

    public Ruangan(String namaRuangan, String status) {
        super();
        this.namaRuangan = namaRuangan;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamaRuangan() {
        return namaRuangan;
    }

    public void setNamaRuangan(String namaRuangan) {
        this.namaRuangan = namaRuangan;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Ruangan [id=" + id + ", namaRuangan=" + namaRuangan + ", status=" + status + "]";
    }

	 public static Ruangan fromString(String ruanganId) {
	        Ruangan ruangan = new Ruangan();
	        ruangan.setId(Long.parseLong(ruanganId));
	        return ruangan;
	    }
}
