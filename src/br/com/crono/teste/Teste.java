package br.com.crono.teste;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import br.com.crono.bo.CapituloBO;
import br.com.crono.bo.EventoBO;
import br.com.crono.dao.CapituloDAO;
import br.com.crono.dao.impl.CapituloDAOImpl;
import br.com.crono.entity.Capitulo;
import br.com.crono.entity.Evento;
import br.com.crono.entity.Personagem;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) throws ClassNotFoundException {
		
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		CapituloDAO cDAO = new CapituloDAOImpl(em);
		
		//Capitulo c = cDAO.select(1);
		
		/*
		
		CapituloBO cBO = new CapituloBO();
		
		Capitulo c = cBO.buscaCapitulo(1);
		
		System.out.println(c.getCodigo());
		System.out.println(c.getNome());
		System.out.println(c.getDescricao());

		List<Evento> eventos = c.getEventos();
		
		for (Evento evento : eventos) {
			System.out.println(evento.getCodigo());
			System.out.println(evento.getNome());
			System.out.println(evento.getDescricao());
			System.out.println(evento.getCapitulo());
		}
		
		*/
		
		EventoBO eBO = new EventoBO();
		
		Evento e = eBO.getEvento(1);
		
		Set<Personagem> env = e.getSetEnvolvidos();
		
		System.out.println(e.getNome());
		
		for (Personagem personagem : env) {
			System.out.println(personagem.getCodigo());
			System.out.println(personagem.getNome());
		}
		
		
		/*
		
		PersonagemDAO pDAO = new PersonagemDAOImpl(em);
		
		Personagem p = new Personagem();
		
		p.setCodigo(0);
		p.setDescricao("descricao do personagem");
		p.setEventos(null);
		p.setNome("nome do personagem");
		
		
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		
		//pDAO.insert(p);
		
		
		
		em.close();
		
		*/
		
		System.exit(0);
		

		/*

		CapituloBO cBO = new CapituloBO();
		EventoBO eBO = new EventoBO();

		eBO.getEvento(31);
		System.out.println("ok1");

		eBO.deletar(31);
		System.out.println("ok");

		*/
		
//		Connection conn = null;
		
		
		
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			
//			conn = ConnectionFactory.controlarInstancia().getConnection();
			
			
//			conn.close();
			/*
			
			List<Capitulo> capitulos = cBO.getListaCapitulo(conn);
			
			for (Capitulo c : capitulos) {
				System.out.println(c.getCodigo());
				System.out.println(c.getNome());
				System.out.println(c.getDescricao());
				
			}
			*/
			/*
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
		/*
		
		Capitulo c = new Capitulo();
		
		c.setCodigo(1);
		c.setNome("O Aguia do Mar");
		c.setDescricao("Primeiro capitulo do livro");
		
		
		
		String url = "jdbc:oracle:thin:/:@oracle.fiap.com.br:1521:ORCL";
		String user = "OPS$RM76747";
		String password = "280895";
		
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		CapituloDAO cDAO = new CapituloDAO();
		
		try {
			Connection conn = DriverManager.getConnection(url,user,password);
			cDAO.insertCapitulo(conn, c);
			System.out.println(cDAO.getCapitulo(conn, 1).toString());
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		System.out.println("Conectado!");
		
		*/
		
		/*
		List<Personagem> list = new ArrayList<>();
		
		for (int i = 0; i < 2; i++) {
			Personagem p = new Personagem(
					i,
					"n",
					"d"
					);
			list.add(p);
		}
		System.out.println(
			"\n"+list.get(0).getCodigo()
			+"\n"+list.get(0).getDescricao()
			+"\n"+list.get(0).getNome()
			+"\n"+list.get(1).getCodigo()
			+"\n"+list.get(1).getDescricao()
			+"\n"+list.get(1).getNome()
		);
		*/

	}

}
