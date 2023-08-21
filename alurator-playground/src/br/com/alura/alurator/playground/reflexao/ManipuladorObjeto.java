package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Method;

public class ManipuladorObjeto {

    private final Object instancia;

    public ManipuladorObjeto(Object instancia) {
        this.instancia = instancia;
    }

    public ManipuladorMetodo getMetodo(String nomeMetodo) {
        try {
            Method metodo = instancia.getClass().getDeclaredMethod(nomeMetodo);
            return new ManipuladorMetodo(instancia, metodo);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
