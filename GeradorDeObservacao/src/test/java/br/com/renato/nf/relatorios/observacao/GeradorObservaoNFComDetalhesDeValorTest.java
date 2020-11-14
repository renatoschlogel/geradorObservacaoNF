package br.com.renato.nf.relatorios.observacao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import br.com.renato.nf.builders.NotaFiscalFakeBuilder;
import br.com.renato.nf.entidades.NotaFiscalFake;
import br.com.renato.nf.relarorios.observacao.GeradorObservaoNFComDetalhesDeValor;

public class GeradorObservaoNFComDetalhesDeValorTest {
	
	@InjectMocks
	private GeradorObservaoNFComDetalhesDeValor geradorObservacao;
	
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void deveRetornarUmaStringVazia() throws Exception {
		List<Integer> listaVazia = new ArrayList<Integer>();
		
		NotaFiscalFake notaFiscal1 = new NotaFiscalFakeBuilder().withNumero(1).withValor(new BigDecimal(100)).build();
		NotaFiscalFake notaFiscal2 = new NotaFiscalFakeBuilder().withNumero(2).withValor(new BigDecimal(150)).build();
		NotaFiscalFake notaFiscal3 = new NotaFiscalFakeBuilder().withNumero(3).withValor(new BigDecimal(500)).build();
		
		List<NotaFiscalFake> notas = Arrays.asList(notaFiscal1, notaFiscal2, notaFiscal3);

		String observacao = geradorObservacao.gerarObservacao(notas);
		Assert.assertEquals(observacao, "");
	}

}
