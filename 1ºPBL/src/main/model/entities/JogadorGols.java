package main.model.entities;

public class JogadorGols {
	private int id;
	private int gols;
	
	public JogadorGols(int id, int gols) {
		this.id = id;
		this.gols = gols;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGols() {
		return gols;
	}

	public void setGols(int gols) {
		this.gols = gols;
	}
}
