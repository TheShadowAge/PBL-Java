package main.model.entities;

import java.util.LinkedList;
import java.util.List;

public class Grupo extends Entidade {
	int quantidadeSelecoes = 0;
	List<Integer> selecoes = new LinkedList<Integer>();
	
	public Grupo(String nome){
		this.nome = nome;
	}
	
	public int getQuantidadeSelecoes() {
		return quantidadeSelecoes;
	}

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

	public List<Integer> getSelecoes() {
		return selecoes;
	}

}