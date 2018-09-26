package br.com.banco.java_util;

import br.com.banco.contas.Conta;
import br.com.banco.contas.ContaCorrente;
import br.com.banco.dados.Cliente;
import br.com.banco.dados.Endereco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TesteComparator {

    public static void main(String[] args) {
        final Endereco endereco1 = new Endereco(
                "Avenida Rio de Janeiro", "apto 601", "1635", "centro",
                "Londrina", "86010-150");

        final Cliente cliente1 = new Cliente(
                "Leonardo", "08662040918", "6213078", endereco1, "solteiro", "Estudante",
                "02/06/1999", "lmmendonca@gmail.com");

        Conta cc1 = new ContaCorrente(100, 1, 1, cliente1);
        cc1.deposita(333.0);

        Conta cc2 = new ContaCorrente(200, 2, 11, cliente1);
        cc2.deposita(444.0);

        Conta cc3 = new ContaCorrente(300, 3, 111, cliente1);
        cc3.deposita(111.0);

        Conta cc4 = new ContaCorrente(400, 4, 1111, cliente1);
        cc4.deposita(222.0);

        List<Conta> lista = new ArrayList<Conta>();
        lista.add(cc1);
        lista.add(cc2);
        lista.add(cc3);
        lista.add(cc4);

        Collections.rotate(lista, 3);



        for (Conta conta : lista) {
            System.out.println(conta.getNumero());
        }

        lista.sort(new NumeroContaComparator());

        System.out.println("-----------------");

        for (Conta conta : lista) {
            System.out.println(conta.getNumero());
        }

    }

    static class NumeroContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta o1, Conta o2) {

            return Integer.compare(o1.getNumero(), o2.getNumero());
        }
    }
}
