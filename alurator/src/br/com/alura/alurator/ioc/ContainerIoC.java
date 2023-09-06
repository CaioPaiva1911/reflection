package br.com.alura.alurator.ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.stream.Stream;

public class ContainerIoC {

    private final Map<Class<?>, Class<?>> mapaDeTipos = new HashMap<>();

    public Object getInstancia(Class<?> tipoFonte){
        Class<?> tipoDestino = mapaDeTipos.get(tipoFonte);
        if(tipoDestino != null){
            return getInstancia(tipoDestino);
        }

        Stream<Constructor<?>> construtores =
                Stream.of(tipoFonte.getConstructors());

        Optional<Constructor<?>> construtorPadrao =
                construtores.filter(construtor -> construtor.getParameterCount() == 0)
                        .findFirst();

        try {

            if(construtorPadrao.isPresent()){
                return construtorPadrao.get().newInstance();
            } else{
                Constructor<?> construtor = tipoFonte.getDeclaredConstructors()[0];

                List<Object> params = new ArrayList<>();
                for (Parameter param : construtor.getParameters()){
                    Class<?> tipoDoParametro = param.getType();
                    params.add(getInstancia(tipoDoParametro));
                }
                return construtor.newInstance(params.toArray());
            }

        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public <T, K extends T>void registra(Class<T> tipoFonte, Class<K> tipoDestino) {
        mapaDeTipos.put(tipoFonte, tipoDestino);
    }
}
