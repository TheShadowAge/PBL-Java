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
		switch(opcao) {
		case 1:
			jogadores.get(id).setNome(atributo);
			break;
		case 2:
			jogadores.get(id).setSelecao(Integer.parseInt(atributo));
			break;
		case 3:
			jogadores.get(id).setPosicao(atributo);
			break;
		case 4:
			jogadores.get(id).setCartaoAmarelo(Integer.parseInt(atributo));
			break;
		case 5:
			jogadores.get(id).setCartaoVermelho(Integer.parseInt(atributo));
			break;
		case 6:
			jogadores.get(id).setIdade(Integer.parseInt(atributo));
			break;
		case 7:
			jogadores.get(id).setNacionalidade(atributo);
			break;
		case 8:
			jogadores.get(id).setTitular(Boolean.parseBoolean(atributo));
			break;
		case 9:
			jogadores.get(id).setGolsQuantidade(Integer.parseInt(atributo));
			break;
		case 10:
			jogadores.get(id).setIdade(Integer.parseInt(atributo));
			break;
		case 11:
			jogadores.get(id).setCodJog(atributo);
			break;
		}	

	}

	@Override
	public void delete(int id) {
		jogadores.remove(id);

	}

	@Override
	public int getContagem() {
		return contagemIds;
	}

}
