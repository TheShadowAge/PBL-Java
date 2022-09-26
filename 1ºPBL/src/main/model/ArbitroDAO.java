package main.model;
import java.util.List;

/**
 * Interface que define o padrão para o acesso dos objetos do tipo Arbitro.
 * @author Gabriel Sena
 * @author Ian Gabriel
 *
 */

public interface ArbitroDAO {
	
	/**
	 * Método que cria um árbitro no sistema.
	 * @param arbitro O objeto do tipo Arbitro que será criado.
	 */
	
	public void create(Arbitro arbitro);
	
	/**
	 * Método que retorna um objeto do tipo Arbitro pelo id do Arbitro.
	 * @param id Inteiro que representa o ID que será usado para acessar o Arbitro.
	 * @return Retorna o árbitro do ID especificado.
	 */
	
	public Arbitro read(int id);
	
	/**
	 * Metódo que retorna uma lista com todos os árbitros do sistema.
	 * @return Retorna uma lista com todos os árbitros do sistema.
	 */
	
	public List<Arbitro> readAll();
	
	/**
	 * Método que atualiza as informações dos árbitros do sistema. 
	 * @param id Inteiro que representa o ID do árbitro a ser atualizado. 
	 * @param opcao Inteiro que define a informação que será atualizada. 1 para nome, 2 para idade, 3 para nacionalidade e 4 para o tipo.
	 * @param atributo Uma String com o atributo que será atualizado.
	 */
	
	public void update(int id, int opcao, String atributo);
	
	/**
	 * Método que deleta um árbitro do Sistema pelo ID.
	 * @param id Inteiro que representa o ID do árbitro que será removido.
	 */
	
	public void delete(int id);
}
