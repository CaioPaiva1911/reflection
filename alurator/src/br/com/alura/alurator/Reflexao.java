package br.com.alura.alurator;

public class Reflexao {

    public ManipuladorClasse refleteClasse(String fqn) {
        try {
            Class<?> classe = Class.forName(fqn);

            return new ManipuladorClasse(classe);
        } catch (ClassNotFoundException e) {
            e.getStackTrace();
            throw new RuntimeException(e);
        }
    }
}
