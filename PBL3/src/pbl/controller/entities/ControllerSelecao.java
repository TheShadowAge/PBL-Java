package pbl.controller.entities;

import java.util.List;

import pbl.model.DAO.DAO;
import pbl.model.DAO.JogadorDAO;
import pbl.model.DAO.SelecaoDAO;
import pbl.model.DAO.TecnicoDAO;
import pbl.model.entities.Selecao;

public class ControllerSelecao {
	
	/**
	 * Metodo que envia dados para criação da Selecao.
	 * @param nome uma string com o nome da seleção.
	 * @param grupo uma string com o grupo da seleção.
	 * @param posicaoGrupo um inteiro com a posição da seleção no grupo.
	 */
	
	public static void createSelecao(String nome, int grupo, int posicaoGrupo) {
		  SelecaoDAO selecaoDAO = DAO.getSelecoes();
		  Selecao selecao = new Selecao(nome, grupo, posicaoGrupo);
		  selecaoDAO.create(selecao);
	  }
	
	/**
	 * Metodo que envia dados para edição da seleção.
	 * @param idSelecao um inteiro com o id da seleção que sera alterada.
	 * @param selecaoEditar um inteiro com a opção de edição.
	 * @param atributo uma string com o atributo que sera alterado.
	 */
	
	  public static void updateSelecao(int idSelecao, int selecaoEditar,String atributo) {
		  SelecaoDAO selecaoDAO = DAO.getSelecoes();
		  selecaoDAO.update(idSelecao, selecaoEditar, atributo);	  
	  }
	  
	  /**
	   * Metodo que envia dados para deletar uma seleçao.
	   * @param selecaoID um inteiro com o id da seleção que sera deletada.
	   */
	  
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
	  
	  public static String retornarUltimaSelecao() {
		  SelecaoDAO selecaoDAO = DAO.getSelecoes();
		  Selecao ultimaSelecao = null;
		  List<Selecao> listaSelecao = selecaoDAO.readAll();
		  for (int i = 0; i < listaSelecao.size(); i++ ) {
			  ultimaSelecao = listaSelecao.get(i);
		  }
		  int Id = ultimaSelecao.getId();
		  
		return Integer.toString(Id);
	  }
}
