package conta;

import conta.tributos.Tributavel;
import dados.Cliente;

public class SeguroDeVida  implements Tributavel {

    private TipoSeguro tipoSeguro;
    private Cliente    cliente;

    public SeguroDeVida(TipoSeguro tipoSeguro, Cliente cliente){
        this.cliente = cliente;
        this.tipoSeguro = tipoSeguro;
    }


    @Override
    public double getValorImposto() {
        if (tipoSeguro.equals(TipoSeguro.BASICO)) return 10;
        if (tipoSeguro.equals(TipoSeguro.SEMI_COMPLETO))return 20;
        return 30;
    }

    public enum TipoSeguro {
        BASICO(1), SEMI_COMPLETO(2), COMPLETO(3);

        private final int opcaoSeguro;

        TipoSeguro(int opcaoSeguro){
            this.opcaoSeguro = opcaoSeguro;
        }

        public int getOpcaoSeguro(){
            return opcaoSeguro;
        }
    }
}
