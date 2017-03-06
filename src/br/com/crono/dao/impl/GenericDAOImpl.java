package br.com.crono.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.com.crono.dao.GenericDAO;

public class GenericDAOImpl<T,K> implements GenericDAO<T, K>{

	private EntityManager em;
	
	private Class<T> clazz;
	
	@SuppressWarnings("all")
	public GenericDAOImpl(EntityManager em) {
		clazz = (Class<T>) ((ParameterizedType)getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		this.em = em;
	}
	
	@Override
	public boolean insert(T entidade) {

		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
		
		return true;
	}

	@Override
	public T select(K codigo) {
		
		return em.find(clazz, codigo);
	}

	@Override
	public List<T> selectLista() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(clazz);
		
		cq.from(clazz);
		
		List<T> lista = em.createQuery(cq).getResultList();
		

		return lista;
	}

	@Override
	public void delete(K codigo) {

		T entidade = select(codigo);
		
		// fazer lógica if entidade == null lançar exception
		
		em.getTransaction().begin();
		em.remove(entidade);
		em.getTransaction().commit();
		
	}
	
	protected EntityManager getEm() {
		return em;
	}

	protected void setEm(EntityManager em) {
		this.em = em;
	}

	protected Class<T> getClazz() {
		return clazz;
	}

	protected void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}
	

}
