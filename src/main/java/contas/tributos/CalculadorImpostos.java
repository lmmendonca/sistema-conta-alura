package contas.tributos;

public class CalculadorImpostos implements Tributavel {

    private double totalImposto;

    public void regista(Tributavel t) {
        totalImposto += t.getValorImposto();
    }

    public double getValorImposto() {
        return totalImposto;
    }

}
