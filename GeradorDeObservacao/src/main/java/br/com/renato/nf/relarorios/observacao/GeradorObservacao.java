package br.com.renato.nf.relarorios.observacao;

import java.util.List;
import java.util.stream.Collectors;

public class GeradorObservacao implements IConteudoGeracaoObservacao{
	
	List<String> numerosNotas;

	@Override
	public String textoInicialPlural() {
		return "Fatura das notas fiscais de simples remessa: ";
	}

	@Override
	public String textoInicialSingular() {
		return "Fatura da nota fiscal de simples remessa: ";
	}

	@Override
	public List<String> listaConteudo() {
		return this.numerosNotas;
	}
	
	public String geraObservacao(List notasFiscais) {
		
		if (notasFiscais.isEmpty()) {
			return "";
		}
		
		preparaDados(notasFiscais);
		GeradorObservacaoListaDados geradorObservacaoListaDados = new GeradorObservacaoListaDados(this);
		return geradorObservacaoListaDados.gerarObservacao();
	}

	private void preparaDados(List<Integer> notasFiscais) {
		List<String> numerosNFConvertidosParaString = notasFiscais.stream().map(Object::toString).collect(Collectors.toList());
		this.numerosNotas = numerosNFConvertidosParaString;
	}

}
