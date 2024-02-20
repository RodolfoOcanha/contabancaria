package conta;

import conta.model.Conta;

public class testaConta {

	public static void main(String[] args) {

		Conta novaConta = new Conta(32 , 453 , 2 , "Nelson" , 2345.0f);

		novaConta.setNumero(32);
		novaConta.setAgencia(453);
		novaConta.setTipo(2);
		novaConta.setTitular("Nelson");
		novaConta.setSaldo(2345);

		System.out.println("Numero da conta " + novaConta.getNumero());
		System.out.println("Numero da ag " + novaConta.getAgencia());
		System.out.println("Tipo da conta " + novaConta.getTipo());
		System.out.println("Titular da conta " + novaConta.getTitular());
		System.out.println("Saldo da conta " + "" + novaConta.getSaldo());

	}

}
