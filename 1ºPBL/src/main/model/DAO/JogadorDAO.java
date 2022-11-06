package main.model.DAO;
import java.util.List;

import main.model.entities.Jogador;
/**
 * Interface que define o padrão para o acesso dos objetos do tipo Jogador.
 * @author Gabriel Sena
 * @author Ian Gabriel
 */

public interface JogadorDAO {
	
	/**
	 * Método que cria um Jogador no sistema.
	 * @param jogador O objeto do tipo jogador que será criado.
	 */
	
	public void create(Jogador jogador);
	
	/**
	 * Método que retorna um objeto do tipo Jogador pelo id do Jogador.
	 * @param id Inteiro que representa o ID que será usado para acessar o Jogador.
	 * @return Retorna o jogador do ID especificado.
	 */
	
	public Jogador read(int id);
	
	/**
	 * Metódo que retorna uma lista com todos os jogadores do sistema.
	 * @return Retorna uma lista com todos os jogadores do sistema.
	 */
	
	public List<Jogador> readAll();
	
	/**
	 * Método que atualiza as informações dos jogadores do sistema. 
	 * @param id Inteiro que representa o ID do jogador a ser atualizado. 
	 * @param opcao Inteiro que define a informação que será atualizada. 1 para nome, 2 para selecao, 3 para posicao, 4 para a quantidade de cartões amarelos, 5 para a quantidade de cartões vermelhos, 6 para idade, 7 para nacionalidade e 8 para titular, 9 para a quantidade de gols, 10 CodJog.
	 * @param atributo Uma String com o atributo que será atualizado.
	 */
	
	public void update(int id, int opcao, String atributo);
	
	/**
	 * Método que deleta um jogador do Sistema pelo ID.
	 * @param id Inteiro que representa o ID do jogador que será removido.
	 */
	
	public void delete(int id);
}
