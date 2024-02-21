package conta;

import conta.model.Conta;

public class Menu {

	public static void main(String[] args) {

		Conta contaNova = new Conta(1, 123, 1, "Sabrina", 250000.0f);

		contaNova.visualizar();
		contaNova.setAgencia(456);
		System.out.println(contaNova.getAgencia());

		if (contaNova.sacar(100))
			System.out.println("Saque efetuado com sucesso. O novo saldo é de : " + contaNova.getSaldo());
		else
			System.out.println("O saldo é insuficiente.");
		
		contaNova.depositar(2000);
		System.out.println("Depósito efetuado, o novo saldo é de: " + contaNova.getSaldo());
		
		

	}

}
