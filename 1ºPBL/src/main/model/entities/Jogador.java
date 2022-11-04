package main.model.entities;

/**
 * Classe que representa os jogadores do sistema.
 * @author Gabriel Sena
 * @author Ian Gabriel
 */

public class Jogador extends PessoaSelecao{
	private String posicao;
	private String codJog;
	private int cartaoAmarelo = 0;
	private int cartaoVermelho = 0;
	private int golsQuantidade = 0;
	private boolean titular;
	
	/**
	 * Construtor da classe jogador.
	 * @param nome Nome do jogador.
	 * @param selecao Seleção do jogador.
	 * @param nacionalidade Nacionalidade do jogador.
	 * @param idade Idade do jogador.
	 * @param posicao Posição do jogador.
	 * @param cartaoAmarelo Quantidade de cartões amarelos do jogador.
	 * @param cartaoVermelho Quantidade de cartões vermelhos do jogador.
	 * @param titular Mostrar se o jogador é titular ou não
	 * @param golsQuantidade Quantidade de gols do jogador.
	 */
	
	public Jogador(String nome, int selecao, String nacionalidade, int idade, String posicao, boolean titular){
		this.nome = nome;
		this.selecao = selecao;
		this.nacionalidade = nacionalidade;
		this.idade = idade;
		this.posicao = posicao;
		this.titular = titular;
	}
	
	/**
	 * Método que retorna as informações do jogador quando printar o objeto.
	 * @return Retorna uma String com as informações do jogador.
	 */
	
	public String toString() {
		String titularSimNao = "Nao";
		if (titular) {
			titularSimNao = "Sim";
		}
		return "ID do jogador: "+ id + "\nCodigo de jogador: " + codJog + "\nNome do jogador: " + nome + "\nSelecao do jogador: " + selecao + "\nNacionalidade do jogador: " + nacionalidade + "\nIdade do jogador: " + idade + "\nPosicao do jogador: " + posicao + "\nCartoes Amarelos do jogador: " + cartaoAmarelo + "\nCartoes Vermelhos do jogador: " + cartaoVermelho + "\nO jogador e titular? " + titularSimNao + "\nQuantidade de Gols do jogador: " + golsQuantidade;
	}
	
	/**
	 * Retorna a posição do jogador.
	 * @return Retorna o Inteiro com a posição do jogador.
	 */
	
	public String getPosicao() {
		return posicao;
	}
	
	/**
	 * Atualiza a posição do jogador.
	 * @param posicao Inteiro com a posição nova do jogador.
	 */
	
	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
	
	/**
	 * Retorna a quantidade de cartões amarelos do jogador.
	 * @return Retorna o Inteiro com a quantidade de cartões amarelos do jogador.
	 */
	
	public int getCartaoAmarelo() {
		return cartaoAmarelo;
	}
	
	/**
	 * Atualiza a quantidade de cartões amarelos do jogador.
	 * @param cartaoAmarelo Inteiro com a quantidade de cartões amarelos do jogador.
	 */
	
	public void setCartaoAmarelo(int cartaoAmarelo) {
		this.cartaoAmarelo = cartaoAmarelo;
	}
	
	/**
	 * Retorna a quantidade de cartões vermelhos do jogador.
	 * @return Retorna o Inteiro com a quantidade de cartões vermelhos do jogador.
	 */
	
	public int getCartaoVermelho() {
		return cartaoVermelho;
	}
	
	/**
	 * Atualiza a quantidade de cartões vermelhos do jogador.
	 * @param cartaoVermelho Inteiro com a quantidade de cartões vermelhos do jogador.
	 */
	
	public void setCartaoVermelho(int cartaoVermelho) {
		this.cartaoVermelho = cartaoVermelho;
	}
	
	/**
	 * Retorna a quantidade de gols do jogador.
	 * @return Retorna o Inteiro com a quantidade de gols do jogador.
	 */
	
	public int getGolsQuantidade() {
		return golsQuantidade;
	}
	
	/**
	 * Atualiza a quantidade de gols do jogador.
	 * @param golsQuantidade Inteiro com a quantidade de gols do jogador.
	 */
	
	public void setGolsQuantidade(int golsQuantidade) {
		this.golsQuantidade = golsQuantidade;
	}
	
	/**
	 * Retorna se o jogador é titular ou não.
	 * @return Retorna um boleano se o jogador é titular (true) ou não (false).
	 */
	
	public boolean isTitular() {
		return titular;
	}
	
	/**
	 * Atualiza se o jogador é titular ou não.
	 * @param titular boleano se o jogador é titular (true) ou não (false).
	 */
	
	public void setTitular(boolean titular) {
		this.titular = titular;
	}

	/**
	 * Retorna o codigo de jogador do jogador.
	 * @return Retorna uma String com o codigo do jogador.
	 */
	
	public String getCodJog() {
		return codJog;
	}

	/**
	 * Atualiza o codigo de jogador do jogador.
	 * @param codJog uma String com o codigo do jogador.
	 */
	
	public void setCodJog(String codJog) {
		this.codJog = codJog;
	}
}
