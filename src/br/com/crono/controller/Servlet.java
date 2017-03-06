package br.com.crono.controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crono.bo.CapituloBO;
import br.com.crono.bo.EventoBO;
import br.com.crono.bo.PersonagemBO;
import br.com.crono.entity.Capitulo;
import br.com.crono.entity.Evento;
import br.com.crono.entity.Personagem;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		
		switch (page) {
		case "cronograma.jsp":
			chamaCronograma(request, response);
			break;
		case "cadastrarCapitulo.jsp":
			chamaCadastrarCapitulo(request, response);
			break;
			
		case "personagem.jsp":
			chamaPersonagem(request, response);
			break;
			
		case "eventos.jsp":
			chamaPaginaEventos(request, response);
			break;
		case "none":
			chamaFuncao(request, response);
			break;
		default:
			break;
		}
		
		
		
		
		
	}
	
	private void chamaFuncao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String funcao = request.getParameter("funcao");
		
		switch(funcao){
		case "excluir":
			excluirEvento(request, response);
			break;
			
		default:
			break;
		}
		
	}
	
	private void excluirEvento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EventoBO eBO = new EventoBO();
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		
		eBO.deletar(codigo);
				
		chamaCronograma(request, response);
		
	}

	private void chamaPaginaEventos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CapituloBO cBO = new CapituloBO();
		PersonagemBO pBO = new PersonagemBO();
		
		List<Capitulo> capitulos = new ArrayList<>();
		List<Personagem> personagens = new ArrayList<>();
		
		capitulos = cBO.getListaCapitulo();
		personagens = pBO.getListaPersonagens();
		
		request.setAttribute("capitulos", capitulos);
		request.setAttribute("personagens", personagens);
		
		String page = request.getParameter("page");
		request.setAttribute("page", page);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}



	private void chamaPersonagem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = request.getParameter("page");
		request.setAttribute("page", page);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}



	private void chamaCadastrarCapitulo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = request.getParameter("page");
		request.setAttribute("page", page);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
	}



	private void chamaCronograma(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		CapituloBO cBO = new CapituloBO();
		
		List<Capitulo> capitulos = new ArrayList<>();
		
		capitulos = cBO.getListaCapitulo();
		
		
		
		request.setAttribute("listaCapitulos", capitulos);
		
		String page = request.getParameter("page");
		request.setAttribute("page", page);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String origem = request.getParameter("origem");
		
		
		
		switch (origem) {
		case "cadastrarCapitulo.jsp":
			try {
				
				cadastrarCapitulo(request,response);
				
				
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
			
		case "personagem.jsp":
			
			cadastrarPersonagem(request, response);
		
			break;
		case "eventos.jsp":
			
			cadastrarEvento(request, response);
			
			break;

		default:
			break;
		}
	}

	protected void cadastrarEvento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = 			request.getParameter("nome");
		String descricao = 		request.getParameter("descricao");
		int codigoCapitulo =  	Integer.parseInt(request.getParameter("capitulo"));
		
		String msg = request.getParameter("contador");
		int contador = Integer.parseInt(request.getParameter("contador"));
		
		
		
		CapituloBO cBO = new CapituloBO();
		
		Capitulo c = new Capitulo();
		
		c = cBO.buscaCapitulo(codigoCapitulo);

		Set<Personagem> envolvidos = new HashSet<>();
		
		PersonagemBO pBO = new PersonagemBO();
		
		System.out.println("contador: " + contador);
		
		for (int i = 0; i <= contador; i++) {
			String nomeParametro = "personagem"+(i);
			int codigoPersonagem = Integer.parseInt(request.getParameter(nomeParametro));
			
			envolvidos.add(pBO.getPersonagem(codigoPersonagem));
				
		}
		
		Evento e = new Evento();
		e.setNome			(nome);
		e.setDescricao		(descricao);
		e.setCapitulo		(c);
		e.setSetEnvolvidos	(envolvidos);
		
		System.out.println("Servlet - Evento: " + e.toString());
		
		EventoBO eBO = new EventoBO();
		
		eBO.criar(e);
				
		
		
		
		request.setAttribute("msg", msg);
		
		chamaPaginaEventos(request, response);
		
	}
	
	protected void cadastrarPersonagem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		
		Personagem p = new Personagem();
		p.setNome(nome);
		p.setDescricao(descricao);
		
		PersonagemBO pBO = new PersonagemBO();
		
		String msg = new String();
		
		if(pBO.criar(p)){
			msg = "Gravado com sucesso!";
		}else{
			msg = "Erro ao gravar!";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("page", "personagem.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	private void cadastrarCapitulo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = factory.createEntityManager();
		
		CapituloBO cBO = new CapituloBO();
		
		int numero = Integer.parseInt(request.getParameter("numero"));
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		
		Capitulo c = new Capitulo(
				numero,
				nome,
				descricao
				);
		
		
		String msg = new String();
		
		msg = cBO.gravarCapitulo(c);
		
		em.close();
		
		request.setAttribute("msg", msg);
		request.setAttribute("page", "cadastrarCapitulo.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}
	

}
