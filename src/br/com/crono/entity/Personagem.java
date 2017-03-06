package br.com.crono.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_CRN_PER")
@SequenceGenerator(name="seqPersonagem", sequenceName="SQ_T_CRONOS_PERSONAGEM", allocationSize=1)
public class Personagem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqPersonagem")
	@Column(name="cd_personagem")
	private int codigo;
	
	@Column(name="ds_nome")
	private String nome;
	
	@Column(name="ds_descricao")
	private String descricao;
	
	@ManyToMany(targetEntity=Evento.class)
	private List<Evento> eventos;
	
	//private List<Knot> knots;
	
	/*
	public Personagem(int codigo, String nome, String descricao, List<Evento> eventos, List<Knot> knots) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.eventos = eventos;
		this.knots = knots;
	}
	*/
	
	public Personagem(int codigo, String nome, String descricao, List<Evento> eventos) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.eventos = eventos;
	}
	
	public Personagem(int codigo, String nome, String descricao) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Personagem() {
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
	
	public String toString() {
		return "Personagem [codigo=" + codigo + ", nome=" + nome + ", descricao=" + descricao + "]";
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
