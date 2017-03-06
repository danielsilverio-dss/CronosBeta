package br.com.crono.bo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.crono.dao.EventoDAO;
import br.com.crono.dao.impl.EventoDAOImpl;
import br.com.crono.entity.Evento;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class EventoBO {
	
	private EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
	
	public String criar(Evento e){
		
		EntityManager em = fabrica.createEntityManager();
		EventoDAO eDAO = new EventoDAOImpl(em);
		
		boolean gravado = eDAO.insert(e); 
		
		em.close();
		
		if(gravado){
			
			return "Gravado com sucesso!";
			
		}
		
		return "Erro ao gravar!";
		
	}
	
	public List<Evento> getListaEventos(){
		
		EntityManager em = fabrica.createEntityManager();
		EventoDAO eDAO = new EventoDAOImpl(em);
		
		List<Evento> lista = eDAO.selectLista(); 
		
		em.close();
		
		return lista;
	}
	
	public Evento getEvento(int codigo){
		
		EntityManager em = fabrica.createEntityManager();
		EventoDAO eDAO = new EventoDAOImpl(em);
		
		Evento e = eDAO.select(codigo);
		
		em.close();
		
		return e;
	}
	
	public boolean deletar(int codigo){
		
		EntityManager em = fabrica.createEntityManager();
		EventoDAO eDAO = new EventoDAOImpl(em);
		
		eDAO.delete(codigo);
		
		em.close();

		return true;
		
	}
		
	
	/******************		PARA TESTE		*******************/
	
	/*
	
	public List<Personagem> getListaEnvolvidos(Evento e){
		return e.getEnvolvidos();
	}
	
	public int geraCodigo(){
		return getListaEvento().size() + 1;
	}
	
	public String getEnvolvidos(Evento e){

		String s = "";
		
		for (Personagem p : e.getEnvolvidos()) {
			s = s.concat(p.getNome());
		}
		return s;
	}
		
	public String getTudo(Evento e){
		return e.getDescricao()+"\n"+e.getCapitulo().getDescricao();
	}
	
	
	*/

}
