package conta.controller;

import java.util.ArrayList;
import conta.model.Conta;
import conta.model.Cores;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository {

	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarConta(numero);
		
		if (conta != null)
			conta.visualizar();
		else
			System.out.println(Cores.TEXT_RED_BOLD+"\n A conta número: " + numero + "\n não foi localizada no sistema! ");

	}

	@Override
	public void listarTodas() {
		for (var conta : listaContas) {
			conta.visualizar();
		}

	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println(Cores.TEXT_WHITE_BOLD+"\nConta número " + conta.getNumero() + " criada com sucesso!");

	}

	@Override
	public void atualizar(Conta conta) {
		var buscaConta = buscarConta(conta.getNumero());
		
		if(buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
			System.out.println(Cores.TEXT_WHITE_BOLD +"\nA conta número:" + conta.getNumero() + " foi atualizada com sucessso!");
		}else
			System.out.println(Cores.TEXT_RED_BOLD +"\n A conta número:" + conta.getNumero() + " não encontrada no sistema!");

	}

	@Override
	public void deletar(int numero) {
		var conta = buscarConta(numero);
		
		if (conta != null) {
			if(listaContas.remove(conta) == true)
				System.out.println(Cores.TEXT_WHITE_BOLD+"\nConta número: " + numero +" deletada com sucesso.");
		}else
			System.out.println(Cores.TEXT_RED_BOLD+"\nConta número: " + numero +" não localizada no sistema.");

	}

	@Override
	public void sacar(int numero, float valor) {
		var conta = buscarConta(numero);
		
		if (conta != null) {
			if (conta.sacar(valor) == true)
				System.out.println(Cores.TEXT_WHITE_BOLD +"Saque da conta " + numero + " efetuado com sucesso!");
		}else
			System.out.println(Cores.TEXT_RED_BOLD+"Número de conta inválido!");
		

	}

	@Override
	public void depositar(int numero, float valor) {
		var conta = buscarConta(numero);
		
		if (conta != null) {
			conta.depositar(valor);
			System.out.println(Cores.TEXT_WHITE_BOLD +"Depósito na conta " + numero + " efetuado com sucesso!");
		} else
			System.out.println(Cores.TEXT_RED_BOLD+"A conta número:" + numero + " não foi encontrada no sistema ou"
					+ " a conta não é uma conta corrente!");

	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var contaOrigem = buscarConta(numeroOrigem);
		var contaDestino = buscarConta(numeroDestino);
		
		if (contaOrigem != null && contaDestino != null) {
			
			if(contaOrigem.sacar(valor)== true) {
				contaDestino.depositar(valor);
				System.out.println(Cores.TEXT_WHITE_BOLD+"\nTransferência efetuada com sucesso");
			}else
				System.out.println(Cores.TEXT_RED_BOLD+"Conta não encontrada no sistema.");
		}

	}

	public int gerarNumero() {
		return ++numero;
	}
    
	public Conta buscarConta(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
	}
}
	

