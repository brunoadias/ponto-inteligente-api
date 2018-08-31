package com.dias.pontointeligente.api.controllers;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.dias.pontointeligente.api.entities.Empresa;
import com.dias.pontointeligente.api.services.EmpresaService;

@RunWith(SpringRunner.class)
@SpringBootTest
// Anotação para criação de um contexto web nos testes
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class EmpresaControllerTest {

	// Instância do MockMvc para permitir requisições http
	@Autowired
	private MockMvc mvc;

	@MockBean
	private EmpresaService empresaService;

	private static final String BUSCAR_EMPRESA_CNPJ_URL = "/api/empresas/cnpj/";
	private static final Long ID = Long.valueOf(1);
	private static final String CNPJ = "11861136000102";
	private static final String RAZAO_SOCIAL = "Empresa XYZ";

	@Test
	@WithMockUser
	public void testBuscarEmpresaCnpjInvalido() throws Exception {
		// Utilização do método given() da classe BDDMockito para chamar
		// o método que será testado e o retorno que se deseja obter
		BDDMockito.given(this.empresaService.buscarPorCnpj(Mockito.anyString())).willReturn(Optional.empty());

		// Utilização do objeto mvc para determinar qual url será testada
		// e qual status http será retornado
		mvc.perform(MockMvcRequestBuilders.get(BUSCAR_EMPRESA_CNPJ_URL + CNPJ).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.errors").value("Empresa não encontrada para o CNPJ " + CNPJ));
	}

	@Test
	@WithMockUser
	public void testBuscarEmpresaCnpjValido() throws Exception {
		// Utilização do método given() da classe BDDMockito para chamar
		// o método que será testado e o retorno que se deseja obter
		BDDMockito.given(this.empresaService.buscarPorCnpj(Mockito.anyString()))
				.willReturn(Optional.of(this.obterDadosEmpresa()));

		mvc.perform(MockMvcRequestBuilders.get(BUSCAR_EMPRESA_CNPJ_URL + CNPJ).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.dados.id").value(ID))
				.andExpect(jsonPath("$.dados.razaoSocial", equalTo(RAZAO_SOCIAL)))
				.andExpect(jsonPath("$.dados.cnpj", equalTo(CNPJ))).andExpect(jsonPath("$.errors").isEmpty());
	}

	private Empresa obterDadosEmpresa() {
		Empresa empresa = new Empresa();
		empresa.setId(ID);
		empresa.setRazaoSocial(RAZAO_SOCIAL);
		empresa.setCnpj(CNPJ);
		return empresa;
	}
}
