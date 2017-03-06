package br.com.crono.dao.impl;

import javax.persistence.EntityManager;

import br.com.crono.dao.EventoDAO;
import br.com.crono.entity.Evento;

public class EventoDAOImpl 
				extends GenericDAOImpl<Evento, Integer>
					implements EventoDAO{

	public EventoDAOImpl(EntityManager em) {
		super(em);
	}
	
	

}
