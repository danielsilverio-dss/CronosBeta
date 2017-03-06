package br.com.crono.dao;

import br.com.crono.entity.Capitulo;

public interface CapituloDAO extends GenericDAO<Capitulo, Integer>{
	
	@Override
	public Capitulo select(Integer codigo);
	
}
