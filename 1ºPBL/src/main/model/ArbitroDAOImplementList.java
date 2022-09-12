package main.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ArbitroDAOImplementList implements ArbitroDAO {

	private int contagemIds = 0;
	private Map<Integer, Arbitro> arbitros = new HashMap<Integer, Arbitro>();
	
	@Override
	public void create(Arbitro arbitro) {
		arbitros.put(arbitro.getId(), arbitro);
		contagemIds++;
	}

	@Override
	public Arbitro read(int id) {
		return arbitros.get(id);
	}

	@Override
	public List<Arbitro> readAll() {
		List<Arbitro> listArbitro = new LinkedList<Arbitro>();
		for (Arbitro arbitrosIterator: arbitros.values()) {
			listArbitro.add(arbitrosIterator);
		}
		return listArbitro;
	}

	@Override
	public void update(int id, int opcao, String atributo) {
		switch(id) {
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

	@Override
	public void delete(int id) {
		arbitros.remove(id);
	}
	
	@Override
	public int getContagem() {
		return contagemIds;
	}
}