package main.model.entities;
import java.util.*;

import main.model.DAO.DAO;
import main.model.DAO.JogadorDAO;

/**
 * Classe que representa as seleções do sistema.
 * @author Gabriel Sena
 * @author Ian Gabriel
 */

public class Selecao extends Entidade{
	private List<Integer> jogadores = new LinkedList<Integer>();
	private int contagemJogs = 0;
	private int tecnico = -1;
	private String grupo;
	private int posicaoGrupo;
	private int codSel;
	private List<Integer> partidas = new LinkedList<Integer>();
	
	/**
	 * Construtor da classe Selecao.
	 * @param nome Nome da seleção.
	 * @param grupo Grupo da seleção.
	 * @param posicaoGrupo Posição da seleção no grupo.
	 */
	
	public Selecao(String nome, String grupo, int posicaoGrupo) {
		this.nome = nome;
		this.grupo = grupo;
		this.posicaoGrupo = posicaoGrupo;
	}
	
	/**
	 * Método que retorna as informações da seleção quando printar o objeto.
	 * @return Retorna uma String com as informações da seleção.
	 */
	
	public String toString() {
		String tecnicoPresente = Integer.toString(tecnico);
		if (tecnico == -1) {
			tecnicoPresente = "Essa selecao nao tem tecnico";
		}
		return "ID da selecao: "+ id + "\nCodigo da selecao: " + codSel + "\nNome da selecao: " + nome + "\nGrupo da selecao: " + grupo + "\nPosicao no Grupo da selecao: " + posicaoGrupo + "\nQuantidade de jogadores da selecao: " + jogadores.size() + "\nID tecnico da selecao: " + tecnicoPresente;
	}
	
	/**
	 * Retorna a posição no grupo da Seleção.
	 * @return Retorna o Inteiro com a posição da seleção no grupo.
	 */
	
	public int getPosicaoGrupo() {
		return posicaoGrupo;
	}
	
	/**
	 * Atualiza a posição no grupo da seleção.
	 * @param posicaoGrupo Inteiro com a posição nova da seleção.
	 */
	
	public void setPosicaoGrupo(int posicaoGrupo) {
		this.posicaoGrupo = posicaoGrupo;
	}
	
	/**
	 * Retorna o grupo da seleção.
	 * @return Retorna uma String com o grupo da Seleção.
	 */
	
	public String getGrupo() {
		return grupo;
	}
	
	/**
	 * Muda o grupo da seleção.
	 * @param grupo String com o grupo da seleção.
	 */
	
	public void setGrupo(String grupo) {
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
	
	public List<Integer> getPartidas() {
		return partidas;
	}
}
