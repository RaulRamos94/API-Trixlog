package com.example.apitrixlog.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apitrixlog.model.Condutor;
import com.example.apitrixlog.repository.CondutorRepository;

@RestController
@RequestMapping(value = "/condutor")
public class CondutorController {

    @Autowired
    private CondutorRepository condutorRepository;
    
    //Cadastrar condutor
    @PostMapping
    public ResponseEntity<Condutor> cadastrarCondutor(@RequestBody Condutor condutor){
        return ResponseEntity.ok().body(condutorRepository.save(condutor));
    }

    //Listar todos os condutores
    @GetMapping
    public ResponseEntity<Page<Condutor>> listarCondutores(Pageable paginacao){
        return ResponseEntity.status(HttpStatus.OK).body(condutorRepository.findAll(paginacao));
    }

    //Atualizar condutor
    @PutMapping("/{idCondutor}")
    public ResponseEntity<Condutor> atualizarCondutor(@PathVariable("idCondutor") Long idCondutor, @RequestBody Condutor condutor){
        Optional<Condutor> condutorCadastrado = condutorRepository.findById(idCondutor);

        if(condutorCadastrado.isPresent()){
            condutorCadastrado.get().setNome(condutor.getNome());
            condutorCadastrado.get().setVeiculos(condutor.getVeiculos());
            
            Condutor condutorAtualizado  = condutorRepository.save(condutorCadastrado.get());

            return ResponseEntity.ok().body(condutorAtualizado);
        }
        return null;
    }

    //Deletar condutor
    @DeleteMapping("/{idCondutor}")
    public ResponseEntity<String> deletarCondutor(@PathVariable("idCondutor") Long idCondutor){
        Optional<Condutor> condutor = condutorRepository.findById(idCondutor);

        if(condutor.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        condutorRepository.deleteById(idCondutor);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Condutor excluído com sucesso!");
    }
}
