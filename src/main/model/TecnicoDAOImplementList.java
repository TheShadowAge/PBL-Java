package main.model;

import java.util.*;

public class TecnicoDAOImplementList implements TecnicoDAO {

	int contagemIds = 0;
	private Map<Integer, Tecnico> tecnicos = new HashMap<Integer, Tecnico>();
	
	@Override
	public void create(Tecnico tecnico) {
		tecnicos.put(tecnico.getId(), tecnico);
		contagemIds++;
	}

	@Override
	public Tecnico read(int id) {
		return tecnicos.get(id);
	}

	@Override
	public List<Tecnico> readAll() {
		List<Tecnico> listTecnico = new LinkedList<Tecnico>();
		for (Tecnico tecnicosIterator: tecnicos.values()) {
			listTecnico.add(tecnicosIterator);
		}
		return listTecnico;
	}

	@Override
	public void update(int id, int opcao, String atributo) {
		switch(opcao) {
		case 1:
			tecnicos.get(id).setNome(atributo);
			break;
		case 2:
			tecnicos.get(id).setIdade(Integer.parseInt(atributo));
			break;
		case 3:
			tecnicos.get(id).setNacionalidade(atributo);
			break;
		case 4:
			tecnicos.get(id).setTimeAnterior(atributo);
		}

	}

	@Override
	public void delete(int id) {
		tecnicos.remove(id);
	}
	
	@Override
	public int getContagem() {
		return contagemIds;
	}

}
