package pbl.controller.entities;

import java.util.LinkedList;
import java.util.List;

import pbl.model.DAO.*;
import pbl.model.entities.*;

/**
 * Classe que controla os grupos do sistema.
 * @author Gabriel Sena
 * @author Ian Gabriel
 */

public class ControllerGrupo {
	
	/**
	 * Lista os grupos retirando o que estão cheios
	 * @return lista com os grupos
	 */
	
	public static List<String> mostrarGrupos() {
		List<String> lista = new LinkedList<String>();
		GrupoDAO grupoDAO = DAO.getGrupos();
		lista.add("Esses sao os grupos:");
		for (Grupo grupoIterator: grupoDAO.readAll()) {
			if (grupoIterator.getQuantidadeSelecoes()<4)
				lista.add(grupoIterator.getId() + " - " + "Grupo " + grupoIterator.getNome() + " Espacos disponiveis " + "["+ (4 - grupoIterator.getQuantidadeSelecoes())+"]");
  		}
		return lista;
	}
	
	/**
	 * Lista todos os grupos.
	 * @return lista com os grupos
	 */
	
	public static List<String> mostrarTodosGrupos() {
		List<String> lista = new LinkedList<String>();
		GrupoDAO grupoDAO = DAO.getGrupos();
		lista.add("Esses sao os grupos:");
		for (Grupo grupoIterator: grupoDAO.readAll()) {
				lista.add(grupoIterator.getId() + " - " + "Grupo " + grupoIterator.getNome() + " Espacos disponiveis " + "["+ (4 - grupoIterator.getQuantidadeSelecoes())+"]");
  		}
		return lista;
	}
	
	/**
	 * retorna o id do grupo da determindada selecao.
	 * @param id da selecao
	 * @return id do grupo da selecao.
	 */
	
	public static int retornarIdGrupo(int id) {
		SelecaoDAO selecaoDAO = DAO.getSelecoes();
		return selecaoDAO.read(id).getGrupo();
	}
	
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
	
	/**
	 * Metodo que retorna o index da selecao nas selecoes do grupo.
	 * @param id inteiro com id do grupo.
	 * @param idselecao inteiro co o id da selecao.
	 * @return inteiro com index da selecao;
	 */
	
	public static int retornarIndexSelecao(int id,int idselecao) {
		GrupoDAO grupoDAO = DAO.getGrupos();
		for(int i = 0; i < grupoDAO.read(id).getSelecoes().size(); i++) {
			if (grupoDAO.read(id).getSelecoes().get(i) == idselecao) {
				return i;
			}
		}
		return -1;
	}
	
	public static int quantidadeGrupo(int id) {
		GrupoDAO grupoDAO = DAO.getGrupos();
		return grupoDAO.read(id).getQuantidadeSelecoes();
	}
}
