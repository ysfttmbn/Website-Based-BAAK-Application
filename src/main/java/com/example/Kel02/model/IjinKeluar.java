package com.example.Kel02.model;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "ijin_keluar")
public class IjinKeluar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_mahasiswa")
    private User user;

    @JoinColumn(name = "keperluan")
    private String keperluan;
    
    @JoinColumn(name = "waktu_berangkat")
    private LocalDateTime waktuBerangkat;

    @JoinColumn(name = "waktu_kembali")
    private LocalDateTime waktuKembali;

    @JoinColumn(name = "status")
    private String status;

    public IjinKeluar() {
        super();
    }

	public IjinKeluar(Long id, User user, String keperluan, LocalDateTime waktuBerangkat, LocalDateTime waktuKembali,
			String status) {
		super();
		this.id = id;
		this.user = user;
		this.keperluan = keperluan;
		this.waktuBerangkat = waktuBerangkat;
		this.waktuKembali = waktuKembali;
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

	public LocalDateTime getWaktuBerangkat() {
		return waktuBerangkat;
	}

	public void setWaktuBerangkat(LocalDateTime waktuBerangkat) {
		this.waktuBerangkat = waktuBerangkat;
	}

	public LocalDateTime getWaktuKembali() {
		return waktuKembali;
	}

	public void setWaktuKembali(LocalDateTime waktuKembali) {
		this.waktuKembali = waktuKembali;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "IjinKeluar [id=" + id + ", user=" + user + ", keperluan=" + keperluan + ", waktuBerangkat="
				+ waktuBerangkat + ", waktuKembali=" + waktuKembali + ", status=" + status + "]";
	}
	
	
}
