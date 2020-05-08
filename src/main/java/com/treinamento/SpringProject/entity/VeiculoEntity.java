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
	
	@Column(name = "montadora", nullable = false)
	private String montadora;
	
	@Column(name = "modelo", nullable = false)
	private String modelo;
	
	@Column(name = "versao", nullable = false)
	private Long versao;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_cliente")
	private ClienteEntity cliente;
}
