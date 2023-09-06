package br.com.alura.alurator;

public class Reflexao {

    public ManipuladorClasse refleteClasse(String fqn) {
        Class<?> classe = getClasse(fqn);
        return new ManipuladorClasse(classe);
    }

    public Class<?> getClasse(String fqn) {
        try {
            return Class.forName(fqn);
        } catch (ClassNotFoundException e) {
            e.getStackTrace();
            throw new RuntimeException(e);
        }
    }
}
