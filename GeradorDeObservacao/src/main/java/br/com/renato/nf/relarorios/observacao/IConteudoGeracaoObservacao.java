package br.com.renato.nf.relarorios.observacao;

import java.util.List;

public interface IConteudoGeracaoObservacao {

	public String textoInicialPlural();
	
	public String textoInicialSingular();
	
	public List<String> listaConteudo();
	
	public default String textoFinal() {
		return "";
	};
	
}
