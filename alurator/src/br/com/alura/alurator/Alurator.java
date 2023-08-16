package br.com.alura.alurator;

import br.com.alura.alurator.protocolo.Request;

public class Alurator {

	private String pacoteBase;

	public Alurator(String pacoteBase){
		this.pacoteBase = pacoteBase;
	}
	
	public Object executa(String url){
		// TODO - processa a requisicao executando o metodo
		// da classe em questao

		// /produto/lista
		Request request = new Request(url);

		String nomeControle = request.getNomeControle();

		Object instaciaControle = new Reflexao()
				.refleteClasse(pacoteBase + nomeControle)
				.getConstrutorPadrao()
				.invoca();

		System.out.println(instaciaControle);

		return null;

    }
}
