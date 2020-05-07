package com.treinamento.SpringProject.resource;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinamento.SpringProject.entity.VeiculoEntity;
import com.treinamento.SpringProject.service.VeiculoService;

@RestController
@RequestMapping(value = "/api/veiculo")
public class VeiculoResource {
	
	private VeiculoService veiculoService;
	
	@PostMapping(value = "/criar")
	public ResponseEntity<VeiculoEntity> criarVeiculo(@RequestBody VeiculoEntity veiculo) {
		return veiculoService.salvarVeiculo(veiculo);
	}
	
	@GetMapping(value = "/listar")
	public ResponseEntity<List<VeiculoEntity>> findAll() {
		return veiculoService.findAll();
	}
	
	@GetMapping(value = "/listar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VeiculoEntity> findAllPath(@PathVariable Long id) {
		return veiculoService.findById(id);
	}
	
	@PutMapping(value = "/atualizar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VeiculoEntity> atualizar(@RequestBody VeiculoEntity veiculo) {
		return veiculoService.atualizar(veiculo);
	}
	
	@DeleteMapping(value = "/deletar/{id}")
	public ResponseEntity<String> excluir(@PathVariable Long id) {
		return veiculoService.excluir(id);
	}
}
