package main.model.entities;

public class JogadorCartoes {
		private int id;
		private int cartAma;
		private int cartVer;
		
		public JogadorCartoes(int id, int cartAma, int cartVer) {
			this.id = id;
			this.cartAma = cartAma;
			this.cartVer = cartVer;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
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

}
