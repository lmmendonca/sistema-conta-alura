public class Conta {

    private double     saldo;
    private int        agencia;
    private int        numero;
    private Cliente    titular;
    private static int total;

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

    public void deposita(double valor) {
        saldo += valor;
    }

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
}
