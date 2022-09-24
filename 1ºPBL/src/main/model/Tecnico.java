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
		return "ID do tecnico: "+ id + "\nNome do tecnico: " + nome + "\nSelecao do tecnico: " + selecao + "\nNacionalidade do tecnico: " + nacionalidade + "\nIdade do tecnico: " + idade + "\nTime Anterior do tecnico: " + timeAnterior;
	}
}
