package main.controller;

import main.model.DAO.DAO;
import main.model.DAO.GrupoDAO;

/**
 * Classe que controla os grupos do sistema.
 * @author Gabriel Sena
 * @author Ian Gabriel
 */

public class ControllerGrupo {
	
	/**
	 * Metodo que envia dados para edição do Grupo.
	 * @param idGrupo id do Grupo que será editado.
	 * @param opcao um inteiro com a opção de edição.
	 * @param atributo uma string com o atributo que será alterado.
	 */
	
	public static void updateGrupo(int idGrupo, int opcao, String atributo) {
		GrupoDAO grupoDAO = DAO.getGrupos();
		grupoDAO.update(idGrupo, opcao, atributo);
	}
}
