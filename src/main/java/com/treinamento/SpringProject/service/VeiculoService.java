package com.treinamento.SpringProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.treinamento.SpringProject.entity.VeiculoEntity;
import com.treinamento.SpringProject.repository.ClienteRepository;
import com.treinamento.SpringProject.repository.VeiculoRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class VeiculoService {

	@Autowired
	private VeiculoRepository repository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public ResponseEntity<?> salvarVeiculo(VeiculoEntity veiculo){
		
		if(veiculo != null) {
			if(clienteRepository.findById(veiculo.getCliente().getId()).isPresent())
			{
				VeiculoEntity novoVeiculo = repository.save(veiculo);
				return new ResponseEntity<>(novoVeiculo, HttpStatus.CREATED);
			}
			else {
				return ResponseEntity.badRequest().body("O Cliente referenciado não existe.");
			}
		}
		return ResponseEntity.badRequest().build();
	}
	
	public ResponseEntity<List<VeiculoEntity>> findAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	public ResponseEntity<VeiculoEntity> findById(Long id) {
		if (id != null) {
			Optional<VeiculoEntity> veiculo = repository.findById(id);
			if (veiculo.isPresent()) {
				return ResponseEntity.ok(veiculo.get());
			}
		}
		return ResponseEntity.badRequest().build();
	}
	
	public ResponseEntity<VeiculoEntity> atualizar(VeiculoEntity veiculo) {
		if (veiculo != null && veiculo.getId() != null) {
			VeiculoEntity veiculoAtualizado = repository.save(veiculo);
			return ResponseEntity.ok(veiculoAtualizado);
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
