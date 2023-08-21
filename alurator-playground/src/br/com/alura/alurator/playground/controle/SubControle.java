package br.com.alura.alurator.playground.controle;

import java.io.IOException;

public class SubControle extends Controle{
    private SubControle() throws IOException {
    }

    private SubControle(String s) throws IOException{}

    public void metodoSubControle1(){
        System.out.println("Executando método Subcontrole.metodoSubControle1()");
    }

    private String metodoSubControle2() {
        System.out.println("Executando método Subcontrole.metodoSubControle2()");
        return "retorno do método Subcontrole.metodoSubControle2()";
    }
}
