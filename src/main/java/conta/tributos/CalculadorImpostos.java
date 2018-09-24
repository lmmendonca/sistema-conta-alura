package conta.tributos;

import conta.tributos.Tributavel;

public class CalculadorImpostos implements Tributavel {

    private double totalImposto;

    public void regista(Tributavel t) {
        totalImposto += t.getValorImposto();
    }

    public double getValorImposto() {
        return totalImposto;
    }

}
