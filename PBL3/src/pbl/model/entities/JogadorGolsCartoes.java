package pbl.model.entities;

/**
 * Classe que representa as seleções do sistema.
 * @author Gabriel Sena
 * @author Ian Gabriel
 */

public class JogadorGolsCartoes {
	private String nome;
	private int id;
	private int gols;
	private int cartAma;
	private int cartVer;
	
	/**
	 * Constutor da classe JogadorGolsCartoes.
	 * @param id um inteiro com o id do jogador que fez gol.
	 * @param gols um inteiro com a quantidade de gols do jogador.
	 * @param id um inteiro com o id do jogador que recebeu cartão.
	 * @param cartAma um inteiro com a quantidade de cartoes amarelos do jogador.
	 * @param cartVer um inteiro com a quantidade de cartões vermelhos do jogador.
	 */
	
	public JogadorGolsCartoes(int id, int gols, int cartAma, int cartVer, String nome) {
		this.id = id;
		this.gols = gols;
		this.cartAma = cartAma;
		this.cartVer = cartVer;
		this.setNome(nome);
	}

	/**
	 * Retorna o id do jogador.
	 * @return Retorna um inteiro com o id do jogador.
	 */
	
	public int getId() {
		return id;
	}

	/**
	 * Atualiza o id do jogador.
	 * @param tipo inteiro que atualiza o id do jogador.
	 */
	
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Retorna a quantidade de gols do jogador.
	 * @return um inteiro com a quantidade de gols do jogador.
	 */
	
	public int getGols() {
		return gols;
	}

	/**
	 * Atualiza a quantidade de gols de um jogador.
	 * @param cartAma um inteiro com a nova quantidade de gols do jogador.
	 */
	
	public void setGols(int gols) {
		this.gols = gols;
	}
	

	/**
	 * Retorna a quantidade de cartões amarelos do jogador.
	 * @return um inteiro com a quantidade de cartões amarelos do jogador.
	 */
	
	public int getCartAma() {
		return cartAma;
	}
	
	/**
	 * Atualiza a quantidade de cartões amarelos de um jogador.
	 * @param cartAma um inteiro com a nova quantidade de cartões amarelos do jogador.
	 */
	
	public void setCartAma(int cartAma) {
		this.cartAma = cartAma;
	}
	
	/**
	 * Retorna a quantidade de cartões vermelhos do jogador.
	 * @return um inteiro com a quantidade de cartões vermelhos do jogador.
	 */
	
	public int getCartVer() {
		return cartVer;
	}

	/**
	 * Atualiza a quantidade de cartões vermelhos de um jogador.
	 * @param cartAma um inteiro com a nova quantidade de cartões vermelhos do jogador.
	 */
	
	public void setCartVer(int cartVer) {
		this.cartVer = cartVer;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
