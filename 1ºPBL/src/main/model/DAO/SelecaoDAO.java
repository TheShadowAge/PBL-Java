package main.model.DAO;
import java.util.List;

import main.model.entities.Selecao;

/**
 * Interface que define o padrão para o acesso dos objetos do tipo Selecao.
 * @author Gabriel Sena
 * @author Ian Gabriel
 *
 */

public interface SelecaoDAO {
	
	/**
	 * Método que cria uma seleção no sistema.
	 * @param selecao O objeto do tipo Selecao que será criado.
	 */
	
	public void create(Selecao selecao);
	
	/**
	 * Método que retorna a contagem de seleções do sistema.
	 * @return Retorna a contagem de seleções no sistema.
	 */
	
	public int getContagem();
	
	/**
	 * Método que retorna um objeto do tipo Selecao pelo id da seleção.
	 * @param id Inteiro que representa o ID que será usado para acessar a Selecao.
	 * @return Retorna a seleção do ID especificado.
	 */
	
	public Selecao read(int id);
	
	/**
	 * Metódo que retorna uma lista com todas as seleções do sistema.
	 * @return Retorna uma lista com todas as seleções do sistema.
	 */

	public List<Selecao> readAll();
	
	/**
	 * Método que atualiza as informações das seleções do sistema. 
	 * @param id Inteiro que representa o ID da seleção a ser atualizada.
	 * @param opcao Inteiro que define a informação que será atualizada. 1 para nome, 2 para grupo, 3 para posição no grupo, 4 para o técnico, 5 para adicionar um jogador pelo ID, 6 para remover um jogador pelo ID, 7 para adicionar uma partida por ID e 8 para remover uma partida por ID.
	 * @param atributo Uma String com o atributo que será atualizado.
	 */
	
	public void update(int id, int opcao, String atributo);
	
	/**
	 * Método que deleta uma seleção do Sistema pelo ID.
	 * @param id Inteiro que representa o ID da seleção que será removido.
	 */
	
	public void delete(int id);
}
