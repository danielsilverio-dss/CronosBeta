package br.com.crono.dao;

import java.util.List;

public interface GenericDAO<T,K> {
	
	boolean insert(T entidade);
	
	T select(K codigo);
	
	List<T> selectLista();
	
	//criar update
		
	void delete(K codigo);

	// Criar um TransferObject para o PersonagemEvento



}
