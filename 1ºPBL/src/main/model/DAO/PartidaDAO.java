package main.model.DAO;
import java.util.List;
import main.model.entities.Partida;

/**
 * Interface que define o padrão para o acesso dos objetos do tipo Partida.
 * @author Gabriel Sena
 * @author Ian Gabriel
 */

public interface PartidaDAO {

	/**
	 * Método que cria uma partida no sistema.
	 * @param partida O objeto do tipo partida que será criado.
	 */
	
	public void create(Partida partida);
	
	/**
	 * Método que retorna um objeto do tipo partida pelo id da partida.
	 * @param id Inteiro que representa o ID que será usado para acessar a partida.
	 * @return Retorna a partida do ID especificado.
	 */
	
	public Partida read(int id);
	
	/**
	 * Metódo que retorna uma lista com todos as partidas do sistema.
	 * @return Retorna uma lista com todos as partidas do sistema.
	 */
	
	public List<Partida> readAll();
	
	/**
	 * Método que atualiza as informações da partidas do sistema. 
	 * @param id Inteiro que representa o ID do partidas a ser atualizado. 
	 * @param opcao Inteiro que define a informação que será atualizada. 1 para nome, 2 para selecao, 3 para posicao, 4 para a quantidade de cartões amarelos, 5 para a quantidade de cartões vermelhos, 6 para idade, 7 para nacionalidade e 8 para titular, 9 para a quantidade de gols, 10 CodJog.
	 * @param atributo Uma String com o atributo que será atualizado.
	 */
	
	public void update(int id, int opcao, String atributo);
	
	/**
	 * Método que deleta um partidas do Sistema pelo ID.
	 * @param id Inteiro que representa o ID do partidas que será removido.
	 */
	
	public void delete(int id);
}
