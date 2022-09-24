package main.model;

public class PessoaSelecao extends Pessoa {
	protected int selecao = -1;

	public Selecao getSelecao() {
		SelecaoDAO selecaoDAO = DAO.getSelecoes();
		return selecaoDAO.read(selecao);
	}

	public void setSelecao(int selecao) {
		this.selecao = selecao;
	}
	
}
