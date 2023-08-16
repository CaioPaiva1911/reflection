package br.com.alura.alurator;

import java.lang.reflect.Constructor;

public class ManipuladorClasse {

    private Class<?> classe;

    public ManipuladorClasse(Class<?> classe) {
        this.classe = classe;
    }

    public ManipuladorConstrutor getConstrutorPadrao() {
        try {
            Constructor<?> construtorPadrao = classe.getDeclaredConstructor();
            return new ManipuladorConstrutor(construtorPadrao);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
