package main.controller;

import main.model.DAO.ArbitroDAO;
import main.model.DAO.DAO;
import main.model.entities.Arbitro;

public class ControllerArbitro {
	
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
	  
}
