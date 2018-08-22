package com.dias.pontointeligente.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.dias.pontointeligente.api.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

	// Utilização da anotação @Transaction para informar ao spring que não há
	// necessidade da criação de uma transação para executar o método findByCnpj
	// por tratar-se apenas de um select
	@Transactional(readOnly = true)
	Empresa findByCnpj(String cnpj);
}
