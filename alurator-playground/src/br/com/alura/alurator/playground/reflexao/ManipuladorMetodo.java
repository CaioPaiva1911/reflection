package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class ManipuladorMetodo {
    private BiFunction<Method, InvocationTargetException, Object> tratamentoExcecao;
    private final Object instancia;
    private final Method metodo;
    private final Map<String, Object> params;

    public ManipuladorMetodo(Object instancia, Method metodo, Map<String, Object> params) {
        this.instancia = instancia;
        this.metodo = metodo;
        this.params = params;
    }

    public ManipuladorMetodo comTratamentoDeExcecao(BiFunction<Method, InvocationTargetException, Object> tratamentoExcecao){
        this.tratamentoExcecao = tratamentoExcecao;
        return this;
    }

    public Object invoca(){
        List<Object> parametros = new ArrayList<>();
        Arrays.stream(metodo.getParameters())
                .forEach(p -> parametros.add(params.get(p.getName())));

        try {
            return metodo.invoke(instancia, parametros.toArray());
        } catch (IllegalAccessException | IllegalArgumentException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {

//            Tratamento especial e customizado da exceção.
            if(tratamentoExcecao != null){
                return tratamentoExcecao.apply(metodo, e);
            }
            e.printStackTrace();
            throw new RuntimeException("Erro dentro do método", e.getTargetException());
        }
    }
}
