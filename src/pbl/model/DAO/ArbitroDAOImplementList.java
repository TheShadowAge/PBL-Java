package pbl.model.DAO;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import pbl.model.entities.*;


/**
 * Classe que implementa a interface ArbitroDAO.
 * @see pbl.model.DAO.ArbitroDAO
 * @author Gabriel Sena
 * @author Ian Gabriel
 *
 */

public class ArbitroDAOImplementList implements ArbitroDAO {

	private Map<Integer, Arbitro> arbitros = new HashMap<Integer, Arbitro>();
	
	/**
	 * Método que cria um árbitro no sistema.
	 * @param arbitro O objeto do tipo Arbitro que será criado.
	 */
	
	@Override
	public void create(Arbitro arbitro) {
		arbitros.put(arbitro.getId(), arbitro);
	}

	/**
	 * Método que retorna um objeto do tipo Arbitro pelo id do Arbitro.
	 * @param id Inteiro que representa o ID que será usado para acessar o Arbitro.
	 * @return Retorna o árbitro do ID especificado.
	 */
	
	@Override
	public Arbitro read(int id) {
		return arbitros.get(id);
	}

	/**
	 * Metódo que retorna uma lista com todos os árbitros do sistema.
	 * @return Retorna uma lista com todos os árbitros do sistema.
	 */
	
	@Override
	public List<Arbitro> readAll() {
		List<Arbitro> listArbitro = new LinkedList<Arbitro>();
		for (Arbitro arbitrosIterator: arbitros.values()) {
			listArbitro.add(arbitrosIterator);
		}
		return listArbitro;
	}

	/**
	 * Método que atualiza as informações dos árbitros do sistema. 
	 * @param id Inteiro que representa o ID do árbitro a ser atualizado. 
	 * @param opcao Inteiro que define a informação que será atualizada. 1 para nome, 2 para idade, 3 para nacionalidade e 4 para o tipo.
	 * @param atributo Uma String com o atributo que será atualizado.
	 */
	
	@Override
	public void update(int id, int opcao, String atributo) {
		switch(opcao) {
		case 1:
			arbitros.get(id).setNome(atributo);
			break;
		case 2:
			arbitros.get(id).setIdade(Integer.parseInt(atributo));
			break;
		case 3:
			arbitros.get(id).setNacionalidade(atributo);
			break;
		case 4:
			arbitros.get(id).setTipo(atributo);
		}

	}

	/**
	 * Método que deleta um árbitro do Sistema pelo ID.
	 * @param id Inteiro que representa o ID do árbitro que será removido.
	 */
	
	@Override
	public void delete(int id) {
		arbitros.put(id, null);
		arbitros.remove(id);
	}
}
