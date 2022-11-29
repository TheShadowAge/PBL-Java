package pbl.model.entities;

/**
 * Classe que representa os jogadores que receberam cartões durante uma partida.
 * @author Gabriel Sena
 * @author Ian Gabriel
 */

public class JogadorCartoes {
		private int id;
		private int cartAma;
		private int cartVer;
		
		/**
		 * Constutor da classe JogadorCartoes
		 * @param id um inteiro com o id do jogador que recebeu cartão.
		 * @param cartAma um inteiro com a quantidade de cartoes amarelos do jogador.
		 * @param cartVer um inteiro com a quantidade de cartões vermelhos do jogador.
		 */
		
		public JogadorCartoes(int id, int cartAma, int cartVer) {
			this.id = id;
			this.cartAma = cartAma;
			this.cartVer = cartVer;
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

}
