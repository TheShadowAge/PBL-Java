package main.controller;

import main.model.DAO.DAO;
import main.model.DAO.TecnicoDAO;
import main.model.entities.Tecnico;

public class ControllerTecnico {
	
	/**
	 * Metodo que envia dados para criação do tecnico.
	 * @param nacionalidade uma string com a nacionalidade do tecnico.
	 * @param selecao um inteiro com id da selecao do tecnico.
	 * @param timeAnterior uma string com o time anterior do tecnico.
	 * @param nome uma string com o nome do tecnico.
	 * @param idade um inteiro com a idade do tecnico.
	 */
	
	  public static void createTecnico(String nacionalidade, int selecao, String timeAnterior,String nome, int idade) {
		  TecnicoDAO tecnicoDAO = DAO.getTecnicos();
		  Tecnico tecnico = new Tecnico(nacionalidade, selecao, timeAnterior, nome, idade);
		  tecnicoDAO.create(tecnico);
	  }
	  
	  /**
	   * Metodo que envia dados para edição do tecnico.
	   * @param idTecnico um inteiro com id do tecnico que sera editado.
	   * @param tecnicoEditar um inteiro com a opção de edição.
	   * @param atributo um inteiro com o atributo que sera alterado.
	   */
	  
	  public static void updateTecnico(int idTecnico, int tecnicoEditar,String atributo) {
		  TecnicoDAO tecnicoDAO = DAO.getTecnicos();
		  tecnicoDAO.update(idTecnico, tecnicoEditar, atributo);	  
	  }
	  
	  /**
	   * Metodo que envia dados para deleter um tecnico. 
	   * @param tecnicoID um inteiro com id do tecnico que sera deletado.
	   */
	  
	  public static void deleteTecnico (int tecnicoID) {
		  TecnicoDAO tecnicoDAO = DAO.getTecnicos();
		  tecnicoDAO.read(tecnicoID).getSelecao().setTecnico(-1);
		  tecnicoDAO.delete(tecnicoID);
		}
	  
	  /**
	   * Metodo que retorna id da seleção do tecnico.
	   * @param idTecnico um inteiro com o id do tecnico.
	   * @return id da seleção que o tecnico pertence.
	   */
	  public static int SelecaoTecnico(int idTecnico) {
		  TecnicoDAO tecnicoDAO = DAO.getTecnicos();
		  Tecnico tecnico = tecnicoDAO.read(idTecnico);
		  return tecnico.getSelecao().getId();
	  }
}
