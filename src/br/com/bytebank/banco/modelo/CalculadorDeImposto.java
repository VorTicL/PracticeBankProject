package br.com.bytebank.banco.modelo;

public class CalculadorDeImposto {
	
	private double totalImposto;
	
	public void registra(Tributavel tr) {
		this.totalImposto += tr.getValorImposto();
	}
	
	public double getTotalImposto() {
		return this.totalImposto;
	}
}
