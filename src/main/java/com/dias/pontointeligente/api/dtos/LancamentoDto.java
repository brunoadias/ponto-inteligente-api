package com.dias.pontointeligente.api.dtos;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;

public class LancamentoDto {

	// Id opcional porque dependendo da operação,
	// o id pode existir ou não
	private Optional<Long> id = Optional.empty();
	private String data;
	private String tipo;
	private String descricao;
	private String localizacao;
	private Long funcionarioId;

	public LancamentoDto() {

	}

	/**
	 * @return the id
	 */
	public Optional<Long> getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Optional<Long> id) {
		this.id = id;
	}

	/**
	 * @return the data
	 */
	@NotEmpty(message = "Campo data não pode ser vazio")
	public String getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the localizacao
	 */
	public String getLocalizacao() {
		return localizacao;
	}

	/**
	 * @param localizacao the localizacao to set
	 */
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	/**
	 * @return the funcionarioId
	 */
	public Long getFuncionarioId() {
		return funcionarioId;
	}

	/**
	 * @param funcionarioId the funcionarioId to set
	 */
	public void setFuncionarioId(Long funcionarioId) {
		this.funcionarioId = funcionarioId;
	}
}
