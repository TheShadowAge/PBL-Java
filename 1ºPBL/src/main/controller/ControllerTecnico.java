package main.controller;

import main.model.DAO.DAO;
import main.model.DAO.TecnicoDAO;
import main.model.entities.Tecnico;

public class ControllerTecnico {
	
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
