package br.com.alura.alurator.playground.controle;

import javax.naming.ldap.Control;
import java.io.IOException;
import java.util.List;

public class Controle {
	private List<String> lista = List.of("item 1", "item 2", "item 3");

	public Controle() throws IOException {
		throw new IOException();
	}

	public Controle(String s) {}

	private Controle(String s, String t){}
	
	public List<String> getLista() {
		return lista;
	}
}
