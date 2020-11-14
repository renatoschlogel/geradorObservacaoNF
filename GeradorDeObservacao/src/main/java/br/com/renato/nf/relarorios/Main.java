package br.com.renato.nf.relarorios;

import java.util.Arrays;

import br.com.renato.nf.relarorios.observacao.GeradorObservacaoListasDeValores;

public class Main {

	public static void main(String[] args) {
		
		GeradorObservacaoListasDeValores geradorObservacao = new GeradorObservacaoListasDeValores();
		geradorObservacao.geraObservacao();
		
		
		String observacao = geradorObservacao.geraObservacao(Arrays.asList(1,8,3));
		
		
		System.out.println(observacao);
	}
}
