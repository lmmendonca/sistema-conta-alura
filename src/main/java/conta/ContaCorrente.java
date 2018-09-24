package conta;

import conta.tributos.Tributavel;
import dados.Cliente;

public class ContaCorrente extends Conta implements Tributavel {

    public ContaCorrente(double saldo, int agencia, int numero, Cliente titular) {
        super(saldo, agencia, numero, titular);
    }

    @Override
    public boolean saca(double valor) {
        return super.saca(valor + 0.20);
    }

    @Override
    public void deposita(double valor) {
        super.saldo += valor;
    }

    public double getValorImposto() {
        return super.saldo * 0.01;
    }
}
