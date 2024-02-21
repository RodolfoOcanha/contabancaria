package conta.model;

public class ContaPoupanca extends Conta {

	private float reservaEmergencia;

	public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo, float reservaEmergencia) {

		super(numero, agencia, tipo, titular, saldo);
		this.reservaEmergencia = reservaEmergencia;

	}

	public float getReservaEmergencia() {
		return reservaEmergencia;
	}

	public void setReservaEmergencia(float reservaEmergencia) {
		this.reservaEmergencia = reservaEmergencia;
	}

	@Override
	public void depositar(float valor) {
		if (valor == 0) {
			System.out.println("\nValor inválido para depósito");
			return;
		}

		float novoSaldo = this.getSaldo() + this.reservaEmergencia;
		this.setSaldo(novoSaldo);
		this.reservaEmergencia = reservaEmergencia + valor;

		System.out.println("\nValor adicionado à sua reserva de emergência! Seu saldo novo é: " + novoSaldo);
	}
}