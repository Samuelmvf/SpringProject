package com.treinamento.SpringProject.entity;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "tbl_cliente")
@SuppressWarnings("serial")
public class ClienteEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "cliente_sequence")
	@SequenceGenerator(name = "cliente_sequence", sequenceName = "cliente_id_sequence", allocationSize = 1)
	@Column(name = "id_cliente", nullable = false)
	private Long id;
	
	@NotNull(message = "O campo nome não pode ser nulo.")
	@Size(min = 2, message = "O nome digitado não é um nome válido.")
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@NotNull(message = "O campo email não pode ser nulo.")
	@Email(message = "O email digitado não é um email válido.")
	@Column(name = "email", nullable = false)
	private String email;
	
	@JsonManagedReference
	@Builder.Default
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<VeiculoEntity> veiculos = new ArrayList<>();
	
}
