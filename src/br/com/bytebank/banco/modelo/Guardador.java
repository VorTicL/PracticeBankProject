package br.com.bytebank.banco.modelo;

public class Guardador{
	
	private Object[] ref;
	private int posicaoLivre;
	
	public Guardador() {
		this.ref = new Conta[10];
		posicaoLivre = 0;
		
	}
	public void adiciona(Object conta) {
		this.ref[this.posicaoLivre] = conta;
		this.posicaoLivre++;
	}
	
	public int getQuantidadeDeElementos() {
		return this.posicaoLivre;
	}
	
	public Object getRef(int pos) {
		if (pos < posicaoLivre) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return this.ref[pos];
	}
	
}
