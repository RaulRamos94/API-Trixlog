package com.example.apitrixlog.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_condutor")
public class Condutor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCondutor;

    @Column(nullable = false, length = 100)
    private String nome;

    @OneToMany
    private List<Veiculo> veiculos;
    
}
