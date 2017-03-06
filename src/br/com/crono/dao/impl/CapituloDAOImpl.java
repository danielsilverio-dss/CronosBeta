package br.com.crono.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.com.crono.dao.CapituloDAO;
import br.com.crono.entity.Capitulo;
import br.com.crono.entity.Evento;

public class CapituloDAOImpl 
				extends GenericDAOImpl<Capitulo, Integer> 
					implements CapituloDAO{

	public CapituloDAOImpl(EntityManager em) {
		super(em);
	}
	
	
	@Override
	public Capitulo select(Integer codigo) {
		
		Capitulo c = super.select(codigo);
		
		c.setEventos(buscaEventosDoCapitulo(c));
		
		return c;
	}




	public List<Evento> buscaEventosDoCapitulo(Capitulo c){
		
		
		List<Evento> eventos = new ArrayList<>();
		
		EntityManager em = getEm();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Evento> cq = cb.createQuery(Evento.class);
		
		cq.from(Evento.class);

		eventos = em.createQuery(cq).getResultList();
		
		List<Evento> eventosCapitulo = new ArrayList<>();
		
		
		for (Evento evento : eventos) {
			if(evento.getCodigo() == c.getCodigo()){
				eventosCapitulo.add(evento);
			}
		}
		
		
		/*
		
		Root<Evento> e = cq.from(Evento.class);
		
		ParameterExpression<Integer> p = cb.parameter(Integer.class);
		
		cq.select(e).where(cb.gt(e.get("codigo"), p));
		
		
		
		TypedQuery<Evento> query = em.createQuery(cq);
		query.setParameter(p, c.getCodigo());
		eventos = query.getResultList();
		
		eventos = em.createQuery(cq).getResultList();
		
		*/

		
		
		return eventosCapitulo;
		
	}
	

}
