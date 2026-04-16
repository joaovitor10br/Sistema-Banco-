package bank.model;

public class ContaCorrente extends Conta {

    public ContaCorrente(String numero, String titular) {
        super(numero, titular);
    }
    @Override
    public void sacar(double valor) {
        double taxaSaque = 2.0;
        saldo -= (valor + taxaSaque);
    }
}
