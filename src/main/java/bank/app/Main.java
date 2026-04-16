package bank.app;

import bank.service.BankService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankService bankService = new BankService();
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do{
            System.out.println("== BANCO JAVA ==");
            System.out.println("1 - Criar Conta Corrente");
            System.out.println("2 - Criar Conta Poupanca");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Transferir");
            System.out.println("6 - Listar Contas");
            System.out.println("0 - Sair");
            System.out.println("Digite uma opcao: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Numero da conta: ");
                    String numero = scanner.nextLine();
                    System.out.println("Titular: ");
                    String titular = scanner.nextLine();
                    bankService.criarContaCorrente(numero, titular);
                    break;
                case 2:
                    System.out.println("Numero da conta: ");
                    String numero2 = scanner.nextLine();
                    System.out.println("Titular: ");
                    String titular2 = scanner.nextLine();
                    bankService.criarContaPoupanca(numero2, titular2);
                    break;
                case 3:
                    System.out.println("Numero da conta: ");
                    String numeroDeposito = scanner.nextLine();
                    System.out.println("Valor: ");
                    double valorDeposito = scanner.nextDouble();
                    scanner.nextLine();
                    bankService.depositar(numeroDeposito, valorDeposito);
                    break;
                case 4:
                    System.out.println("Numero da conta: ");
                    String numeroSaque = scanner.nextLine();
                    System.out.println("Valor: ");
                    double valorSaque = scanner.nextDouble();
                    scanner.nextLine();
                    bankService.sacar(numeroSaque, valorSaque);
                    break;
                case 5:
                    System.out.println("Conta origem: ");
                    String origem = scanner.nextLine();
                    System.out.println("Conta destino: ");
                    String destino = scanner.nextLine();
                    System.out.println("Valor: ");
                    double valorTransferido = scanner.nextDouble();
                    scanner.nextLine();
                    bankService.transferir(origem, destino, valorTransferido);
                    break;
                case 6:
                    bankService.listarContas();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
        } while (opcao != 0);
        scanner.close();
    }
}
