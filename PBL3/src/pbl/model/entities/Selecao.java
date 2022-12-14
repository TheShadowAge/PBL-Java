package pbl.model.entities;
import java.util.*;

import pbl.model.DAO.DAO;
import pbl.model.DAO.JogadorDAO;
import pbl.model.DAO.PartidaDAO;

/**
 * Classe que representa as seleções do sistema.
 * @author Gabriel Sena
 * @author Ian Gabriel
 */

public class Selecao extends Entidade{
	private List<Integer> jogadores = new LinkedList<Integer>();
	private int contagemJogs = 0;
	private int tecnico = -1;
	private int grupo;
	private int codSel;
	private List<Integer> partidas = new LinkedList<Integer>();
	
	/**
	 * Construtor da classe Selecao.
	 * @param nome Nome da seleção.
	 * @param grupo Grupo da seleção.
	 * @param posicaoGrupo Posição da seleção no grupo.
	 */
	
	public Selecao(String nome, int grupo, int posicaoGrupo) {
		this.nome = nome;
		this.grupo = grupo;
	}
	
	/**
	 * Método que retorna as informações da seleção quando printar o objeto.
	 * @return Retorna uma String com as informações da seleção.
	 */
	
	public String toString() {
		return getNome();
	}
	
	/**public String toString() {
		String tecnicoPresente = Integer.toString(tecnico);
		if (tecnico == -1) {
			tecnicoPresente = "Essa selecao nao tem tecnico";
		}
		return "ID da selecao: "+ id + "\nCodigo da selecao: " + codSel + "\nNome da selecao: " + nome + "\nGrupo da selecao: " + grupo + "\nPosicao no Grupo da selecao: " + posicaoGrupo + "\nQuantidade de jogadores da selecao: " + jogadores.size() + "\nID tecnico da selecao: " + tecnicoPresente;
	}*/

	/**
	 * Retorna o grupo da seleção.
	 * @return Retorna uma String com o grupo da Seleção.
	 */
	
	public int getGrupo() {
		return grupo;
	}
	
	/**
	 * Muda o grupo da seleção.
	 * @param grupo String com o grupo da seleção.
	 */
	
	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}
	
	/**
	 * Retorna o inteiro que representa o ID do técnico da Seleção.
	 * @return O inteiro que representa o técnico da seleção.
	 */
	
	public int getTecnico() {
		return tecnico;
	}
	
	/**
	 * Muda o técnico da seleção.
	 * @param tecnico Inteiro que representa o novo ID do técnico da seleção.
	 */
	
	public void setTecnico(int tecnico) {
		this.tecnico = tecnico;
	}
	
	/**
	 * Retorna uma lista com os inteiros que representam os IDs de jogadores.
	 * @return Uma lista de inteiros com os ID dos jogadores da seleção.
	 */
	
	public List<Integer> getJogadores() {
		return jogadores;
	}
	
	/**
	 * Retorna uma lista com os objetos dos jogadores da Seleção.
	 * @return Uma lista com os objetos dos jogadores da Seleção.
	 */
	
	public List<Jogador> getJogadoresList() {
		JogadorDAO jogDAO = DAO.getJogadores();
		List<Jogador> listJogadores = new LinkedList<Jogador>();
		for (Integer jogadorIterator: jogadores) {
			listJogadores.add(jogDAO.read(jogadorIterator));
		}
		return listJogadores;
	}
	
	/**
	 * Retorna o Código da Seleção.
	 * @return Inteiro que representa o código da seleção.
	 */
	
	public int getCodSel() {
		return codSel;
	}
	
	/**
	 * Muda o código da seleção.
	 * @param codSel Inteiro que representa o novo código da seleção.
	 */
	
	public void setCodSel(int codSel) {
		this.codSel = codSel;
	}
	
	/**
	 * Método que retorna se a seleção está cheia.
	 * @return Verdadeiro caso ela esteja cheia ou falso caso ainda haja espaço para mais jogadores.
	 */
	
	public boolean isFull() {
		if (jogadores.size() > 25)
			return true;
		return false;
	}
	
	/**
	 * Retorna a contagem de jogadores da seleção e aumenta em 1 a contagem.
	 * @return O inteiro que representa a contagem de jogadores.
	 */
	
	public int getContagemJogs() {
		return contagemJogs++;
	}
	
	/**
	 * Retorna uma lista de inteiros com os Ids das partidas que a seleção particiou.
	 * @return uma lista de inteiros com os Ids das partidas.
	 */
	public List<Integer> getPartidas() {
		return partidas;
	}
	
	public List<Partida> getPartidasList() {
		PartidaDAO parDAO = DAO.getPartidas();
		List<Partida> listPartidas = new LinkedList<Partida>();
		for (Integer partidaIterator: partidas) {
			listPartidas.add(parDAO.read(partidaIterator));
		}
		return listPartidas;
	}
}
