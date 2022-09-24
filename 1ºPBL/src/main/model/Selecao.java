package main.model;
import java.util.LinkedList;
import java.util.List;

public class Selecao extends Entidade{
	private List<Integer> jogadores;
	private int tecnico = -1;
	private String grupo;
	private int posicaoGrupo;
	private int codSel;
	
	public Selecao(String nome, String grupo, int posicaoGrupo) {
		this.nome = nome;
		this.grupo = grupo;
		this.posicaoGrupo = posicaoGrupo;
	}
	
	public String toString() {
		return "ID da selecao: "+ id + "\nCodigo da selecao: " + codSel + "\nNome da selecao: " + nome + "\nGrupo da selecao: " + grupo + "\nPosicao no Grupo da selecao: " + posicaoGrupo + "\nQuantidade de jogadores da selecao: " + jogadores.size();
	}
	
	public int getPosicaoGrupo() {
		return posicaoGrupo;
	}
	public void setPosicaoGrupo(int posicaoGrupo) {
		this.posicaoGrupo = posicaoGrupo;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public int getTecnico() {
		return tecnico;
	}
	public void setTecnico(int tecnico) {
		this.tecnico = tecnico;
	}
	
	public List<Integer> getJogadores() {
		return jogadores;
	}
	
	public List<Jogador> getJogadoresList() {
		JogadorDAO jogDAO = DAO.getJogadores();
		List<Jogador> listJogadores = new LinkedList<Jogador>();
		for (Integer jogadorIterator: jogadores) {
			listJogadores.add(jogDAO.read(jogadorIterator));
		}
		return listJogadores;
	}
	public void setJogadores(List<Integer> jogadores) {
		this.jogadores = jogadores;
	}
	public int getCodSel() {
		return codSel;
	}
	public void setCodSel(int codSel) {
		this.codSel = codSel;
	}
	
	public boolean isFull() {
		if (jogadores.size() > 26)
			return true;
		return false;
	}
}
