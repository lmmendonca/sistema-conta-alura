public class ContaCorrente extends Conta {

    public ContaCorrente(double saldo, int agencia, int numero, Cliente titular) {
        super(saldo, agencia, numero, titular);
    }

    @Override
    public boolean saca(double valor) {
        return super.saca(valor + 0.20);
    }
}
