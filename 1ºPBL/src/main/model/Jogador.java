package main.model;

public class Jogador extends PessoaSelecao{
	private String posicao;
	private String codJog;
	private int cartaoAmarelo;
	private int cartaoVermelho;
	private int golsQuantidade;
	private boolean titular;
	
	public String getPosicao() {
		return posicao;
	}
	
	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
	
	public int getCartaoAmarelo() {
		return cartaoAmarelo;
	}
	
	public void setCartaoAmarelo(int cartaoAmarelo) {
		this.cartaoAmarelo = cartaoAmarelo;
	}
	
	public int getCartaoVermelho() {
		return cartaoVermelho;
	}
	
	public void setCartaoVermelho(int cartaoVermelho) {
		this.cartaoVermelho = cartaoVermelho;
	}
	
	public int getGolsQuantidade() {
		return golsQuantidade;
	}
	
	public void setGolsQuantidade(int golsQuantidade) {
		this.golsQuantidade = golsQuantidade;
	}
	
	public boolean isTitular() {
		return titular;
	}
	
	public void setTitular(boolean titular) {
		this.titular = titular;
	}

	public String getCodJog() {
		return codJog;
	}

	public void setCodJog(String codJog) {
		this.codJog = codJog;
	}
}
