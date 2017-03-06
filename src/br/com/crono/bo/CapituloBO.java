package br.com.crono.bo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.crono.dao.CapituloDAO;
import br.com.crono.dao.impl.CapituloDAOImpl;
import br.com.crono.entity.Capitulo;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class CapituloBO {
	

	//private CapituloDAO cDAO; 
	private EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
	
	
	public CapituloBO(){}
	
	
	
	public String gravarCapitulo(Capitulo c){
		
		EntityManager em = fabrica.createEntityManager();
		CapituloDAO cDAO = new CapituloDAOImpl(em);
		
		boolean gravado = cDAO.insert(c);
		
		em.close();
		
		if(verificaCodigo(c.getCodigo()))
				return "Já existe um capítulo com esse número!";
		
		else if(gravado)
				return "Gravado com sucesso!";
		
		else
				return "Falha ao gravar.";
	}
	
	
	public Capitulo buscaCapitulo(int codigo){
		
		EntityManager em = fabrica.createEntityManager();
		CapituloDAO cDAO = new CapituloDAOImpl(em);
		
		Capitulo c = cDAO.select(codigo); 
		
		
		
		em.close();
		
		return c;
	}
	
	
	
	public List<Capitulo> getListaCapitulo(){
		
		EntityManager em = fabrica.createEntityManager();
		CapituloDAO cDAO = new CapituloDAOImpl(em);
		
		List<Capitulo> lista = ordenaLista(cDAO.selectLista()); 
		
		em.close();
		
		return lista;
		
	}
	
	public List<Capitulo> ordenaLista(List<Capitulo> capitulos){
		
		Collections.sort(capitulos, new Comparator<Capitulo>() {
			@Override
			public int compare(Capitulo a, Capitulo b) {
				if(a.getCodigo() > b.getCodigo())
					return 1;
				else if(a.getCodigo() < b.getCodigo())
					return -1;
				else
					return 0;
			}
			
		});
		
		return capitulos;
		
	}
	
	public String getTudo(){
		
		EntityManager em = fabrica.createEntityManager();
		CapituloDAO cDAO = new CapituloDAOImpl(em);		
		
		String s = "";
		for (Capitulo c : cDAO.selectLista()) {
			s = s.concat(c.getCodigo()+" - "+c.getNome()+"\n");
		}
		
		em.close();
		
		return s;
	}
	
	//verifica se é o código já existe 
	public boolean verificaCodigo(int codigo){
		List<Capitulo> c = getListaCapitulo();
		for (Capitulo capitulo : c) {
			if (capitulo.getCodigo() == codigo) {
				return true;
			}
		}
		return false;
	}

}
