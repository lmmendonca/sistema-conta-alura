import br.com.banco.contas.tributos.CalculadorImpostos;
import br.com.banco.contas.ContaCorrente;
import br.com.banco.contas.SeguroDeVida;
import br.com.banco.dados.Cliente;
import br.com.banco.dados.Endereco;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidacoesBanco {

    private final Endereco endereco1 = new Endereco(
            "Avenida Rio de Janeiro", "apto 601", "1635", "centro",
            "Londrina", "86010-150");

    private final Cliente cliente1 = new Cliente(
            "Leonardo", "08662040918", "6213078", endereco1, "solteiro", "Estudante",
            "02/06/1999", "lmmendonca@gmail.com");

    private final Cliente cliente2 = new Cliente(
            "Leandro", "08662040918", "6213078", endereco1, "solteiro", "Estudante",
            "02/06/1999", "lmmendonca@gmail.com");

    @Test
    public void criarEndereco_validarAtributos() {
        Endereco endereco = new Endereco(
                "Avenida Rio de Janeiro", "apto 601", "1635", "centro",
                "Londrina", "86010-150");

        Assertions.assertEquals("AVENIDA RIO DE JANEIRO", endereco.getLogradouro());
        Assertions.assertEquals("APTO 601", endereco.getComplemento());
        Assertions.assertEquals("1635", endereco.getNumero());
        Assertions.assertEquals("CENTRO", endereco.getBairro());
        Assertions.assertEquals("LONDRINA", endereco.getCidade());
        Assertions.assertEquals("86010-150", endereco.getCep());
    }

    @Test
    public void criaCliente_validaAtributos() {
        Endereco endereco = new Endereco(
                "Avenida Rio de Janeiro", "apto 601", "1635", "centro",
                "Londrina", "86010-150");

        Cliente cliente = new Cliente(
                "Leonardo", "08662040918", "6213078", endereco,
                "solteiro", "Estudante", "02/06/1999", "lmmendonca@gmail.com");

        Assertions.assertEquals("Leonardo", cliente.getNome());
        Assertions.assertEquals("08662040918", cliente.getCpf());
        Assertions.assertEquals("6213078", cliente.getRg());
        Assertions.assertEquals("AVENIDA RIO DE JANEIRO", cliente.getEndereco().getLogradouro());
        Assertions.assertEquals("solteiro", cliente.getEstadoCivil());
        Assertions.assertEquals("Estudante", cliente.getProfissao());
        Assertions.assertEquals("02/06/1999", cliente.getDataNascimento());
        Assertions.assertEquals("lmmendonca@gmail.com", cliente.getEmail());
    }

    @Test
    public void criaConta_validaAtributos() {
        Cliente cliente = new Cliente(
                "Leonardo", "08662040918", "6213078", endereco1, "solteiro",
                "Estudante", "02/06/1999", "lmmendonca@gmail.com");

        ContaCorrente contaCorrente = new ContaCorrente(100.0, 1, 123456, cliente);

        Assertions.assertEquals(100.0, contaCorrente.getSaldo());
        Assertions.assertEquals(1, contaCorrente.getAgencia());
        Assertions.assertEquals(123456, contaCorrente.getNumero());
        Assertions.assertEquals("Leonardo", contaCorrente.getTitular().getNome());
    }

    @Test
    public void traferencia_entre_contas() {
        ContaCorrente conta1 = new ContaCorrente(100.0, 1, 123456, this.cliente1);
        ContaCorrente conta2 = new ContaCorrente(100.0, 1, 123456, this.cliente2);

        Assertions.assertTrue(conta1.transferencia(conta2, 50));

        Assertions.assertEquals(49.8, conta1.getSaldo());
        Assertions.assertEquals(150.0, conta2.getSaldo());
    }

    @Test
    public void deposita_na_conta() {
        ContaCorrente conta1 = new ContaCorrente(100.0, 1, 123456, this.cliente1);

        conta1.deposita(50);

        Assertions.assertEquals(150.0, conta1.getSaldo());
    }

    @Test
    public void saca_da_conta() {
        ContaCorrente conta1 = new ContaCorrente(100.0, 1, 123456, this.cliente1);

        Assertions.assertTrue(conta1.saca(50));
        Assertions.assertEquals(49.8, conta1.getSaldo());
    }

    @Test
    public void tentaSacarValorMaiorQueSaldo() {
        ContaCorrente conta1 = new ContaCorrente(100.0, 1, 123456, this.cliente1);

        conta1.saca(150);

        Assertions.assertEquals(100.0, conta1.getSaldo());
        Assertions.assertFalse(conta1.saca(150));
    }

    @Test
    public void tentaTransferirValorMaiorQueSaldo() {
        ContaCorrente conta1 = new ContaCorrente(100.0, 1, 123456, this.cliente1);
        ContaCorrente conta2 = new ContaCorrente(100.0, 1, 123456, this.cliente2);

        conta1.transferencia(conta2, 200);

        Assertions.assertEquals(100.0, conta1.getSaldo());
        Assertions.assertEquals(100.0, conta2.getSaldo());
        Assertions.assertFalse(conta1.transferencia(conta2, 200));
    }

    @Test
    public void validaTributaveis() {
        ContaCorrente contaCorrente = new ContaCorrente(100, 1, 2, cliente1);
        SeguroDeVida seguroDeVida = new SeguroDeVida(SeguroDeVida.TipoSeguro.BASICO, cliente1);
        CalculadorImpostos calculadorImpostos = new CalculadorImpostos();

        calculadorImpostos.regista(seguroDeVida);
        Assertions.assertEquals(10, calculadorImpostos.getValorImposto());

        calculadorImpostos.regista(contaCorrente);
        Assertions.assertEquals(11, calculadorImpostos.getValorImposto());
    }
}
