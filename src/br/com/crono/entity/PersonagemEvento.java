package br.com.crono.entity;

public class PersonagemEvento {
	
	
	/*
	 * 
	 * 
	 * 			INATIVO
	 * 
	 * 
	 */
	
	private int codigoPersonagem;
	private int codigoEvento;
	
	public PersonagemEvento() {}
	
	public PersonagemEvento(int codigoPersonagem, int codigoEvento) {
		super();
		this.codigoPersonagem = codigoPersonagem;
		this.codigoEvento = codigoEvento;
	}

	public int getCodigoPersonagem() {
		return codigoPersonagem;
	}

	public void setCodigoPersonagem(int codigoPersonagem) {
		this.codigoPersonagem = codigoPersonagem;
	}

	public int getCodigoEvento() {
		return codigoEvento;
	}

	public void setCodigoEvento(int codigoEvento) {
		this.codigoEvento = codigoEvento;
	}
	
	

}
