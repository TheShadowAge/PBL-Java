package main.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class JogadorDAOImplementList implements JogadorDAO {

	private int contagemIds = 0;
	private Map<Integer, Jogador> jogadores = new HashMap<Integer, Jogador>();

	
	@Override
	public void create(Jogador jogador) {
		jogadores.put(jogador.getId(), jogador);
		contagemIds++;

	}

	@Override
	public Jogador read(int id) {
		return jogadores.get(id);
	}

	@Override
	public List<Jogador> readAll() {
		List<Jogador> listJogador = new LinkedList<Jogador>();
		for (Jogador jogadoresIterator: jogadores.values()) {
			listJogador.add(jogadoresIterator);
		}
		return listJogador;
	}

	@Override
	public void update(int id, int opcao, String atributo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getContagem() {
		// TODO Auto-generated method stub
		return 0;
	}

}
