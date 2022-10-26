package main.controller;

import java.util.LinkedList;
import java.util.List;
import main.model.DAO.*;
import main.model.entities.*;



public class MenuController {
	/**
	 * Função que coloca a primeira letra de cada palavra em maiúscula.
	 * @param nome Nome que vai ser usado.
	 * @return Uma String com a primeira letra de cada palavra em maiúsculo.
	 */
	

	/**
	 * Função que mostra os grupos que as seleções podem estar.
	 */
	

	
	/**
	 * Função que pega uma lista de Strings e printa elas com um número do lado.
	 * @param lista A lista de Strings que será utilizada.
	 */
	

	
	/**
	 * Função que mostra os jogadores de uma determinada seleção.
	 * @param idSelecao O ID da seleção que será mostrado os jogadores.
	 */
	
	public static List<String> mostrarJogadoresSelecao(int idSelecao) {
		List<String> lista = new LinkedList<String>();
		SelecaoDAO selecaoDAO = DAO.getSelecoes();
		System.out.println("Esses sao os jogadores inscritos:");
		  for (Jogador jogadorIterator: selecaoDAO.read(idSelecao).getJogadoresList()) {
			  lista.add(jogadorIterator.getId() + " - " + jogadorIterator.getNome());
		  }
		return lista;
	}	
	
	/**
	 * Função que printa os objetos de um DAO específico usando o método toString de cada classe.
	 * @param dao Um inteiro que indica qual DAO será usado para printar. 1 para jogadores, 2 para arbitros, 3 para técnicos e 4 para seleções.
	 */
	
	public static List<Object> listarDAO(int dao) {
	  List<Object> lista = new LinkedList<Object>();
	  SelecaoDAO selecaoDAO = DAO.getSelecoes();
	  JogadorDAO jogadorDAO = DAO.getJogadores();
	  TecnicoDAO tecnicoDAO = DAO.getTecnicos();
	  ArbitroDAO arbitroDAO = DAO.getArbitros();
	  switch (dao){
		  case 1:
			  if (jogadorDAO.readAll().size() != 0) {
				  lista.add("Esses são os jogadores inscritos:");
				  for (Jogador jogadorIterator: jogadorDAO.readAll()) {
					  lista.add("+----------------------------------------+");
					  lista.add(jogadorIterator);
				  }
				  lista.add("+----------------------------------------+");
			  } else {
				  lista.add("Nao ha jogadores inscritos.");
			  }
			  break;
		  case 2:
			  if (arbitroDAO.readAll().size() != 0) {
				  lista.add("Esses são os arbitros inscritos:");
				  for (Arbitro arbitroIterator: arbitroDAO.readAll()) {
					  lista.add("+----------------------------------------+");
					  lista.add(arbitroIterator);
				  }
				  lista.add("+----------------------------------------+");
	  			} else {
	  				lista.add("Nao ha arbitros inscritos.");
	  			}
			  break;
		  case 3:
			  if (tecnicoDAO.readAll().size() != 0) {
				  lista.add("Esses são os tecnicos inscritos:");
				  for (Tecnico tecnicoIterator: tecnicoDAO.readAll()) {
					  lista.add("+----------------------------------------+");
					  lista.add(tecnicoIterator);
				  }
				  lista.add("+----------------------------------------+");
	  			} else {
	  				lista.add("Nao ha tecnicos inscritos.");
	  			}
			  break;
		  case 4:
			  if (selecaoDAO.readAll().size() != 0) {
				  lista.add("Essas sao as selecoes inscritas:");
				  for (Selecao selecaoIterator: selecaoDAO.readAll()) {
					  lista.add("+----------------------------------------+");
					  lista.add(selecaoIterator);
				  }
				  lista.add("+----------------------------------------+");
			  } else {
				  lista.add("Nao ha selecoes inscritas.");
			  }
			  break;
	  }
	return lista;
	}
	
	/**
	 * Uma função parecida com a função listarDAO, mas que printa o nome dos objetos ao lado do ID do objeto.
	 * @param dao Um inteiro que indica qual DAO será usado para printar. 1 para jogadores, 2 para arbitros, 3 para técnicos e 4 para seleções.
	 */
	
	public static List<String> listarDAOByID(int dao) {
		  List<String> lista = new LinkedList<String>();
		  SelecaoDAO selecaoDAO = DAO.getSelecoes();
		  JogadorDAO jogadorDAO = DAO.getJogadores();
		  TecnicoDAO tecnicoDAO = DAO.getTecnicos();
		  ArbitroDAO arbitroDAO = DAO.getArbitros();
		  switch (dao){
			  case 1:
				  lista.add("Esses sao os jogadores inscritos:");
				  for (Jogador jogadorIterator: jogadorDAO.readAll()) {
					  lista.add(jogadorIterator.getId() + " - " + jogadorIterator.getNome());
				  }
				  break;
			  case 2:
				  lista.add("Esses sao os arbitros inscritos:");
				  for (Arbitro arbitroIterator: arbitroDAO.readAll()) {
					  lista.add(arbitroIterator.getId() + " - " + arbitroIterator.getNome());
				  }
				  break;
			  case 3:
				  lista.add("Esses sao os tecnicos inscritos:");
				  for (Tecnico tecnicoIterator: tecnicoDAO.readAll()) {
					  lista.add(tecnicoIterator.getId() + " - " + tecnicoIterator.getNome());
				  }
				  break;
			  case 4:
				  lista.add("Esses sao as selecoes inscritas:");
				  for (Selecao selecaoIterator: selecaoDAO.readAll()) {
					  lista.add(selecaoIterator.getId() + " - " + selecaoIterator.getNome());
				  }
				  break;
		  }
		  return lista;
		}
	
	/**
	 * Função que mostra as seleções cheias ou vazias.
	 * @param fullOrNot Um valor booleano que, se for true, vai mostrar só as seleções cheias e se for false vai mostrar só as seleções vazias.
	 */
	
  public static List<String> mostrarSelecao(boolean fullOrNot) {
	  List<String> lista = new LinkedList<String>();
	  
	  SelecaoDAO selecaoDAO = DAO.getSelecoes();
	  List<Selecao> listSelecoes = selecaoDAO.readAll();
	  lista.add("Essas sao as Selecoes disponiveis:");
	  for (Selecao selecaoIterator: listSelecoes) {
		  if (fullOrNot && selecaoIterator.isFull()) {
			  lista.add(selecaoIterator.getId() + " - " + selecaoIterator.getNome());
			}
		  else if (!(fullOrNot) && !selecaoIterator.isFull()) {
			  lista.add(selecaoIterator.getId() + " - " + selecaoIterator.getNome());
			}
		}
	  
	  return lista;
	  }
  
  /**
   * Função que checa se ainda há espaço em alguma seleção para adicionar jogadores.
   * @return Retorna falso caso ainda haja espaço ou verdadeiro caso não haja espaço.
   */
  
  public static boolean verificarExistencia(int dao) {
	  SelecaoDAO selecaoDAO = DAO.getSelecoes();
	  JogadorDAO jogadorDAO = DAO.getJogadores();
	  TecnicoDAO tecnicoDAO = DAO.getTecnicos();
	  ArbitroDAO arbitroDAO = DAO.getArbitros();
	  
	  switch(dao) {
	  	case 1:
	  		if (selecaoDAO.readAll().isEmpty())
	  			return true;
	  		else
	  			return false;
	  	case 2:
	  		if (jogadorDAO.readAll().isEmpty())
	  			return true;
	  		else
	  			return false;
	  	case 3:
	  		if (tecnicoDAO.readAll().isEmpty())
	  			return true;
	  		else 
	  			return false;
	  	case 4:
	  		if (arbitroDAO.readAll().isEmpty())
	  			return true;
	  		else 
	  			return false;
	  }
	return true;
  }
  
  public static Object selecionarDAO(int dao, int id) {
	SelecaoDAO selecaoDAO = DAO.getSelecoes();
	JogadorDAO jogadorDAO = DAO.getJogadores();
	TecnicoDAO tecnicoDAO = DAO.getTecnicos();
	ArbitroDAO arbitroDAO = DAO.getArbitros(); 
	
	switch(dao) {
	  case 1:
		  return selecaoDAO.read(id);
	  case 2:
		  return jogadorDAO.read(id);
	  case 3:
		  return tecnicoDAO.read(id);
	  case 4:
		  return arbitroDAO.read(id);
	}
	return null;
  }
  
  public static boolean isSelecoesFull() {
	  SelecaoDAO selecaoDAO = DAO.getSelecoes();
	  List<Boolean> selecoesFull = new LinkedList<Boolean>();
	  List<Selecao> listSelecoes = selecaoDAO.readAll();
	  for (Selecao selecaoIterator: listSelecoes) {
			selecoesFull.add(selecaoIterator.isFull());
		}
	  return !(selecoesFull.contains(false));
  }
	
  public static void createSelecao(String nome, String grupo, int posicaoGrupo) {
	  SelecaoDAO selecaoDAO = DAO.getSelecoes();
	  Selecao selecao = new Selecao(nome, grupo, posicaoGrupo);
	  selecaoDAO.create(selecao);
  }
	
  public static void updateSelecao(int idSelecao, int selecaoEditar,String atributo) {
	  SelecaoDAO selecaoDAO = DAO.getSelecoes();
	  selecaoDAO.update(idSelecao, selecaoEditar, atributo);	  
  }
  
  public static void deleteSelecao(int selecaoID) {
	  SelecaoDAO selecaoDAO = DAO.getSelecoes();
	  JogadorDAO jogadorDAO = DAO.getJogadores();
	  TecnicoDAO tecnicoDAO = DAO.getTecnicos();
	  
	  Selecao selecaoDelete = selecaoDAO.read(selecaoID);
	  for (Integer jogadorIterator: selecaoDelete.getJogadores()) {
			jogadorDAO.delete(jogadorIterator);
		}
		tecnicoDAO.delete(selecaoDelete.getTecnico());
		selecaoDAO.delete(selecaoID);
	}
  
  public static void createJogador(String nome, int selecao, String nacionalidade, int idade, String posicao, int cartaoAmarelo, int cartaoVermelho, int golsQuantidade, boolean titular) {
		JogadorDAO jogadorDAO = DAO.getJogadores();
		Jogador jogador = new Jogador(nome, selecao, nacionalidade, idade, posicao, cartaoAmarelo, cartaoVermelho, golsQuantidade, titular);
		jogadorDAO.create(jogador);
	  }
  
  public static void updateJogador(int idJogador, int jogadorEditar,String atributo) {
	  JogadorDAO jogadorDAO = DAO.getJogadores();
	  jogadorDAO.update(idJogador, jogadorEditar, atributo);	  
  }
			  
  public static void deleteJogador (int jogadorID) {
	  JogadorDAO jogadorDAO = DAO.getJogadores();
	  jogadorDAO.delete(jogadorID);
	}
  
  public static int SelecaoJogador(int idJogador) {
	  JogadorDAO jogadorDAO = DAO.getJogadores();
	  Jogador jogador = jogadorDAO.read(idJogador);
	  return jogador.getSelecao().getId();
  }
  
  public static void createArbitro(String nome, String nacionalidade, String tipo, int idade) {
		ArbitroDAO arbitroDAO = DAO.getArbitros();
		Arbitro arbitro = new Arbitro(nome, nacionalidade, tipo, idade);
  		arbitroDAO.create(arbitro);
	  }
  
  public static void updateArbitro(int idArbitro, int arbitroEditar,String atributo) {
	  ArbitroDAO arbitroDAO = DAO.getArbitros();
	  arbitroDAO.update(idArbitro, arbitroEditar, atributo);	  
  }
  
  public static void deleteArbitro (int arbitroID) {
	  ArbitroDAO arbitroDAO = DAO.getArbitros();
	  arbitroDAO.delete(arbitroID);
	}
  
  public static void createTecnico(String nacionalidade, int selecao, String timeAnterior,String nome, int idade) {
	  TecnicoDAO tecnicoDAO = DAO.getTecnicos();
	  Tecnico tecnico = new Tecnico(nacionalidade, selecao, timeAnterior, nome, idade);
	  tecnicoDAO.create(tecnico);
  }
  
  public static void updateTecnico(int idTecnico, int tecnicoEditar,String atributo) {
	  TecnicoDAO tecnicoDAO = DAO.getTecnicos();
	  tecnicoDAO.update(idTecnico, tecnicoEditar, atributo);	  
  }
  
  public static void deleteTecnico (int tecnicoID) {
	  TecnicoDAO tecnicoDAO = DAO.getTecnicos();
	  tecnicoDAO.read(tecnicoID).getSelecao().setTecnico(-1);
	  tecnicoDAO.delete(tecnicoID);
	}
  
  public static int SelecaoTecnico(int idJogador) {
	  TecnicoDAO tecnicoDAO = DAO.getTecnicos();
	  Tecnico tecnico = tecnicoDAO.read(idJogador);
	  return tecnico.getSelecao().getId();
  }
}
