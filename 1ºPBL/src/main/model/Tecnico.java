package main.model;

public class Tecnico extends PessoaSelecao{
	private String timeAnterior;
	
	public Tecnico(String nacionalidade, int selecao, String timeAnterior, String nome, int idade){
		this.nacionalidade = nacionalidade;
		this.timeAnterior = timeAnterior;
		this.nome = nome;
		this.idade = idade;
		this.selecao = selecao;
	}
	
	public String getTimeAnterior() {
		return timeAnterior;
	}
	public void setTimeAnterior(String timeAnterior) {
		this.timeAnterior = timeAnterior;
	}
	
	public String toString() {
		return "Nome: " + nome + "\nSelecao: " + selecao + "\nNacionalidade: " + nacionalidade + "\nIdade: " + idade + "\nTime Anterior: " + timeAnterior;
	}
}
