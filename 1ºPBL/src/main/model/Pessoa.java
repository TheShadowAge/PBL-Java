package main.model;

/**
 * Classe comum a todas as classes que reprensentam pessoa do sistema.
 * @author Gabriel Sena
 * @author Ian Gabriel
 * @
 */

public class Pessoa extends Entidade{
	
	protected int idade;
	protected String nacionalidade;
	
	/**
	 * Retorna a idade da pessoa.
	 * @return Inteiro com a idade da pessoa.
	 */
	
	public int getIdade() {
		return idade;
	}
	
	/** 
	 * Muda a idade da pessoa para a idade escolhida.
	 * @param idade Inteiro com a nova idade da pessoa.
	 */
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	/**
	 * Retorna a nacionalidade da pessoa.
	 * @return String com a nacionalidade da pessoa.
	 */
	
	public String getNacionalidade() {
		return nacionalidade;
	}
	
	/**
	 * Muda a nacionalidade da pessoa.
	 * @param nacionalidade String com a nacionalidade nova da pessoa.
	 */
	
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	
}
