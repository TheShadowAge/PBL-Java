package main.controller;

import main.model.DAO.DAO;
import main.model.DAO.JogadorDAO;
import main.model.entities.Jogador;

public class ControllerJogador {
	
	  public static void createJogador(String nome, int selecao, String nacionalidade, int idade, String posicao, boolean titular) {
			JogadorDAO jogadorDAO = DAO.getJogadores();
			Jogador jogador = new Jogador(nome, selecao, nacionalidade, idade, posicao, titular);
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
}
