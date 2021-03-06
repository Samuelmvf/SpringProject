package com.treinamento.SpringProject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
public class VeiculoController {
	
	@Autowired
	private VeiculoService veiculoService;
	
	@PostMapping(value = "/criar")
	public ResponseEntity<?> criarVeiculo(@Valid @RequestBody VeiculoEntity veiculo) {
		return veiculoService.salvarVeiculo(veiculo);
	}
	
	@GetMapping(value = "/listar")
	public ResponseEntity<List<VeiculoEntity>> findAll() {
		return veiculoService.findAll();
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VeiculoEntity> findAllPath(@PathVariable Long id) {
		return veiculoService.findById(id);
	}
	
	@PutMapping(value = "/atualizar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VeiculoEntity> atualizar(@Valid @RequestBody VeiculoEntity veiculo) {
		return veiculoService.atualizar(veiculo);
	}
	
	@DeleteMapping(value = "/deletar/{id}")
	public ResponseEntity<String> excluir(@PathVariable Long id) {
		return veiculoService.excluir(id);
	}
}
