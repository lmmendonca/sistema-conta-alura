package br.com.banco.contas;

import br.com.banco.dados.Cliente;

/**
 * Classe conta representativa do banco
 *
 * @author lmmendonca
 * @version 0.0.1
 */
public abstract class Conta implements Comparable<Conta>{

    protected      double  saldo;
    private        int     agencia;
    private        int     numero;
    private        Cliente titular;
    private static int     total;

    /**
     * Contrutor padrão classe Contam
     *
     * @param saldo a ser inserido inicialmente
     * @param agencia da conta
     * @param numero da conta
     * @param titular da conta
     */
    public Conta(double saldo, int agencia, int numero, Cliente titular) {
        total++;
        this.saldo = saldo;
        this.agencia = agencia;
        this.numero = numero;
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public abstract void deposita(double valor);

    public boolean saca(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean transferencia(Conta cntDestino, double valor) {
        if (!saca(valor)) {
            return false;
        }
        cntDestino.deposita(valor);
        return true;
    }

    public int getId() {
        return total;
    }

    @Override
    public int compareTo(Conta o) {
        return Integer.compare(this.numero,o.numero);
    }


}
