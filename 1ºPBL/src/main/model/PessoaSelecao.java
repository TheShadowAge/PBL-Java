package main.model;

/**
 * Classe comum as entidades pessoa que também tem relação com uma seleção.
 * @author Gabriel Sena
 * @author Ian Gabriel
 *
 */

public class PessoaSelecao extends Pessoa {
	protected int selecao = -1;

	/**
	 * Retorna o objeto Selecao que representa a seleção da pessoa.
	 * @return Retorna o objeto do tipo Selecao relacionado com a pessoa.
	 */
	
	public Selecao getSelecao() {
		SelecaoDAO selecaoDAO = DAO.getSelecoes();
		return selecaoDAO.read(selecao);
	}

	/**
	 * Muda a seleção da pessoa para a nova seleção.
	 * @param selecao Inteiro que representa o ID da seleção.
	 */
	
	public void setSelecao(int selecao) {
		this.selecao = selecao;
	}
	
}
