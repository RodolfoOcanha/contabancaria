package conta.model;

public class ContaCorrente extends Conta {

	private float limite;

	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;

	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}

	@Override
	public boolean sacar(float valor) {
		if (this.getSaldo() + this.limite < valor) {
			System.out.println("\nSaldo insuficiente para saque");
			return false;

		}
		this.setSaldo(this.getSaldo() - valor);
		System.out.println("\nSaque efetuado com  sucesso, use com sabedoria!");
		return true;
	}

}