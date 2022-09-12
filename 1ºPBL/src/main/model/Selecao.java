package main.model;
import java.util.List;

public class Selecao extends Entidade{
	private List<Integer> jogadores;
	private int tecnico = -1;
	private String grupo;
	private int posicaoGrupo;
	
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
	public void setJogadores(List<Integer> jogadores) {
		this.jogadores = jogadores;
	}
	
}
