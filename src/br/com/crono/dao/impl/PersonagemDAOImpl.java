package br.com.crono.dao.impl;

import javax.persistence.EntityManager;

import br.com.crono.dao.PersonagemDAO;
import br.com.crono.entity.Personagem;

public class PersonagemDAOImpl 
				extends GenericDAOImpl<Personagem, Integer>
					implements PersonagemDAO{

	public PersonagemDAOImpl(EntityManager em) {
		super(em);
	}
	
	

}
