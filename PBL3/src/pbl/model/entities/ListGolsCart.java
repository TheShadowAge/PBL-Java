package pbl.model.entities;

import java.util.List;

public class ListGolsCart {
	private List<JogadorCartoes> jogCart;
	private List<JogadorGols> jogGols;
	
	ListGolsCart(List<JogadorGols> jogGols, List<JogadorCartoes> jogCart){
		this.setJogCart(jogCart);
		this.setJogGols(jogGols);
	}

	public List<JogadorCartoes> getJogCart() {
		return jogCart;
	}

	public void setJogCart(List<JogadorCartoes> jogCart) {
		this.jogCart = jogCart;
	}

	public List<JogadorGols> getJogGols() {
		return jogGols;
	}

	public void setJogGols(List<JogadorGols> jogGols) {
		this.jogGols = jogGols;
	}
}
