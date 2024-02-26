package conta.model;

public abstract class Conta {

	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;

	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}

	public Conta() {
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public boolean sacar(float valor) {
		if (this.getSaldo() < valor) {
			System.out.println("\n Saldo insuficiente para saque.");
			return false;
		}
		this.setSaldo(this.getSaldo() - valor);
		return true;

	}

	public void reservaEmergencia(float valor) {
		this.setSaldo(this.saldo + valor);

	}

	public void depositar(float valor) {
		this.setSaldo(this.saldo + valor);

	}

	public void visualizar() {

		String tipoConta = "";

		switch (this.tipo) {
		case 1:
			tipoConta = "Conta corrente";
			break;
		case 2:
			tipoConta = "Conta Poupança";
			break;
		}

		System.out.println(Cores.TEXT_RED_BOLD +"\n********************************");
		System.out.println(Cores.TEXT_WHITE_BOLD +"Dados da conta");
		System.out.println(Cores.TEXT_RED_BOLD +"******************************** "   );
		System.out.println(Cores.TEXT_WHITE_BOLD + "Número da conta: " + this.numero);
		System.out.println(Cores.TEXT_WHITE_BOLD +"Agência: " + this.agencia);
		System.out.println(Cores.TEXT_WHITE_BOLD +"Tipo da conta: " + tipoConta);
		System.out.println(Cores.TEXT_WHITE_BOLD +"Titular da conta: " + this.titular);
		System.out.println(Cores.TEXT_WHITE_BOLD +"Saldo da conta: " + this.saldo);

	}

}
