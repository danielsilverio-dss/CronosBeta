package br.com.crono.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="T_CRN_CAP")
public class Capitulo {
	
	@Id
	@Column(name="cd_capitulo")
	private int codigo;
	
	@Column(name="ds_nome")
	private String nome;
	
	@Column(name="ds_descricao", nullable=true)
	private String descricao; //opcional
	
	@Transient
	private List<Evento> eventos;
	
	
	
	//private List<Knot> knots;
	
	//Construtor principal
	public Capitulo(int codigo, String nome) {
			super();
			this.codigo = codigo;
			this.nome = nome;
		}
	
	/*
	public Capitulo(int codigo, String nome, String descricao, List<Evento> eventos, List<Knot> knots) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.eventos = eventos;
		this.knots = knots;
	}
	
	*/
	
	public Capitulo(int codigo, String nome, String descricao, List<Evento> eventos) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.eventos = eventos;
	}
	
	

	public Capitulo(int codigo, String nome, String descricao) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Capitulo() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	@Override
	public String toString() {
		return "Capitulo [codigo=" + codigo + ", nome=" + nome + ", descricao=" + descricao 
				+ "]";
	}

	
	/*
	public List<Knot> getKnots() {
		return knots;
	}

	public void setKnots(List<Knot> knots) {
		this.knots = knots;
	}
	*/

}
