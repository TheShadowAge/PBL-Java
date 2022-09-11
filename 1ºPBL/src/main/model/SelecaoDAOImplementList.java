package main.model;

import java.util.*;

public class SelecaoDAOImplementList implements SelecaoDAO {

	int contagem_ids = 0;
	private Map<Integer, Selecao> selecoes = new HashMap<Integer, Selecao>();
	
	@Override
	public void create(Selecao selecao) {
		selecoes.put(selecao.getId(), selecao);
	}

	@Override
	public Selecao read(int id) {
		return selecoes.get(id);
	}

	@Override
	public List<Selecao> readAll() {
		List<Selecao> listSelecao = new LinkedList<Selecao>();
		for (Selecao selecoesIterator: selecoes.values()) {
			listSelecao.add(selecoesIterator);
		}
		return listSelecao;
	}

	@Override
	public void update(int id, int opcao, String atributo) {

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}
