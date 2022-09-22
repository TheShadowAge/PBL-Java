package main.model;
public class Entidade {
	private static int idContagem = 1;
	
	private int id = idContagem++;
	protected String nome;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getId() {
		return id;
	}
}
