package main.model.entities;


/**
 * Classe que representa os Tecnicos do sistema.
 * @author Gabriel Sena
 * @author Ian Gabriel
 */

public class Tecnico extends PessoaSelecao{
	private String timeAnterior;
	
	/**
	 * Construtor da classe Tecnico.
	 * @param nacionalidade Nacionalidade do tecnico.
	 * @param timeAnterior Time anterior do Tecnico.
	 * @param nome Nome do tecnico.
	 * @param idade Idade do tecnico.
	 * @param selecao Selecao do tecnico.
	 */
	
	public Tecnico(String nacionalidade, int selecao, String timeAnterior, String nome, int idade){
		this.nacionalidade = nacionalidade;
		this.timeAnterior = timeAnterior;
		this.nome = nome;
		this.idade = idade;
		this.selecao = selecao;
	}
	
	/**
	 * Retorna o time anterior do Tecnico.
	 * @return Retorna um String com o time anterior do tecnico.
	 */
	
	public String getTimeAnterior() {
		return timeAnterior;
	}
	
	/**
	 * Atualiza o time anterior do tecnico.
	 * @param timeAnterior String com o time anterior do tecnico.
	 */
	
	public void setTimeAnterior(String timeAnterior) {
		this.timeAnterior = timeAnterior;
	}
	
	
	/**
	 * Método que retorna as informações do tecnico quando printar o objeto.
	 * @return Retorna uma String com as informações do tecnico.
	 */
	
	public String toString() {
		return "ID do tecnico: "+ id + "\nNome do tecnico: " + nome + "\nSelecao do tecnico: " + selecao + "\nNacionalidade do tecnico: " + nacionalidade + "\nIdade do tecnico: " + idade + "\nTime Anterior do tecnico: " + timeAnterior;
	}
}
