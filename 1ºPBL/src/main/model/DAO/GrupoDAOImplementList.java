package main.model.DAO;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import main.model.entities.Grupo;

/**
 * Classe que implementa a interface GrupoDAO.
 * @see main.model.DAO.ArbitroDAO
 * @author Gabriel Sena
 * @author Ian Gabriel
 */

public class GrupoDAOImplementList implements GrupoDAO {

	private Map<Integer, Grupo> grupos = new HashMap<Integer, Grupo>();
	
	/**
	 * Método que cria um grupo no sistema.
	 * @param grupo O objeto do tipo Grupo que será criado.
	 */
	
	@Override
	public void create(Grupo grupo) {
		grupos.put(grupo.getId(), grupo);
	}
	
	/**
	 * Método que retorna um objeto do tipo Grupo pelo id do Grupo.
	 * @param id Inteiro que representa o ID que será usado para acessar o Grupo.
	 * @return Retorna o grupo do ID especificado.
	 */
	
	@Override
	public Grupo read(int id) {
		return grupos.get(id);
	}

	/**
	 * Metódo que retorna uma lista com todos os grupo do sistema.
	 * @return Retorna uma lista com todos os grupos do sistema.
	 */
	
	@Override
	public List<Grupo> readAll() {
		List<Grupo> listGrupo = new LinkedList<Grupo>();
		for (Grupo gruposIterator: grupos.values()) {
			listGrupo.add(gruposIterator);
		}
		return listGrupo;
	}

	/**
	 * Método que atualiza as informações dos grupos do sistema. 
	 * @param id Inteiro que representa o ID do grupo a ser atualizado. 
	 * @param opcao Inteiro que define a informação que será atualizada. 1 para nome, 2 para adicionar uma seleção e 3 para remover uma seleção.
	 * @param atributo Uma String com o atributo que será atualizado.
	 */
	
	@Override
	public void update(int id, int opcao, String atributo) {
		switch (opcao) {
			case 1:
				grupos.get(id).setNome(atributo);
				break;
			case 2:
				grupos.get(id).getSelecoes().add(Integer.parseInt(atributo));
				grupos.get(id).setQuantidadeSelecoes(1);
				break;
			case 3:
				
				grupos.get(id).getSelecoes().remove(Integer.parseInt(atributo));
				grupos.get(id).setQuantidadeSelecoes(2);
				break;
		}
	}
}