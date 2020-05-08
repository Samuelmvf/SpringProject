package com.treinamento.SpringProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.treinamento.SpringProject.entity.ClienteEntity;
import com.treinamento.SpringProject.repository.ClienteRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	public ResponseEntity<?> salvarCliente(ClienteEntity cliente){
		
		if(cliente != null) {
			Optional<ClienteEntity> existente = repository.findByEmail(cliente.getEmail());
			if(existente.isPresent()) {
				return ResponseEntity.badRequest().body("Email já cadastrado.");
			} else {
				ClienteEntity novoCliente = repository.save(cliente);
				return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
			}
		}
		return ResponseEntity.badRequest().build();
	}
	
	public ResponseEntity<List<ClienteEntity>> findAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	public ResponseEntity<ClienteEntity> findById(Long id) {
		if (id != null) {
			Optional<ClienteEntity> cliente = repository.findById(id);
			if (cliente.isPresent()) {
				return ResponseEntity.ok(cliente.get());
			}
		}
		return ResponseEntity.badRequest().build();
	}
	
	public ResponseEntity<ClienteEntity> atualizar(ClienteEntity cliente) {
		if (cliente != null && cliente.getId() != null) {
			ClienteEntity clienteAtualizado = repository.save(cliente);
			return ResponseEntity.ok(clienteAtualizado);
		}
		return ResponseEntity.badRequest().build();
	}
	public ResponseEntity<String> excluir(Long id) {
		if (id != null && repository.existsById(id)) {
			repository.deleteById(id);
			return ResponseEntity.ok("Excluido com sucesso");
		}
		return ResponseEntity.badRequest().body("Falha ao excluir");
	}
}
