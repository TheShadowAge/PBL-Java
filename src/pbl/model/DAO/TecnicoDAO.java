package pbl.model.DAO;
import java.util.List;

import pbl.model.entities.Tecnico;

/**
 * Interface que define o padrão para o acesso dos objetos do tipo Tecnico.
 * @author Gabriel Sena
 * @author Ian Gabriel
 */

public interface TecnicoDAO {
	
	/**
	 * Método que cria um tecnico no sistema.
	 * @param tecnico O objeto do tipo Tecnico que será criado.
	 */
	
	public void create(Tecnico tecnico);
	
	/**
	 * Método que retorna um objeto do tipo Tecnico pelo id do Tecnico.
	 * @param id Inteiro que representa o ID que será usado para acessar o Tecnico.
	 * @return Retorna o tecnico do ID especificado.
	 */
	
	public Tecnico read(int id);
	
	/**
	 * Metódo que retorna uma lista com todos os tecnicos do sistema.
	 * @return Retorna uma lista com todos os tecnicos do sistema.
	 */
	
	public List<Tecnico> readAll();
	
	/**
	 * Método que atualiza as informações dos tecnicos do sistema. 
	 * @param id Inteiro que representa o ID do tecnico a ser atualizado. 
	 * @param opcao Inteiro que define a informação que será atualizada. 1 para nome, 2 para selecao, 3 para idade, 4 para Nacionalidade 5 para o Time anterior.
	 * @param atributo Uma String com o atributo que será atualizado.
	 */
	
	public void update(int id, int opcao, String atributo);
	
	/**
	 * Método que deleta um tecnico do Sistema pelo ID.
	 * @param id Inteiro que representa o ID do tecnico que será removido.
	 */
	
	public void delete(int id);
}
