package pbl.controller.view;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import pbl.model.DAO.*;
import pbl.model.entities.*;

/**
 * classe de metodos de pesquisa.
 * @author Gabriel Sena
 * @author Ian Gabriel
 */

public class Pesquisa {
	
	/**
	 * Metodo de pesquisar uma selecao completa, mostando seus jogadoras, tecnicos e partidas pelo nome da seleção
	 * @param nome uma string com o nome da seleção que sera pesquisada.
	 * @return uma lista com todas as informações.
	 */
	
	public static List<Object> pesquisarSelecao(String nome){
		List<Object> lista = new LinkedList<Object>();
		SelecaoDAO selecaoDAO = DAO.getSelecoes();
		JogadorDAO jogadorDAO = DAO.getJogadores();
		TecnicoDAO tecnicoDAO = DAO.getTecnicos();
		PartidaDAO partidaDAO = DAO.getPartidas();
		
		int cont = 0;
		int cont1 = 0;
		int cont2 = 0;
		int cont3 = 0;
		for (Selecao selecaoIterator: selecaoDAO.readAll()) {
			if (selecaoIterator.getNome().toLowerCase().equals(nome.toLowerCase())) {
				if (cont < 1) {
					lista.add("+----------------------------------------+");
					lista.add("Esses e a selecao com nome:" + nome);
					cont ++;
				}
				lista.add("+----------------------------------------+");
				lista.add(selecaoIterator);
				for (Jogador jogadorIterator: jogadorDAO.readAll()) {
					if (jogadorIterator.getSelecao().getId() == selecaoIterator.getId()) {
						if (cont1 < 1) {
							lista.add("+----------------------------------------+");
							lista.add("Esses sao os jogadores da selecao:" + nome);
							cont1++;
						}
						lista.add("+----------------------------------------+");
						lista.add(jogadorIterator);
					}
				}
				for (Tecnico tecnicoIterator: tecnicoDAO.readAll()) {
					if (tecnicoIterator.getSelecao().getId() == selecaoIterator.getId()) {
						if (cont2 < 1) {
							lista.add("+----------------------------------------+");
							lista.add("Esse e o tecnico da selecao:" + nome);
							cont2++;
						}
						lista.add("+----------------------------------------+");
						lista.add(tecnicoIterator);
					}
				for (Partida partidaIterator: partidaDAO.readAll()) {
					if (partidaIterator.getTime1() == selecaoIterator.getId() || partidaIterator.getTime2() == selecaoIterator.getId()) {
							if (cont3 < 1) {
								lista.add("+----------------------------------------+");
								lista.add("Essas sso as partidas da selecao:" + nome);
								cont3++;
							}
							lista.add("+----------------------------------------+");
							lista.add(partidaIterator);
						}
					}
				}	
			}
		}	
		if (cont == 0) {
			lista.add("+----------------------------------------+");
			lista.add("Nao ha selecoes inscritos com esse nome.");
			}
		if (cont1 == 0) {
			lista.add("+----------------------------------------+");
			lista.add("Nao ha jogadores inscritos na selecao.");
			}
		if (cont2 == 0) {
			lista.add("+----------------------------------------+");
			lista.add("Nao ha tecnicos inscritos na selecao.");
			}
		if (cont3 == 0) {
			lista.add("+----------------------------------------+");
			lista.add("Nao ha partidas inscritos na selecao.");
			}
		lista.add("+----------------------------------------+");
		return lista;
	}
	
	/**
	 * Metodo de pesquisar partidas pela data.
	 * @param data um LocalDate com a data que deseja pesquisar.
	 * @return uma lista com todas as informações.
	 */
	
	public static List<Object> pesquisarPartidas(LocalDate data){
		List<Object> lista = new LinkedList<Object>();
		PartidaDAO partidaDAO = DAO.getPartidas();
		int cont = 0;
		for (Partida partidaIterator: partidaDAO.readAll()) {
			if (partidaIterator.getData().equals(data)) {
				if (cont < 1) {
					lista.add("+----------------------------------------+");
					lista.add("Essas sao as partidas com a data:" + data);
					cont ++;
				}
				lista.add("+----------------------------------------+");
				lista.add(partidaIterator);
			}
		}
		if (cont == 0) {
			lista.add("+----------------------------------------+");
			lista.add("não ha partidas inscritas com essa data.");
		}
		lista.add("+----------------------------------------+");
		return lista;
	}
	
	/**
	 * Metodo de pesquisar uma categoria pelo nome.
	 * @param nome uma string com o nome que deseja pesquisar.
	 * @param opcao um inteiro com o numero da categoria.
	 * @return uma lista com todas informaçoes.
	 */
	
	public static List<Object> pesquisarCategoria(String nome, int opcao){
		List<Object> lista = new LinkedList<Object>();
		int cont;
		switch(opcao) {
		case 1:
			PartidaDAO partidaDAO = DAO.getPartidas();
			cont = 0;
			for (Partida partidaIterator: partidaDAO.readAll()) {
				if (partidaIterator.getNome().toLowerCase().contains(nome.toLowerCase())) {
					if (cont < 1) {
						lista.add("+----------------------------------------+");
						lista.add("Esses sao as partidas com nome:" + nome);
						cont ++;
					}
					lista.add("+----------------------------------------+");
					lista.add(partidaIterator);
				}
			}
			if (cont == 0) {
				lista.add("+----------------------------------------+");
				lista.add("Nao ha partidas inscritos com esse nome.");
			}
			lista.add("+----------------------------------------+");
			break;
			
		case 2:
			JogadorDAO jogadorDAO = DAO.getJogadores();
			cont = 0;
			for (Jogador jogadorIterator: jogadorDAO.readAll()) {
				if (jogadorIterator.getNome().toLowerCase().contains(nome.toLowerCase())) {
					if (cont < 1) {
						lista.add("+----------------------------------------+");
						lista.add("Esses sao os jogadores com nome:" + nome);
						cont ++;
					}
					lista.add("+----------------------------------------+");
					lista.add(jogadorIterator);
				}	
			}
			if (cont == 0) {
				lista.add("+----------------------------------------+");
				lista.add("Nao ha jogadores inscritos com esse nome.");
				}
			lista.add("+----------------------------------------+");
			break;
			
		case 3:
			TecnicoDAO tecnicoDAO = DAO.getTecnicos();
			cont = 0;
			for (Tecnico tecnicoIterator: tecnicoDAO.readAll()) {
				if (tecnicoIterator.getNome().toLowerCase().contains(nome.toLowerCase())) {
					if (cont < 1) {
						lista.add("+----------------------------------------+");
						lista.add("Esses sao os tecnicos com nome:" + nome);
						cont ++;
					}
					lista.add("+----------------------------------------+");
					lista.add(tecnicoIterator);
				}	
			}
			if (cont == 0) {
				lista.add("+----------------------------------------+");
				lista.add("Nao ha tecnicos inscritos com esse nome.");
				}
			lista.add("+----------------------------------------+");
			break;
			
		case 4:
			ArbitroDAO arbitroDAO = DAO.getArbitros();
			cont = 0;
			for (Arbitro arbitroIterator: arbitroDAO.readAll()) {
				if (arbitroIterator.getNome().toLowerCase().contains(nome.toLowerCase())) {
					if (cont < 1) {
						lista.add("+----------------------------------------+");
						lista.add("Esses sao os arbitros com nome:" + nome);
						cont ++;
					}
					lista.add("+----------------------------------------+");
					lista.add(arbitroIterator);
				}	
			}
			if (cont == 0) {
				lista.add("+----------------------------------------+");
				lista.add("Nao ha arbitros inscritos com esse nome.");
				}
			lista.add("+----------------------------------------+");
			break;
			
		case 5:
			SelecaoDAO selecaoDAO = DAO.getSelecoes();
			cont = 0;
			for (Selecao selecaoIterator: selecaoDAO.readAll()) {
				if (selecaoIterator.getNome().toLowerCase().contains(nome.toLowerCase())) {
					if (cont < 1) {
						lista.add("+----------------------------------------+");
						lista.add("Esses sao os selecoes com nome:" + nome);
						cont ++;
					}
					lista.add("+----------------------------------------+");
					lista.add(selecaoIterator);
				}	
			}
			if (cont == 0) {
				lista.add("Nao ha selecoes inscritos com esse nome.");
				}
			lista.add("+----------------------------------------+");
			break;
		case 6:
			GrupoDAO grupoDAO = DAO.getGrupos();
			selecaoDAO = DAO.getSelecoes();
			cont = 0;
			for (Grupo grupoIterator: grupoDAO.readAll()) {
				if (grupoIterator.getNome().toLowerCase().contains(nome.toLowerCase())) {
					if (cont < 1) {
						lista.add("+----------------------------------------+");
						lista.add("Esses sao os grupos com nome:" + nome);
						cont ++;
							}
					lista.add("+----------------------------------------+");
					lista.add(grupoIterator);
					for (Selecao selecaoIterator: selecaoDAO.readAll()) {
						if (selecaoIterator.getGrupo().getId() == grupoIterator.getId())
							lista.add("+----------------------------------------+");
							lista.add(selecaoIterator);
					}
				}	
			}
			if (cont == 0) {
				lista.add("Nao ha grupos inscritos com esse nome.");
				}
			lista.add("+----------------------------------------+");
			break;
		}
	return lista;
	}
}

