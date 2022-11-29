package pbl.model.entities;

/**
 * Classe que representa os jogadores que fizeram gols durante uma partida.
 * @author Gabriel Sena
 * @author Ian Gabriel
 */

public class JogadorGols {
	private int id;
	private int gols;
	
	
	/**
	 * Constutor da classe JogadorCartoes.
	 * @param id um inteiro com o id do jogador que fez gol.
	 * @param gols um inteiro com a quantidade de gols do jogador.
	 */
	
	public JogadorGols(int id, int gols) {
		this.id = id;
		this.gols = gols;
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
}
