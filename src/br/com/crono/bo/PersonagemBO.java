package br.com.crono.bo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.crono.dao.PersonagemDAO;
import br.com.crono.dao.impl.PersonagemDAOImpl;
import br.com.crono.entity.Personagem;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class PersonagemBO {
	
	//PersonagemDAO pDAO = new PersonagemDAO();
	private EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
	
	public boolean criar(Personagem p){
		
		EntityManager em = fabrica.createEntityManager();
		PersonagemDAO pDAO = new PersonagemDAOImpl(em);
		
		boolean gravado = pDAO.insert(p);
		
		em.close();
		
		if(gravado){
			return true;
		}
		return false;
	}
	
	public List<Personagem> getListaPersonagens(){
		
		EntityManager em = fabrica.createEntityManager();
		PersonagemDAO pDAO = new PersonagemDAOImpl(em);
		
		List<Personagem> lista = pDAO.selectLista();
		
		em.close();
		
		return lista;
	}	
	
	public Personagem getPersonagem(int codigo){
		
		EntityManager em = fabrica.createEntityManager();
		PersonagemDAO pDAO = new PersonagemDAOImpl(em);
		
		Personagem p = pDAO.select(codigo); 
		
		em.close();
		
		return p;
	}
	
	
	
	
	
	/******************		PARA TESTE		*******************/
	
	/*
	
	public void getTudoTeste(Connection conn) throws SQLException{
		List<Personagem> personagens = pDAO.selectListaPersonagens(conn);
		for (Personagem p : personagens) {
			System.out.println(p.getCodigo()+" "+p.getNome()+"\n");
		}
	}
	
	public String getTudo(List<Personagem> personagens){
		String s = "";
		for (Personagem p : personagens) {
			s = s.concat(p.getCodigo()+" - "+p.getNome()+"\n");
		}
		return s;
	}
	
	public int geraCodigo(){
		return getListaPersonagens().size() + 1;
	}
	
	*/
	

}
