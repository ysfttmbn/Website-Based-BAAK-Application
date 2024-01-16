package com.example.Kel02.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String noktp;
    private String nim;
    private String namalengkap;
    private String nohp;
    private String roles;
    
	public User()
	{
			
	}
	
	public User(Long id, String username, String password,String noktp,String nim,String namalengkap,String nohp) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.noktp = noktp;
		this.nim = nim;
		this.namalengkap = namalengkap;
		this.nohp = nohp;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getKtp() {
		return noktp;
	}
	public void setKtp(String noktp) {
		this.noktp = noktp;
	}
	public String getNim() {
		return nim;
	}
	public void setNim(String nim) {
		this.nim = nim;
	}
	public String getNama() {
		return namalengkap;
	}
	public void setNama(String namalengkap) {
		this.namalengkap = namalengkap;
	}
	public String getHp() {
		return nohp;
	}
	public void setHp(String nohp) {
		this.nohp = nohp;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", noktp=" + noktp + ", nim="
				+ nim + ", namalengkap=" + namalengkap + ", nohp=" + nohp + ", roles=" + roles + "]";
	}
	 public static User fromString(String userId) {
	        User user = new User();
	        user.setId(Long.parseLong(userId));
	        return user;
	    }
}
