package pbl.controller.entities;

import pbl.model.DAO.DAO;
import pbl.model.DAO.JogadorDAO;
import pbl.model.entities.Jogador;

/**
 * Classe que controla os Jogadores do sistema.
 * @author Gabriel Sena
 * @author Ian Gabriel
 */

public class ControllerJogador {
	

	/**
	 * Metodo que envia dados para criação do jogador.
	 * @param nome uma string com o nome do jogador.
	 * @param selecao um inteiro com id da selecao do jogador.
	 * @param nacionalidade uma string com a nacionalidade do jogador.
	 * @param idade um inteiro com a idade do jogador.
	 * @param posicao uma string com a posição do jogador.
	 * @param titular um boolean referente a titularidade do jogador.
	 */
	
	  public static void createJogador(String nome, int selecao, String nacionalidade, int idade, String posicao, boolean titular) {
			JogadorDAO jogadorDAO = DAO.getJogadores();
			Jogador jogador = new Jogador(nome, selecao, nacionalidade, idade, posicao, titular);
			jogadorDAO.create(jogador);
		  }
	  
	  /**
	   * Metodo que envia dados para edição do jogador.
	   * @param idJogador um inteiro com o id do jogador que será editado.
	   * @param jogadorEditar um inteiro com a opção de edição
	   * @param atributo uma string com o atributo que sera editado.
	   */
	  
	  public static void updateJogador(int idJogador, int jogadorEditar,String atributo) {
		  JogadorDAO jogadorDAO = DAO.getJogadores();
		  jogadorDAO.update(idJogador, jogadorEditar, atributo);	  
	  }
	  
	  /**
	   * Metodo que envia dados para deletar um jogador.
	   * @param jogadorID um inteiro com o id do jogador que será deletado.
	   */
	  
	  public static void deleteJogador (int jogadorID) {
		  JogadorDAO jogadorDAO = DAO.getJogadores();
		  jogadorDAO.delete(jogadorID);
		}
	  
	  /**
	   * Metodo que retorna o id da seleção do jogador
	   * @param idJogador um inteiro com o id do jogador
	   * @return um inteiro com o id da seleção do jogador
	   */
	  
	  public static int SelecaoJogador(int idJogador) {
		  JogadorDAO jogadorDAO = DAO.getJogadores();
		  Jogador jogador = jogadorDAO.read(idJogador);
		  return jogador.getSelecao().getId();
	  }
}
