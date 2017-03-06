package br.com.crono.teste;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.crono.bo.CapituloBO;
import br.com.crono.bo.EventoBO;
import br.com.crono.bo.PersonagemBO;
import br.com.crono.entity.Capitulo;
import br.com.crono.entity.Evento;
import br.com.crono.entity.Personagem;

public class Cronomante {

	public static void main(String[] args) {
		
		
		
		/*
		 * 		Funções:
		 * 
		 * 1. Cadastrar
		 * 2. Consultar
		 * 
		 * 		Observações:
		 * 
		 * 1. Knots foram temporariamente desabilitados
		 * 
		 * 
		 */
		/********
		 
		PersonagemBO pBO = new PersonagemBO();
		CapituloBO cBO = new CapituloBO();
		EventoBO eBO = new EventoBO();
		

		do{
			
		int resposta = Integer.parseInt(JOptionPane.showInputDialog("O que deseja fazer?"
				+"\n 1 - Criar personagem"
				+"\n 2 - Criar capítulo"
				+"\n 3 - Criar evento"
				+"\n 4 - Ver cronograma"
				+"\n 5 - Ver personagem"
				+"\n 6 - Teste imprimir"
				+"\n 7 - Ver evento"
				));
		
		
		switch (resposta) {
		case 1:
			instanciaPersonagem(pBO);
			break;
		case 2:
			instanciaCapitulo(cBO);
			break;
		case 3:
			instanciaEvento(eBO, pBO, cBO);
			break;
		case 4:
			consultarCronograma(cBO, eBO);
			break;
		case 5:
			
			break;
		case 6:
			
			System.out.println(pBO.getTudo(pBO.getListaPersonagens()));
			break;
		case 7:
			
			break;

		default:
			break;
		}
		
		}while(confirmOperacoes() != 1);

	}
	
	
	
	public static void instanciaPersonagem(PersonagemBO pBO){
		
		Personagem p = new Personagem(
				pBO.geraCodigo(),
				JOptionPane.showInputDialog("nome"),
				JOptionPane.showInputDialog("descrição")
				);
		pBO.criar(p);
	}
	
	public static void instanciaCapitulo(CapituloBO cBO){
		
		Capitulo c = new Capitulo(
				cBO.geraCodigo(),
				JOptionPane.showInputDialog("nome"),
				JOptionPane.showInputDialog("descrição")
				);
		
		cBO.criar(c);
	}
	
	public static void instanciaEvento(EventoBO eBO, PersonagemBO pBO,CapituloBO cBO){
		
		List<Personagem> envolvidos = new ArrayList<>();
		int resp = 0;
		do{
			int codigoPersonagem = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do personagem envolvido no evento:"
					+"\n"+pBO.getTudo(pBO.getListaPersonagens())
							+"\n"+pBO.getListaPersonagens().size()));
			
			envolvidos.add(pBO.retornaPersonagem(codigoPersonagem));
			resp = confirmRelacionarPersonagem();
		}while(resp == 0);
		
		
		
		
		int codigoCapitulo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do capítulo envolvido no evento:"
				+"\n"+cBO.getTudo()));
				
		Capitulo capitulo = cBO.retornaCapitulo(codigoCapitulo);
		
		
		
		Evento e = new Evento(
				eBO.geraCodigo(),
				JOptionPane.showInputDialog("Descrição do evento:"),
				capitulo,
				envolvidos
				);
		
		eBO.criar(e);
		
	}
	
	public static void consultarCronograma(CapituloBO cBO, EventoBO eBO){
		
		for (Capitulo c : cBO.getListaCapitulo()) {
			System.out.println("**********************************");
			System.out.println("**********************************\n");
			System.out.println(c.getCodigo()+" - "+c.getNome());
			System.out.println();
			if(c.getDescricao()!=null){
				System.out.println(c.getDescricao());
			}
			for (Evento e : eBO.getListaEvento()) {
				if(e.getCapitulo().getCodigo() == c.getCodigo()){
					System.out.println("*** Evento ***");
					System.out.println(eBO.getTudo(e));
					System.out.println("Personagens envolvidos: ");
					System.out.println(eBO.getEnvolvidos(e));					
				}
			}
			System.out.println();
			
		}
		
		*********/
	}
	
	/*********** métodos auxiliares ***************/
	
	public static int confirmOperacoes(){
		return JOptionPane.showConfirmDialog(null, "Deseja realizar mais alguma operação?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	}
	
	public static int confirmRelacionarPersonagem(){
		return JOptionPane.showConfirmDialog(null, "Deseja adicionar mais algum personagem?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	}

}
