package main.model;

import java.util.*;

/**
 * Classe que implementa a interface TecnicoDAO.
 * @see main.model.SelecaoDAO
 * @author Gabriel Sena
 * @author Ian Gabriel
 *
 */

public class TecnicoDAOImplementList implements TecnicoDAO {

	private Map<Integer, Tecnico> tecnicos = new HashMap<Integer, Tecnico>();
	
	/**
	 * Método que cria um tecnico no sistema.
	 * @param tecnico O objeto do tipo Tecnico que será criado.
	 */
	
	@Override
	public void create(Tecnico tecnico) {
		DAO.getSelecoes().update(tecnico.getSelecao().getId(), 4, Integer.toString(tecnico.getId()));
		tecnicos.put(tecnico.getId(), tecnico);
	}

	/**
	 * Método que retorna um objeto do tipo Tecnico pelo id do Tecnico.
	 * @param id Inteiro que representa o ID que será usado para acessar o Tecnico.
	 * @return Retorna o tecnico do ID especificado.
	 */
	
	@Override
	public Tecnico read(int id) {
		return tecnicos.get(id);
	}

	/**
	 * Metódo que retorna uma lista com todos os tecnicos do sistema.
	 * @return Retorna uma lista com todos os tecnicos do sistema.
	 */
	
	@Override
	public List<Tecnico> readAll() {
		List<Tecnico> listTecnico = new LinkedList<Tecnico>();
		for (Tecnico tecnicosIterator: tecnicos.values()) {
			listTecnico.add(tecnicosIterator);
		}
		return listTecnico;
	}

	/**
	 * Método que atualiza as informações dos tecnicos do sistema. 
	 * @param id Inteiro que representa o ID do tecnico a ser atualizado. 
	 * @param opcao Inteiro que define a informação que será atualizada. 1 para nome, 2 para selecao, 3 para idade, 4 para Nacionalidade 5 para o Time anterior.
	 * @param atributo Uma String com o atributo que será atualizado.
	 */
	
	@Override
	public void update(int id, int opcao, String atributo) {
		switch(opcao) {
		case 1:
			tecnicos.get(id).setNome(atributo);
			break;
		case 2:
			tecnicos.get(id).setSelecao(Integer.parseInt(atributo));
			break;
		case 3:
			tecnicos.get(id).setIdade(Integer.parseInt(atributo));
			break;
		case 4:
			tecnicos.get(id).setNacionalidade(atributo);
			break;
		case 5:
			tecnicos.get(id).setTimeAnterior(atributo);
			break;
		}

	}

	/**
	 * Método que deleta um tecnico do Sistema pelo ID.
	 * @param id Inteiro que representa o ID do tecnico que será removido.
	 */
	
	@Override
	public void delete(int id) {
		tecnicos.put(id, null);
		tecnicos.remove(id);
	}

}
