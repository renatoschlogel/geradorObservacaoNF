package br.com.renato.nf.relatorios.observacao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import br.com.renato.nf.relarorios.observacao.GeradorObservacao;

public class GeradorObservacaoTest {

	@InjectMocks
	private GeradorObservacao geradorObservacao;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void deveRetornarUmaStringVazia() throws Exception {
		List<Integer> listaVazia = new ArrayList<Integer>();
		String observacao = geradorObservacao.geraObservacao(listaVazia);
		Assert.assertEquals(observacao, "");
	}
	
	@Test
	public void deveRetornarAObservacaoDasNFsNoPlural() throws Exception {
		List<Integer> listaVazia = Arrays.asList(1,2,3,4,5);
		String observacao = geradorObservacao.geraObservacao(listaVazia);
		Assert.assertEquals(observacao, "Fatura das notas fiscais de simples remessa: 1, 2, 3, 4 e 5.");
	}
	
	@Test
	public void deveRetornarAObservacaoDaNFSingular() throws Exception {
		List<Integer> listaVazia = Arrays.asList(1);
		String observacao = geradorObservacao.geraObservacao(listaVazia);
		Assert.assertEquals(observacao, "Fatura da nota fiscal de simples remessa: 1.");
	}
	
	/*
	@Test
	public void deveRetornarAObservacaoContendoOValorDaNFEOTotalDasNFs() throws Exception {
		List<Integer> listaVazia = Arrays.asList();
		String observacao = geradorObservacao.geraObservacao(listaVazia);
		Assert.assertEquals(observacao, "Fatura das notas fiscais de simples remessa: 1 cujo valor � R$ 10,00,"
				                      + " 2 cujo valor � R$ 35,00, 3 cujo valor � R$ 5,00, 4 cujo valor � R$ 1.500,00 e"
				                      + " 5 cujo valor � R$ 0,30. Total = 1.550,30.");Xt
	}
	*/
	
}
