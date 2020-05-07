package com.treinamento.SpringProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treinamento.SpringProject.entity.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long>{

}
