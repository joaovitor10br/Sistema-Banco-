package bank.service;

import bank.model.Conta;
import bank.model.ContaCorrente;
import bank.model.ContaPoupanca;

import java.util.ArrayList;
import java.util.List;

public class BankService {
    private final List<Conta> contas = new ArrayList<>();

    public Conta buscarConta(String numero) {
        for (Conta conta : contas) {
            if (conta.getNumero().equals(numero)) {
                return conta;
            }
        }
        return null;
    }

    public void criarContaCorrente(String numero, String titular) {

        if (buscarConta(numero) != null) {
            System.out.println("Já existe conta com esse numero");
            return;
        }

        Conta conta = new ContaCorrente(numero, titular);
        contas.add(conta);
        System.out.println("Conta corrente criada com sucesso!");
    }

    public void criarContaPoupanca(String numero, String titular) {

        if (buscarConta(numero) != null) {
            System.out.println("Já existe conta com esse numero");
            return;
        }

        Conta conta = new ContaPoupanca(numero, titular);
        contas.add(conta);
        System.out.println("Conta poupanca criada com sucesso!");
    }

    public void depositar(String numero, double valor) {
        Conta conta = buscarConta(numero);

        if (conta != null) {
            conta.depositar(valor);
            System.out.println("Deposito realizado! Novo saldo: " + conta.getSaldo());
        }else{
            System.out.println("Conta não encontrada");
        }
    }

    public void sacar(String numero, double valor) {
        Conta conta = buscarConta(numero);

        if (conta != null) {
            conta.sacar(valor);
            System.out.println("Saque realizado! Novo saldo: " + conta.getSaldo());
        }else{
            System.out.println("Conta não encontrada");
        }
    }

    public void transferir(String origem, String destino, double valor) {
        Conta origemConta = buscarConta(origem);
        Conta destinoConta = buscarConta(destino);

        if (origemConta != null && destinoConta != null) {
            origemConta.sacar(valor);
            destinoConta.depositar(valor);
            System.out.println("Transferência realizada com sucesso!");
            System.out.println("Origem: " + origemConta.getNumero());
            System.out.println("Destino: " + destinoConta.getNumero());
        }else{
            System.out.println("Conta origem ou destino não encontrada");
        }
    }

    public void listarContas(){
        for (Conta conta : contas){
            System.out.println(
                    "Conta: " + conta.getNumero() +
                            " | Titular: " + conta.getTitular() +
                            " | Saldo:  " + conta.getSaldo()
            );
        }
    }
}
