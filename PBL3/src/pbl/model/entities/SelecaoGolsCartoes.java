package pbl.model.entities;

/**
 * Classe que representa as seleções do sistema.
 * @author Gabriel Sena
 * @author Ian Gabriel
 */

public class SelecaoGolsCartoes extends Entidade{
	private int gols;
	private int cartAma;
	private int cartVer;
	private int partida;
	
	/**
	 * Constutor da classe JogadorGolsCartoes.
	 * @param id um inteiro com o id do jogador que fez gol.
	 * @param gols um inteiro com a quantidade de gols do jogador.
	 * @param id um inteiro com o id do jogador que recebeu cartão.
	 * @param cartAma um inteiro com a quantidade de cartoes amarelos do jogador.
	 * @param cartVer um inteiro com a quantidade de cartões vermelhos do jogador.
	 */
	
	public SelecaoGolsCartoes(int id, int gols, int cartAma, int cartVer, String nome, int partida) {
		this.id = id;
		this.setGols(gols);
		this.setCartAma(cartAma);
		this.setCartVer(cartVer);
		this.nome = nome;
		this.partida = partida;
		
	}

	public int getGols() {
		return gols;
	}

	public void setGols(int gols) {
		this.gols = gols;
	}

	public int getCartAma() {
		return cartAma;
	}

	public void setCartAma(int cartAma) {
		this.cartAma = cartAma;
	}

	public int getCartVer() {
		return cartVer;
	}

	public void setCartVer(int cartVer) {
		this.cartVer = cartVer;
	}

	public int getPartida() {
		return partida;
	}

	public void setPartida(int partida) {
		this.partida = partida;
	}
}
