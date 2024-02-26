package conta;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.model.Cores;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	public static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		ContaController contas = new ContaController();
		;
		int opcao, numero, agencia, tipo, numeroDestino;
		String titular;
		float saldo = 0 , limite, reservaEmergencia , valor;

		while (true) {

			System.out.println(Cores.TEXT_BLACK_BOLD + Cores.ANSI_CYAN_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO DEV DO FUTURO                  ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 9) {
				System.out.println("\nBanco DEV do futuro - suas transações mais seguras com a gente!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD +"\nCriar Conta\n");
				
				System.out.println(Cores.TEXT_WHITE_BOLD +"Digite o número da Agência:");
				agencia = leia.nextInt();
				System.out.println(Cores.TEXT_WHITE_BOLD +"Digite o nome do Dev titular:");
				leia.skip("\\R?");
				titular = leia.nextLine();
				
				do {
					System.out.println("Digite para qual tipo de conta deseja abrir "
							+ "(1- Conta Corrente ou 2- Conta poupança)");
					tipo = leia.nextInt();
				}while (tipo < 1 && tipo > 2);
				
				System.out.println("Digite o saldo da conta (R$): ");
				leia.skip("\\R?");
				saldo = leia.nextFloat();
				
				
				switch(tipo) {
				case 1 -> {
					System.out.println("Digite o limite (R$):");
					
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente (contas.gerarNumero(), agencia , tipo, titular , saldo , limite));
					break;
				}	
				case 2 ->  {
					System.out.println("Digite quanto você quer guardar na sua reserva de Emergência(R$):");
					reservaEmergencia = leia.nextFloat();
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia,tipo,titular,saldo ,reservaEmergencia));
					break;
		        }
				}
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nListar todas as Contas");
				contas.listarTodas();

				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD+"\n Buscar dados da conta pelo número\n");
				
				System.out.println(Cores.TEXT_WHITE_BOLD+"Digite o numero da conta:");
				numero = leia.nextInt();
				
				contas.procurarPorNumero(numero);

				keyPress();
				break;
			case 4:
				System.out.println("\nAtualizar dados da Conta");
				
				System.out.println("Digite o número da conta:");
				numero = leia.nextInt();
				
				var buscaConta = contas.buscarConta(numero);
				
				if(buscaConta != null) {
					
					tipo = buscaConta.getTipo();
					System.out.println(Cores.TEXT_WHITE_BOLD+"\nDigite a agência: ");
					agencia = leia.nextInt();
					System.out.println(Cores.TEXT_WHITE_BOLD+"\nDigite o nome do titular: ");
					titular = leia.next();
					
					System.out.println(Cores.TEXT_WHITE_BOLD+"\nDigite o saldo da conta: ");
					saldo = leia.nextFloat();
					
					switch (tipo) {
					case 1 -> {
						System.out.println("\nDigite o limite de crédito: ");
						limite = leia.nextFloat();
						
						contas.atualizar(new ContaCorrente(numero , agencia , tipo , titular , saldo , limite));
						
					}
					case 2 -> {
						System.out.println(Cores.TEXT_WHITE_BOLD+"Digite o quanto quer guardar na sua reserva de emergência: ");
						reservaEmergencia = leia.nextFloat();
						
						contas.atualizar(new ContaPoupanca(numero, agencia , tipo , titular , saldo , reservaEmergencia));
					}
					default ->
					System.out.println(Cores.TEXT_RED_BOLD +"\nTipo de conta inválida!");
					}
					}
			else {
				System.out.println(Cores.TEXT_RED_BOLD + "\nConta não localizada no sistema!");
			}
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nDeseja apagar a Conta?\n");
				System.out.println(Cores.TEXT_WHITE_BOLD+"\nDigite o número da conta:");
				numero = leia.nextInt();
				
				contas.deletar(numero);

				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD+"\nSacar");
				System.out.println(Cores.TEXT_WHITE_BOLD+"\nDigite o numero da conta: ");
				numero = leia.nextInt();
				
				do {
					System.out.println(Cores.TEXT_WHITE_BOLD+"\nDigite o valor do saque (R$): ");
					valor = leia.nextFloat();
					} while (valor <= 0);
				
				contas.sacar(numero, valor);
				
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD+"\nDepositar");
				System.out.println(Cores.TEXT_WHITE_BOLD+"\nDigite o número da conta: ");
				numero = leia.nextInt();
				
				do {
					System.out.println(Cores.TEXT_WHITE_BOLD+"\nDigite o valor do depósito(R$): ");
					valor = leia.nextFloat();
					} while (valor <= 0);
				
				contas.depositar(numero, valor);

				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD+"\nTransferência entre contas\n");
				
				System.out.println(Cores.TEXT_WHITE_BOLD+"\nDigite o número da conta de origem: ");
				numero = leia.nextInt();
				System.out.println(Cores.TEXT_WHITE_BOLD+"\nDigite o número da conta de destino: ");
				numeroDestino = leia.nextInt();
				
				do {
					System.out.println(Cores.TEXT_WHITE_BOLD+"\nDigite o valor que deseja transferir: ");
					valor = leia.nextFloat();
				} while (valor <= 0);
				
				contas.transferir(numero, numeroDestino, valor);
				keyPress();
				break;
			default:
				System.out.println("\nOpção Inválida" + Cores.TEXT_RESET);

				keyPress();
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println(Cores.TEXT_WHITE_BOLD+"Projeto Desenvolvido por: Rodolfo Ocanha ");
		System.out.println(Cores.TEXT_WHITE_BOLD+"Generation Brasil - generation@generation.org");
		System.out.println(Cores.TEXT_WHITE_BOLD+"github.com/RodolfoOcanha");
		System.out.println("*********************************************************");
	}

	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
	}
}