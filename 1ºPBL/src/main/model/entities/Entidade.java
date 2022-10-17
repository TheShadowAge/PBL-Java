package main.model.entities;

/**
 * A classe principal de todas as entidades do sistema.
 * @author Gabriel Sena
 * @author Ian Gabriel
 *
 */

public class Entidade {
	
	/**
	 * Contagem de IDs de todas as entidades.
	 */
	
	private static int idContagem = 1;
	
	/**
	 * Dá um id para a entidade quando ela é criada e adiciona mais um a contagem de IDs.
	 */
	
	protected int id = idContagem++;
	
	/**
	 * Nome da entidade.
	 */
	
	protected String nome;
	
	/**
	 * Retorna o nome da entidade.
	 * @return String com o nome da entidade.
	 */
	
	public String getNome() {
		return nome;
	}
	
	/**
	 * Muda o nome da entidade.
	 * @param nome String com o novo nome da entidade.
	 */
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Retorna o id da identidade.
	 * @return Inteiro com o id da entidade.
	 */
	
	public int getId() {
		return id;
	}
}
