package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ManipuladorMetodo {
    private final Object instancia;
    private final Method metodo;

    public ManipuladorMetodo(Object instancia, Method metodo) {
        this.instancia = instancia;
        this.metodo = metodo;
    }

    public Object invoca(){
        try {
            return metodo.invoke(instancia);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro dentro do método", e);
        }
    }
}
