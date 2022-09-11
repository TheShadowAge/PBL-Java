package main.model;
import java.util.List;

public class Selecao {
	private List<String> jogadores;
	private Tecnico tecnico;
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
	public Tecnico getTecnico() {
		return tecnico;
	}
	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}
	public List<String> getJogadores() {
		return jogadores;
	}
	public void setJogadores(List<String> jogadores) {
		this.jogadores = jogadores;
	}
	
}
