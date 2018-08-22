package com.dias.pontointeligente.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.dias.pontointeligente.api.entities.Funcionario;

// Utilização da anotação @Transaction para informar ao spring que não há
// necessidade da criação de uma transação para executar qualquer um dos os métodos
// da interface por tratarem-se todos de selects
@Transactional(readOnly = true)
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	Funcionario findByCpf(String cpf);

	Funcionario findByEmail(String email);

	Funcionario findByCpfOrEmail(String cpf, String email);

}
