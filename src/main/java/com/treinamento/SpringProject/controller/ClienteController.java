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

import com.treinamento.SpringProject.entity.ClienteEntity;
import com.treinamento.SpringProject.service.ClienteService;

@RestController
@RequestMapping(value = "/api/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping(value = "/criar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> criarCliente(@Valid @RequestBody ClienteEntity cliente) {
		return clienteService.salvarCliente(cliente);
	}
	
	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ClienteEntity>> findAll() {
		return clienteService.findAll();
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClienteEntity> findAllPath(@PathVariable Long id) {
		return clienteService.findById(id);
	}
	
	@PutMapping(value = "/atualizar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClienteEntity> atualizar(@Valid @RequestBody ClienteEntity cliente) {
		return clienteService.atualizar(cliente);
	}
	
	@DeleteMapping(value = "/deletar/{id}")
	public ResponseEntity<String> excluir(@PathVariable Long id) {
		return clienteService.excluir(id);
	}
}
