package com.example.apitrixlog.controller;

import java.time.LocalDate;
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

import com.example.apitrixlog.model.Veiculo;
import com.example.apitrixlog.repository.VeiculoRepository;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;
    
    //Cadastrar veiculo
    @PostMapping
    public ResponseEntity<Veiculo> cadastrarVeiculo(@RequestBody Veiculo veiculo){
        return ResponseEntity.ok().body(veiculoRepository.save(veiculo));
    }

    //Listar todos os veiculos
    @GetMapping
    public ResponseEntity<Page<Veiculo>> listarVeiculos(Pageable paginacao){
        return ResponseEntity.status(HttpStatus.OK).body(veiculoRepository.findAll(paginacao));
    }

    //Atualizar veiculo
    @PutMapping("/{idVeiculo}")
    public ResponseEntity<Veiculo> atualizarVeiculo(@PathVariable("idVeiculo") Long idVeiculo, @RequestBody Veiculo veiculo){
        Optional<Veiculo> veiculoCadastrado = veiculoRepository.findById(idVeiculo);

        if(veiculoCadastrado.isPresent()){
            veiculoCadastrado.get().setNome(veiculo.getNome());
            veiculoCadastrado.get().setMarca(veiculo.getMarca());
            veiculoCadastrado.get().setPlaca(veiculo.getPlaca());
            veiculoCadastrado.get().setUfPlaca(veiculo.getUfPlaca());
            veiculoCadastrado.get().setRenavan(veiculo.getRenavan());
            veiculoCadastrado.get().setDataAquisicao(veiculo.getDataAquisicao());
            
            Veiculo veiculoAtualizado  = veiculoRepository.save(veiculoCadastrado.get());

            return ResponseEntity.ok().body(veiculoAtualizado);
        }
        return null;
    }

    //Deletar veiculo
    @DeleteMapping("/{idVeiculo}")
    public ResponseEntity<String> deletarVeiculo(@PathVariable("idVeiculo") Long idVeiculo){
        Optional<Veiculo> veiculo = veiculoRepository.findById(idVeiculo);

        if(veiculo.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        veiculoRepository.deleteById(idVeiculo);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Veiculo excluído com sucesso!");
    }

    //Buscar veiculo por renavan
    @GetMapping("/renavan/{renavan}")
    public Optional<Veiculo> buscarUsuarioPeloEmail(@PathVariable("renavan") int renavan) {
        return veiculoRepository.findByRenavan(renavan);
    }

    //Buscar veiculo por data de aquisição
    @GetMapping("/dataAquisicao/{dataAquisicao}")
    public Optional<Veiculo> buscarPordataAquisicao(@PathVariable("dataAquisicao") LocalDate dataAquisicao) {
        return veiculoRepository.findByDataAquisicao(dataAquisicao);
    }

    //Buscar veiculo por placa
    @GetMapping("/placa/{placa}")
    public Optional<Veiculo> buscarPorPlaca(@PathVariable("placa") String placa) {
        return veiculoRepository.findByPlaca(placa);
    }
    
}
