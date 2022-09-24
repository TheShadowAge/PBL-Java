package main.model;

public class Jogador extends PessoaSelecao{
	private String posicao;
	private String codJog;
	private int cartaoAmarelo;
	private int cartaoVermelho;
	private int golsQuantidade;
	private boolean titular;
	
	public Jogador(String nome, int selecao, String nacionalidade, int idade, String posicao, int cartaoAmarelo, int cartaoVermelho, int golsQuantidade, boolean titular){
		this.nome = nome;
		this.selecao = selecao;
		this.nacionalidade = nacionalidade;
		this.idade = idade;
		this.posicao = posicao;
		this.cartaoAmarelo = cartaoAmarelo;
		this.cartaoVermelho = cartaoVermelho;
		this.titular = titular;
		this.golsQuantidade = golsQuantidade;
	}
	
	public String toString() {
		String titularSimNao = "Nao";
		if (titular) {
			titularSimNao = "Sim";
		}
		return "ID do jogador: "+ id + "\nNome do jogador: " + nome + "\nSelecao do jogador: " + selecao + "\nNacionalidade do jogador: " + nacionalidade + "\nIdade do jogador: " + idade + "\nPosicao do jogador: " + posicao + "\nCartoes Amarelos do jogador: " + cartaoAmarelo + "\nCartoes Vermelhos do jogador: " + cartaoVermelho + "\nO jogador é titular? " + titularSimNao + "\nQuantidade de Gols do jogador: " + golsQuantidade;
	}
	
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
