package conta;

import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class testaConta {

	public static void main(String[] args) {

		ContaPoupanca contaPoupanca1 = new ContaPoupanca(14169, 1579, 2, "Luiz", 10000.0f, 3000.0f);
		System.out.println("Saldo inicial: " + contaPoupanca1.getSaldo());
		contaPoupanca1.depositar(5000);

		ContaCorrente contaCorrente1 = new ContaCorrente(32, 33, 1, "Tadeu", 4000.0f, 3000.0f);

		System.out.println("\nSaldo inicial: " + contaCorrente1.getSaldo());
		contaCorrente1.sacar(3000);
		System.out.println("Saldo após saque: " + contaCorrente1.getSaldo());
	}
}