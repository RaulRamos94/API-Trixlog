package com.example.apitrixlog.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apitrixlog.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    Optional<Veiculo> findByRenavan(int renavan);
    Optional<Veiculo> findByDataAquisicao(LocalDate dataAquisicao);
    Optional<Veiculo> findByPlaca(String placa);
    
}
