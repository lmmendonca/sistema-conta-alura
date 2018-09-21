public class ContaPoupanca extends Conta{

    public ContaPoupanca(double saldo, int agencia, int numero, Cliente titular) {
        super(saldo, agencia, numero, titular);
    }

    @Override
    public void deposita(double valor) {
        super.saldo += valor;
    }

}
