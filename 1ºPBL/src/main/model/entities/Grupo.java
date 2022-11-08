package main.model.entities;

import java.util.LinkedList;
import java.util.List;

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
		return "ID do Grupo: "+ id + "\nNome da Partida: " + nome + "\nQuantidade de Selecoes: " + quantidadeSelecoes;
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
				this.quantidadeSelecoes++;
				break;
			case 2:
				this.quantidadeSelecoes--;
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

}