package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ManipuladorMetodo {
    private final Object instancia;
    private final Method metodo;
    private final Map<String, Object> params;

    public ManipuladorMetodo(Object instancia, Method metodo, Map<String, Object> params) {
        this.instancia = instancia;
        this.metodo = metodo;
        this.params = params;
    }

    public Object invoca(){
        try {
            List<Object> parametros = new ArrayList<>();
            Arrays.stream(metodo.getParameters())
                    .forEach(p -> parametros.add(params.get(p.getName())));

            return metodo.invoke(instancia, parametros.toArray());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro dentro do método", e);
        }
    }
}
