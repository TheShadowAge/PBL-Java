package main.model;

/**
 * Classe que representa os Arbitros do sistema.
 * @author Gabriel Sena
 * @author Ian Gabriel
 */

public class Arbitro extends Pessoa{
	private String tipo;
	
	/**
	 * Construtor da classe Arbitro
	 * @param nome Nome do Arbitro
	 * @param nacionalidae Nacionalidade do arbitro
	 * @param tipo Tipo do arbitro
	 * @param idade Idade do arbitro
	 */
	
	public Arbitro(String nome, String nacionalidade, String tipo, int idade){
		this.nome = nome;
		this.nacionalidade = nacionalidade;
		this.tipo = tipo;		
		this.idade = idade;
	}
	
	/**
	 * Retorna o tipo do arbitro.
	 * @return Retorna uma String com o tipo do arbitro.
	 */
	
	public String getTipo() {
		return tipo;
	}

	/**
	 * Atualiza o tipo de arbitro
	 * @return tipo String com o tipo de arbitro
	 */
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Método que retorna as informações do arbitro quando printar o objeto.
	 * @return Retorna uma String com as informações da seleção.
	 */
	
	public String toString() {
		return "ID do arbitro: "+ id + "\nNome do arbitro: " + nome + "\nNacionalidade do arbitro: " + nacionalidade + "\nTipo do arbitro: " + tipo + "\nIdade do arbitro: " + idade;
	}
	
}
