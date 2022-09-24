package main.model;

public class Arbitro extends Pessoa{
	private String tipo;
	
	public Arbitro(String nome, String nacionalidade, String tipo, int idade){
		this.nome = nome;
		this.nacionalidade = nacionalidade;
		this.tipo = tipo;		
		this.idade = idade;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String toString() {
		return "ID do arbitro: "+ id + "\nNome do arbitro: " + nome + "\nNacionalidade do arbitro: " + nacionalidade + "\nTipo do arbitro: " + tipo + "\nIdade do arbitro: " + idade;
	}
	
}
