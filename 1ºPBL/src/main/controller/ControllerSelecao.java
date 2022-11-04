package main.controller;

import main.model.DAO.DAO;
import main.model.DAO.JogadorDAO;
import main.model.DAO.SelecaoDAO;
import main.model.DAO.TecnicoDAO;
import main.model.entities.Selecao;

public class ControllerSelecao {
	
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
	  
}
