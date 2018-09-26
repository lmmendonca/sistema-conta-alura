package br.com.banco.java_util;

import br.com.banco.contas.Conta;
import br.com.banco.contas.ContaCorrente;
import br.com.banco.dados.Cliente;
import br.com.banco.dados.Endereco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class ClassesAnonimas {

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


        Collections.shuffle(lista);

        lista.forEach((conta -> System.out.println(conta.getNumero())));

        //Lambdas
        lista.sort(((o1, o2) -> Integer.compare(o1.getNumero(), o2.getNumero())));


        System.out.println("------------------------------------------------");


        //ForEach com lambdas
        lista.forEach((conta -> System.out.println(conta.getNumero())));




//        for (Conta conta : lista) {
//            System.out.println(conta.getNumero());
//        }


//        Comparator<String> comp = new Comparator<String>() {
//
//            @Override
//            public int compare(String s1, String s2) {
//                return s1.compareTo(s2);
//            }
//        };

        lista.forEach(conta -> System.out.println(conta.getTitular().getNome()));


        System.out.println("-----------ITERATOR-------------");

        Iterator<Conta> it = lista.iterator();

        while (it.hasNext()) {
            System.out.println(it.next().getNumero());
        }

        System.out.println("------------------------");


        Set<String> nomes = new HashSet<>();
        nomes.add("Super Mario");
        nomes.add("Yoshi");
        nomes.add("Donkey Kong");

        Iterator<String> it1 = nomes.iterator();

        while(it1.hasNext()) {
            System.out.println(it1.next());
        }
    }


}
