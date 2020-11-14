package br.com.renato.nf.relarorios.observacao;

import java.util.Iterator;
import java.util.List;

public class GeradorObservacaoListasDeValores { 
	
	private IConteudoGeracaoObservacao conteudoGeracaoObservacao;

	//Textos pr�-definidos
	private static final String textoInicialUmaNota         = "Fatura da nota fiscal de simples remessa: ";
	private static final String textoInicialDuasNotasOuMais = "Fatura das notas fiscais de simples remessa: ";
	
	public GeradorObservacaoListasDeValores() {
	}
	
	public GeradorObservacaoListasDeValores(IConteudoGeracaoObservacao dadosGeracaoObservacao) {
		this.conteudoGeracaoObservacao = dadosGeracaoObservacao;
	}
		
	//Gera observa��es, com texto pre-definido, incluindo os n�meros, das notas fiscais, recebidos no par�metro
	public String geraObservacao(List notasFiscais) {
		
		if (!notasFiscais.isEmpty()) {
			return retornaCodigos(notasFiscais) + ".";
		}		
		return "";		
	}
	
	public String geraObservacao() {
		
		List<String> listaConteudo = conteudoGeracaoObservacao.listaConteudo();
		if (listaConteudo == null || listaConteudo.isEmpty()) {
			return "";
		}
		
		String textoInicial = getTextoInicial(listaConteudo);
		String textoConteudo = getTextoInicial(listaConteudo);
		String textoFinal = this.conteudoGeracaoObservacao.textoFinal();
		
		return textoInicial + textoConteudo + textoFinal;
	}

	//Cria observa��o
	private String retornaCodigos(List lista) {
		String texto = getTextoInicial(lista);
		
		//Acha separador
		StringBuilder cod = new StringBuilder();
		for (Iterator<Integer> iterator = lista.iterator(); iterator.hasNext();) {
			Integer numeroNF = iterator.next();
			String separador = "";
			if (cod.toString() == null || cod.toString().length() <= 0) {
				separador = "";
			}
			else if (iterator.hasNext()) {
				separador = ", ";
			}else {
				separador = " e ";
			}
			
			cod.append(separador + numeroNF);
		}
		
		return texto + cod.toString();
	}

	private String getTextoInicial(List lista) {
		if (lista.size() >= 2) {
			return this.conteudoGeracaoObservacao.textoInicialPlural();
		} else {
			return this.conteudoGeracaoObservacao.textoInicialSingular();
		}
	}
}