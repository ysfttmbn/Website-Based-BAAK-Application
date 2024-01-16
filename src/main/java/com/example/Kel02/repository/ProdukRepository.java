package com.example.Kel02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Kel02.model.Produk;

@Repository
public interface ProdukRepository extends JpaRepository<Produk, Long> {
    List<Produk> findByNamaProdukContaining(String namaProduk);
}

