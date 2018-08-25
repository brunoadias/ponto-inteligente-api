package com.dias.pontointeligente.api.dtos;

import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

public class CadastroPFDto {

	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String cpf;

	// Como os atributos valorHora, qtdHorasTrabalhoDia e qtdHorasAlmoco são
	// opcionais, coloca-se os mesmos do tipo Optional<String>,
	// sendo inicializados com o valor vazio
	private Optional<String> valorHora = Optional.empty();
	private Optional<String> qtdHorasTrabalhoDia = Optional.empty();
	private Optional<String> qtdHorasAlmoco = Optional.empty();
	private String cnpj;

	public CadastroPFDto() {

	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	@NotEmpty(message = "Campo Nome não pode ser vazio")
	@Length(min = 3, max = 200, message = "O nome deve conter entre 3 e 200 caracteres")
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the email
	 */
	@NotEmpty(message = "Campo Email não pode ser vazio")
	@Length(min = 5, max = 200, message = "O email deve conter entre 5 e 200 caracteres")
	@Email(message = "Email inválido")
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the senha
	 */
	@NotEmpty(message = "Campo Senha não pode ser vazio")
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the cpf
	 */
	@NotEmpty(message = "Campo CPF não pode ser vazio")
	@CPF(message = "CPF inválido")
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the valorHora
	 */
	public Optional<String> getValorHora() {
		return valorHora;
	}

	/**
	 * @param valorHora the valorHora to set
	 */
	public void setValorHora(Optional<String> valorHora) {
		this.valorHora = valorHora;
	}

	/**
	 * @return the qtdHorasTrabalhoDia
	 */
	public Optional<String> getQtdHorasTrabalhoDia() {
		return qtdHorasTrabalhoDia;
	}

	/**
	 * @param qtdHorasTrabalhoDia the qtdHorasTrabalhoDia to set
	 */
	public void setQtdHorasTrabalhoDia(Optional<String> qtdHorasTrabalhoDia) {
		this.qtdHorasTrabalhoDia = qtdHorasTrabalhoDia;
	}

	/**
	 * @return the qtdHorasAlmoco
	 */
	public Optional<String> getQtdHorasAlmoco() {
		return qtdHorasAlmoco;
	}

	/**
	 * @param qtdHorasAlmoco the qtdHorasAlmoco to set
	 */
	public void setQtdHorasAlmoco(Optional<String> qtdHorasAlmoco) {
		this.qtdHorasAlmoco = qtdHorasAlmoco;
	}

	/**
	 * @return the cnpj
	 */
	@NotEmpty(message = "Campo CNPJ não pode ser vazio")
	@CNPJ(message = "CNPJ inválido")
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * @param cnpj the cnpj to set
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
