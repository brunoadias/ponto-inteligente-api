package com.dias.pontointeligente.api.services;

import java.util.Optional;

import com.dias.pontointeligente.api.entities.Funcionario;

public interface FuncionarioService {

	Funcionario persistir(Funcionario funcionario);

	Optional<Funcionario> buscarPorCpf(String cpf);

	Optional<Funcionario> buscarPorEmail(String email);

	Optional<Funcionario> buscarPorId(Long id);
}
