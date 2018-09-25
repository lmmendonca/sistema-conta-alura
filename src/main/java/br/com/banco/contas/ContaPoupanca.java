package br.com.banco.contas;

import br.com.banco.dados.Cliente;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(double saldo, int agencia, int numero, Cliente titular) {
        super(saldo, agencia, numero, titular);
    }

    @Override
    public void deposita(double valor) {
        super.saldo += valor;
    }

    @Override
    public boolean saca(double valor) {
        return super.saca(valor);
    }
}
