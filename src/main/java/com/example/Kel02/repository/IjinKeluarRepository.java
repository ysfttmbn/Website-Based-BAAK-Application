package com.example.Kel02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Kel02.model.IjinKeluar;


public interface IjinKeluarRepository extends JpaRepository<IjinKeluar, Long> {
	List<IjinKeluar> findByUserId(Long userId);
}
