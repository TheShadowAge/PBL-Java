package main.model;

import java.util.*;

public class SelecaoDAOImplementList implements SelecaoDAO {

	private int contagemIds = 1;
	private Map<Integer, Selecao> selecoes = new HashMap<Integer, Selecao>();
	
	@Override
	public void create(Selecao selecao) {
		selecao.setCodSel(contagemIds++);
		selecoes.put(selecao.getId(), selecao);
	}

	@Override
	public Selecao read(int id) {
		return selecoes.get(id);
	}

	@Override
	public List<Selecao> readAll() {
		List<Selecao> listSelecao = new ArrayList<Selecao>();
		for (Selecao selecoesIterator: selecoes.values()) {
			listSelecao.add(selecoesIterator);
		}
		return listSelecao;
	}

	@Override
	public void update(int id, int opcao, String atributo) {
		switch(opcao) {
		case 1:
			selecoes.get(id).setNome(atributo);
			break;
		case 2:
			selecoes.get(id).setGrupo(atributo);
			break;
		case 3:
			selecoes.get(id).setPosicaoGrupo(Integer.parseInt(atributo));
			break;
		case 4:
			selecoes.get(id).setTecnico(Integer.parseInt(atributo));
			break;
		case 5:
			selecoes.get(id).getJogadores().add(Integer.parseInt(atributo));
			break;
		case 6:
			selecoes.get(id).getJogadores().remove((Integer) Integer.parseInt(atributo));
		}
		
	}

	@Override
	public void delete(int id) {
		selecoes.remove(id);
	}

	@Override
	public int getContagem() {
		return contagemIds;
	}
}
