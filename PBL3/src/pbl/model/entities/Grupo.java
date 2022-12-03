package pbl.model.entities;

import java.util.LinkedList;
import java.util.List;

import pbl.model.DAO.DAO;
import pbl.model.DAO.SelecaoDAO;

/**
 * Classe que representa os Grupos do sistema.
 * @author Gabriel Sena
 * @author Ian Gabriel
 */

public class Grupo extends Entidade {
	int quantidadeSelecoes = 0;
	List<Integer> selecoes = new LinkedList<Integer>();
	
	/**
	 * Construtor da classe Grupo
	 * @param nome Nome do Grupo
	 */
	
	public Grupo(String nome){
		this.nome = nome;
	}
	
	/**
	 * Retorna a quantidade de selecoes no grupo.
	 * @return um inteiro com o a quantidade de selecoes no grupo.
	 */
	
	public String toString() {
		String cheio = ""; 
		if (quantidadeSelecoes == 4) {
			cheio = "\nGrupo Completo";
		}
		return "Grupo: " + nome + "\nQuantidade de Selecoes: " + quantidadeSelecoes + cheio;
	}
	
	public int getQuantidadeSelecoes() {
		return quantidadeSelecoes;
	}

	/**
	 * Atualiza a quantdade de selecoes no grupo.
	 * @param opcao um inteiro que serve pra aumentar a quantidade de selecoes ou diminuir (1 aumenta, 2 diminui).
	 */
	
	public void setQuantidadeSelecoes(int opcao) {
		switch (opcao){
			case 1:
				this.quantidadeSelecoes--;
				break;
			case 2:
				this.quantidadeSelecoes++;
				break;
		}
	}

	/**
	 * Retorna uma lista com id das selecoes presentes no grupo.
	 * @return uma lista com id das selecoes presentes no grupo.
	 */
	
	public List<Integer> getSelecoes() {
		return selecoes;
	}
	
	public List<Selecao> getSelecoesList() {
		SelecaoDAO selDAO = DAO.getSelecoes();
		List<Selecao> listSelecoes = new LinkedList<Selecao>();
		for (Integer selecaoIterator: selecoes) {
			listSelecoes.add(selDAO.read(selecaoIterator));
		}
		return listSelecoes;
	}

}