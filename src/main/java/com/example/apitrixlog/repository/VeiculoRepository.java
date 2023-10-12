package com.example.apitrixlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apitrixlog.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    
}
