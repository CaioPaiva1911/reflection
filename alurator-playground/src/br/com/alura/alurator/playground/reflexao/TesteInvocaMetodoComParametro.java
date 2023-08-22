package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TesteInvocaMetodoComParametro {
    public static void main(String[] args) throws Exception {

        Class<?> controleClass = Class.forName("br.com.alura.alurator.playground.controle.Controle");

        Constructor<?> construtorPadrao = controleClass.getDeclaredConstructor();
        construtorPadrao.setAccessible(true);

        Object controle = construtorPadrao.newInstance();

        System.out.println();
        Method m = controleClass.getDeclaredMethod("metodoControle2", String.class, Integer.class);
        m.setAccessible(true);
        Object retorno = m.invoke(controle, "Pintassilgo do Agreste", 1);

        System.out.println(retorno);
    }
}
