package com.example.apitrixlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apitrixlog.model.Condutor;

public interface CondutorRepository extends JpaRepository<Condutor, Long> {
    
}
