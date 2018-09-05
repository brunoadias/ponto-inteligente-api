package com.dias.pontointeligente.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dias.pontointeligente.api.entities.Lancamento;
import com.dias.pontointeligente.api.repositories.LancamentoRepository;
import com.dias.pontointeligente.api.services.LancamentoService;

@Service
public class LancamentoServiceImpl implements LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;

	private static final Logger log = LoggerFactory.getLogger(LancamentoServiceImpl.class);

	@Override
	public Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest) {
		log.info("Buscando lançamentos para o funcionário com ID {}", funcionarioId);
		return this.lancamentoRepository.findByFuncionarioId(funcionarioId, pageRequest);
	}

	@Override
	// Anotação para determinar que o método utilizará a
	// configuração do ehcache criada
	@Cacheable("lancamentoPorId")
	public Optional<Lancamento> buscarPorId(Long id) {
		log.info("Buscando lançamento pelo ID {}", id);
		return this.lancamentoRepository.findById(id);
	}

	@Override
	// Anotação para atualizar o cache da aplicação
	// caso o lançamento em cache sofra alteração
	@CachePut("lancamentoPorId")

	public Lancamento persistir(Lancamento lancamento) {
		log.info("Persistindo lançamento: {}", lancamento);
		return this.lancamentoRepository.save(lancamento);
	}

	@Override
	public void remover(Long id) {
		log.info("Removendo lançamento com ID {}", id);
		this.lancamentoRepository.deleteById(id);
	}
}
