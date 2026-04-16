package bank.model;

public class Conta {
    protected String numero;
    protected String titular;
    protected double saldo;

    public Conta(String numero, String titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor invalido");
            return;
        }
        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor invalido");
            return;
        }
        if (saldo >= valor) {
            System.out.println("Saldo insuficiente");
            return;
        }
        saldo -= valor;
    }

    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }
}
