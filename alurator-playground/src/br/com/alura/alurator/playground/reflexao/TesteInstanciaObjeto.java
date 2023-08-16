package br.com.alura.alurator.playground.reflexao;

import br.com.alura.alurator.playground.controle.Controle;
import br.com.alura.alurator.playground.controle.SubControle;

import java.io.IOException;

public class TesteInstanciaObjeto {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        // url -> /controle/lista

        Class<Controle> controleClass1 = Controle.class;

        Controle controle = new Controle();
        Class<? extends Controle> controleClass2 = controle.getClass();

        Class<?> controleClasse3 = Class.forName("br.com.alura.alurator.playground.controle.Controle");

        Controle objetoControle = controleClass1.newInstance();

        Object outroObjetoControle = controleClasse3.newInstance();

        System.out.println(objetoControle instanceof Controle);

        System.out.println(outroObjetoControle instanceof Controle);
    }
}
