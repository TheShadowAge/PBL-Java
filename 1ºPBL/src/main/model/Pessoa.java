package main.model;

public class Pessoa extends Entidade{
	private int idade;
	private String nacionalidade;
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getNacionalidade() {
		return nacionalidade;
	}
	
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	
}
