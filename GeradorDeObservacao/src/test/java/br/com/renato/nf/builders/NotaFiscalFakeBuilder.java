package br.com.renato.nf.builders;

import java.math.BigDecimal;

import br.com.renato.nf.entidades.NotaFiscalFake;

public class NotaFiscalFakeBuilder {
	
	private NotaFiscalFake notaFiscalFake;
	
	public NotaFiscalFakeBuilder() {
		this.notaFiscalFake = new NotaFiscalFake();
		this.notaFiscalFake.setNumero(1);
		this.notaFiscalFake.setValor(BigDecimal.ZERO);
	}
	
	public NotaFiscalFakeBuilder withNumero(Integer numero) {
		this.notaFiscalFake.setNumero(numero);
		return this;
	}
	
	public NotaFiscalFakeBuilder withValor(BigDecimal valor) {
		this.notaFiscalFake.setValor(valor);
		return this;
	}
	
	public NotaFiscalFake build() {
		return this.notaFiscalFake;
	}

}
