package main.model.DAO;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import main.model.entities.Grupo;

public class GrupoDAOImplementsList implements GrupoDAO {
	
	private Map<Integer, Grupo> grupos = new HashMap<Integer, Grupo>();

	@Override
	public void create(Grupo grupo) {
		grupos.put(grupo.getId(), grupo);
	}

	@Override
	public Grupo read(int id) {
		return grupos.get(id);
	}

	@Override
	public List<Grupo> readAll() {
		List<Grupo> listGrupo = new LinkedList<Grupo>();
		for (Grupo gruposIterator: grupos.values()) {
			listGrupo.add(gruposIterator);
		}
		return listGrupo;
	}

	@Override
	public void update(int id, int opcao, String atributo) {
		switch (opcao) {
			case 1:
				grupos.get(id).setNome(atributo);
				break;
			case 2:
				grupos.get(id).setQuantidadeSelecoes(1);
				break;
			case 3:
				grupos.get(id).setQuantidadeSelecoes(2);
				break;
			case 4:
				grupos.get(id).getSelecoes().add(Integer.parseInt(atributo));
				break;
			case 5:
				grupos.get(id).getSelecoes().remove(Integer.parseInt(atributo));
				break;
		}
	}
}
