package br.com.renato.nf.relarorios;

import java.util.Arrays;

import br.com.renato.nf.relarorios.observacao.GeradorObservacao;
import br.com.renato.nf.relarorios.observacao.GeradorObservacaoListaDados;

public class Main {

	public static void main(String[] args) {
		
		GeradorObservacao geradorObservacao = new GeradorObservacao();
		
		
		String observacao = geradorObservacao.geraObservacao(Arrays.asList(1,8,3));
		
		
		System.out.println(observacao);
	}
}
