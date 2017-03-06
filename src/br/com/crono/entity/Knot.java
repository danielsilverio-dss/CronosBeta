package br.com.crono.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

/*
 * 
 * 
 * 
 * 			A Classe Knot ainda não está em uso, mas será implementada futuramente
 * 			para relacionar um evento a outro, sugerindo que um evento possa ter como
 * 			consequência um outro evento subsequente relacionado a ele no futuro. 
 * 
 * 			Exemplo:
 * 
 * 			Evento 1: Personagem João roubou a chave para o tesouro de José.
 * 			Evento 2: (muitos capítulos depois) João chantagia José usando a chave do seu tesouro.
 * 
 * 			O Knot faria a conexão entre um evento e outro, mas é um conceito complexo de ser aplicado
 * 			e ainda precisa ser mais estudado.
 * 
 * 	
 * 
 * 
 */

//@Entity
public class Knot {
	
	private int codigo;
	private String descricao;
	private Date data;
	private Date hora;
	private Capitulo capitulo;
	private List<Personagem> envolvidos;
	private List<Evento> evenEnvolvidos;
	
	public Knot(int codigo, String descricao, Date data, Date hora, List<Personagem> envolvidos,
			List<Evento> aconEnvolvidos) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.data = data;
		this.hora = hora;
		this.envolvidos = envolvidos;
		this.evenEnvolvidos = aconEnvolvidos;
	}
	
	public Knot(int codigo, String descricao, Capitulo capitulo) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.capitulo = capitulo;
	}



	public Knot() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public List<Personagem> getEnvolvidos() {
		return envolvidos;
	}

	public void setEnvolvidos(List<Personagem> envolvidos) {
		this.envolvidos = envolvidos;
	}

	public List<Evento> getAconEnvolvidos() {
		return evenEnvolvidos;
	}

	public void setAconEnvolvidos(List<Evento> aconEnvolvidos) {
		this.evenEnvolvidos = aconEnvolvidos;
	}

	public Capitulo getCapitulo() {
		return capitulo;
	}

	public void setCapitulo(Capitulo capitulo) {
		this.capitulo = capitulo;
	}
	
	

}
