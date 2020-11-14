package br.com.renato.nf.relarorios.observacao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.renato.nf.entidades.NotaFiscalFake;

public class GeradorObservaoNFComDetalhesDeValor implements IConteudoGeracaoObservacao{

	private List<String> numerosNotas;
	
	private BigDecimal valorTotal;

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
	
	@Override
	public String textoFinal() {
		return "Total: " + valorTotal + ".";
	}

	public String gerarObservacao(List<NotaFiscalFake> notas) {
		
		if (notas.isEmpty()) {
			return "";
		}
		
		preparaDados(notas);
		GeradorObservacaoListaDados geradorObservacaoListaDados = new GeradorObservacaoListaDados(this);
		return geradorObservacaoListaDados.gerarObservacao();
	}

	private void preparaDados(List<NotaFiscalFake> notas) {
		numerosNotas = new ArrayList<String>();
		
		for (NotaFiscalFake nota : notas) {
			valorTotal.add(nota.getValor());
			
			numerosNotas.add(nota.getNumero().toString());
		}
	}

}
