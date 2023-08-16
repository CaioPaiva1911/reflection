package br.com.alura.alurator.playground.reflexao;

import br.com.alura.alurator.playground.controle.SubControle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TesteInstanciaObjetosCoretamente {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        Class<SubControle> subControleClass1 = SubControle.class;

        Class<?> subControleClasse2 =
                Class.forName("br.com.alura.alurator.playground.controle.SubControle");

        Class<?> controleClasse1 =
                Class.forName("br.com.alura.alurator.playground.controle.Controle");

        try {
            controleClasse1.getDeclaredConstructor().newInstance();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            System.out.println(e.getTargetException());
        }



        /*Constructor<?> constructorSubControle = subControleClasse1.getDeclaredConstructor();

        System.out.println(constructorSubControle);
        constructorSubControle.setAccessible(true);


        Object subControle = constructorSubControle;
         */
    }
}
