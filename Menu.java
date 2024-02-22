package conta;

import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class Menu {

	public static void main(String[] args) {

		ContaCorrente contaCorrente1 = new ContaCorrente(1, 123, 1, "Sabrina", 250000.0f , 2000.0f);
		
		System.out.println(contaCorrente1.getNumero());
		System.out.println(contaCorrente1.getAgencia());
		System.out.println(contaCorrente1.getTipo());
		System.out.println(contaCorrente1.getTitular());
		System.out.println(contaCorrente1.getSaldo());
		System.out.println(contaCorrente1.getLimite());
		
		System.out.println("Saldo Atual: " + contaCorrente1.getSaldo());

		

	}

}
