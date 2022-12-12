package pbl.controller.entities;

import pbl.model.DAO.ArbitroDAO;
import pbl.model.DAO.DAO;
import pbl.model.entities.Arbitro;

/**
 * Classe que controla os Arbitros do sistema.
 * @author Gabriel Sena
 * @author Ian Gabriel
 */

public class ControllerArbitro {
	
	
	/**
	 * Metodo que envia dados para criação do Arbitro
	 * @param nome uma string com o nome para criação do arbitro
	 * @param nacionalidade uma string com a nacionalidade para criação do arbitro
	 * @param tipo uma string com o tipo de arbitro para criação do arbitro
	 * @param idade um inteiro com a idade para criação do arbitro
	 */
	
	public static void createArbitro(String nome, String nacionalidade, String tipo, int idade) {
			ArbitroDAO arbitroDAO = DAO.getArbitros();
			Arbitro arbitro = new Arbitro(nome, nacionalidade, tipo, idade);
	  		arbitroDAO.create(arbitro);
		  }
	  
	/**
	 * Metodo que envia dados para edição do Arbitro
	 * @param idArbitro id do arbitro que será editado.
	 * @param arbitroEditar um inteiro com a opção de edição.
	 * @param atributo uma string com o atributo que será alterado.
	 */
	
	  public static void updateArbitro(int idArbitro, int arbitroEditar,String atributo) {
		  ArbitroDAO arbitroDAO = DAO.getArbitros();
		  arbitroDAO.update(idArbitro, arbitroEditar, atributo);	  
	  }
	  
	  /**
	   * Metodo que envia dado para deletar arbitro
	   * @param arbitroID id do arbitro que será deletado.
	   */
	  
	  public static void deleteArbitro (int arbitroID) {
		  ArbitroDAO arbitroDAO = DAO.getArbitros();
		  arbitroDAO.delete(arbitroID);
		}
	  
}
