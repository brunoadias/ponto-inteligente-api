package com.dias.pontointeligente.api.response;

import java.util.ArrayList;
import java.util.List;

public class Response<T> {

	private T dados;
	private List<String> erros;

	public Response() {

	}

	/**
	 * @return the dados
	 */
	public T getDados() {
		return dados;
	}

	/**
	 * @param dados the dados to set
	 */
	public void setDados(T dados) {
		this.dados = dados;
	}

	/**
	 * @return the erros
	 */
	public List<String> getErros() {
		if (this.erros == null) {
			this.erros = new ArrayList<String>();
		}
		return erros;
	}

	/**
	 * @param erros the erros to set
	 */
	public void setErros(List<String> erros) {
		this.erros = erros;
	}
}
