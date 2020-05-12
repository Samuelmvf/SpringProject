package com.treinamento.SpringProject.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name = "tbl_veiculo")
@SuppressWarnings("serial")
public class VeiculoEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "veiculo_sequence")
	@SequenceGenerator(name = "veiculo_sequence", sequenceName = "veiculo_id_sequence", allocationSize = 1)
	@Column(name = "id_veiculo", nullable = false)
	private Long id;
	
	@NotBlank(message = "O campo montadora não pode estar vazio.")
	@NotNull(message = "O campo montadora não pode ser nulo.")
	@Column(name = "montadora", nullable = false)
	private String montadora;
	
	@NotBlank(message = "O campo modelo não pode estar vazio.")
	@NotNull(message = "O campo modelo não pode ser nulo.")
	@Column(name = "modelo", nullable = false)
	private String modelo;
	
	@NotNull(message = "O campo versão não pode ser nulo.")
	@Column(name = "versao", nullable = false)
	private Long versao;
	
	@NotNull(message = "É necessário o id do cliente ao qual o carro está vinculado.")
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_cliente")
	private ClienteEntity cliente;
}
