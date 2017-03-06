package br.com.crono.dao.impl;

import javax.persistence.EntityManager;

import br.com.crono.dao.KnotDAO;
import br.com.crono.entity.Knot;

public class KnotDAOImpl
				extends GenericDAOImpl<Knot, Integer>
					implements KnotDAO{

	public KnotDAOImpl(EntityManager em) {
		super(em);
	}
	
	

}
