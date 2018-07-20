package br.com.bytebank.banco.modelo;

/**
 * Classe representa a moldura de uma conta
 * 
 * @author Victor de Lucca
 *
 */
public abstract class Conta implements Comparable<Conta> {
	protected double saldo;
    private int agencia;
    private int numero;
    private Cliente cliente;	
    private static int total = 0;

    public Conta(int agencia, int numero, Cliente cliente) {
    	total++;
    	this.agencia = agencia;
    	this.numero = numero;
    	this.cliente = cliente;
    }
    
    /**
     * Contrutor para instanciar uma Conta
     * 
     * @param agencia
     * @param numero
     */
    
    public Conta(int agencia, int numero) {
    	total++;
    	this.agencia = agencia;
    	this.numero = numero;
    }
    
    public Conta(int agencia, int numero, Cliente cliente, double saldo) {
    	total++;
    	this.agencia = agencia;
    	this.numero = numero;
    	this.cliente = cliente;
    	this.saldo = saldo;
    }
    
    public abstract void deposita(double valor);
    
    public void saca(double valor) throws SaldoInsuficienteException {
    	if(this.saldo < valor) {
    		throw new SaldoInsuficienteException("Saldo: " +this.saldo + ", Valor: "+valor);
    	}
    	this.saldo -= valor;
    }
    
    public static int getTotal() {
    	return Conta.total;
    }
    
    public void transfere(double valor, Conta destino) throws SaldoInsuficienteException{
    	this.saca(valor);
    	destino.deposita(valor);
    }

	public double getSaldo() {
		return saldo;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		if (agencia > 0) {
			this.agencia = agencia;
		}
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		if (numero > 0) {
			this.numero = numero;
		}
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
    
	@Override
	public String toString() {
		return "Agencia: " + this.agencia + ", Numero: " + this.numero +", Saldo: "+this.saldo;
	}
	
	@Override
	public boolean equals(Object obj) {
		Conta conta = (Conta)obj;
		if (conta.getAgencia() != this.agencia) {
			return false;
		}
		if (conta.getNumero() != this.numero) {
			return false;
		}
		return true;
	}
	
	
	@Override
	public int compareTo(Conta o) {
		return Double.compare(this.saldo, o.saldo);
	}
    
}
