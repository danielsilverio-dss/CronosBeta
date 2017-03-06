package br.com.crono.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_CRN_EVE")
@SequenceGenerator(name="seqEvento", sequenceName="SQ_T_CRONOS_EVENTO", allocationSize=1)
public class Evento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqEvento")
	@Column(name="cd_evento")
	private int 	 codigo;
	
	@Column(name="ds_nome")
	private String	 nome;
	
	@Column(name="ds_descricao")
	private String 	 descricao;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_data", nullable=true)
	private Date 	 data;
	
	@Temporal(TemporalType.TIME)
	@Column(name="dt_hora", nullable=true)
	private Date 	 hora;
	
	@ManyToOne
	private Capitulo capitulo;
	
	@ManyToMany(targetEntity=Personagem.class)
	private Set<Personagem> setEnvolvidos;
	
	public Evento(int codigo, String descricao, Date data, Date hora, Set<Personagem> setEnvolvidos) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.data = data; 
		this.hora = hora; 
		this.setEnvolvidos = setEnvolvidos;
	}
	
	public Evento(int codigo, String descricao, Capitulo capitulo, Set<Personagem> setEnvolvidos) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.capitulo = capitulo;
		this.setEnvolvidos = setEnvolvidos;
	}
	
	public Evento(int codigo, String nome, String descricao) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Evento(int codigo, String descricao, Capitulo capitulo) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.capitulo = capitulo;
	}

	public Evento() {
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

	public Capitulo getCapitulo() {
		return capitulo;
	}

	public void setCapitulo(Capitulo capitulo) {
		this.capitulo = capitulo;
	}

	public Set<Personagem> getSetEnvolvidos() {
		return setEnvolvidos;
	}

	public void setSetEnvolvidos(Set<Personagem> setEnvolvidos) {
		this.setEnvolvidos = setEnvolvidos;
	}

	@Override
	public String toString() {
		return "Evento [codigo=" + codigo + ", nome=" + nome + ", descricao=" + descricao + ", codigo capitulo=" + capitulo.getCodigo()
				+ ", envolvidos=" + envolvidosToString() + "]";
	}
	
	public String envolvidosToString(){
		String s = new String();
		
		for (Personagem p : setEnvolvidos) {
			s = s + p.toString();
		}
		
		return s;
	}
	

}
