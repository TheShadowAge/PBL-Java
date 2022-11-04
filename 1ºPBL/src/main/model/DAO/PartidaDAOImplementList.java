package main.model.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.controller.ControllerPartida;
import main.model.entities.Partida;


public class PartidaDAOImplementList implements PartidaDAO {
	
	private Map<Integer, Partida> partidas = new HashMap<Integer, Partida>();

	
	/**
	 * Método que cria um jogador no sistema.
	 * @param jogador O objeto do tipo Selecao que será criado.
	 */	
	
	@Override
	public void create(Partida partida) {
		partidas.put(partida.getId(), partida);
	}

	/**
	 * Método que retorna um objeto do tipo Jogador pelo id do Jogador.
	 * @param id Inteiro que representa o ID que será usado para acessar o Jogador.
	 * @return Retorna o jogador do ID especificado.
	 */
	
	@Override
	public Partida read(int id) {
		return partidas.get(id);
	}

	/**
	 * Metódo que retorna uma lista com todos os árbitros do sistema.
	 * @return Retorna uma lista com todos os árbitros do sistema.
	 */
	
	@Override
	public List<Partida> readAll() {
		List<Partida> listPartida = new ArrayList<Partida>();
		for (Partida partidasIterator: partidas.values()) {
			listPartida.add(partidasIterator);
		}
		return listPartida;
		
	}

	/**
	 * Método que atualiza as informações dos jogadores do sistema. 
	 * @param id Inteiro que representa o ID do jogador a ser atualizado. 
	 * @param opcao Inteiro que define a informação que será atualizada. 1 para nome, 2 para selecao, 3 para posicao, 4 para a quantidade de cartões amarelos, 5 para a quantidade de cartões vermelhos, 6 para idade, 7 para nacionalidade e 8 para titular, 9 para a quantidade de gols, 10 CodJog.
	 * @param atributo Uma String com o atributo que será atualizado.
	 */
	
	@Override
	public void update(int id, int opcao, String atributo) {
		switch(opcao) {
		case 1:
			partidas.get(id).setData(ControllerPartida.formatarData(atributo));
			break;
		case 2:
			partidas.get(id).setHorario(ControllerPartida.formatarHorario(atributo));
			break;
		case 3:
			partidas.get(id).setLocal(atributo);
			break;
		case 4:
			partidas.get(id).setTime1(Integer.parseInt(atributo));
			partidas.get(id).setNome(ControllerPartida.nomePartida(partidas.get(id).getTime1(), partidas.get(id).getTime2()));
			break;
		case 5:
			partidas.get(id).setGolstime1(Integer.parseInt(atributo));
			break;
		case 6:
			partidas.get(id).setCartAmaTime1(Integer.parseInt(atributo));
			break;
		case 10:
			partidas.get(id).setCartVerTime1(Integer.parseInt(atributo));
			break;
		case 7:
			partidas.get(id).setTime2(Integer.parseInt(atributo));
			partidas.get(id).setNome(ControllerPartida.nomePartida(partidas.get(id).getTime1(), partidas.get(id).getTime2()));
			break;
		case 8:
			partidas.get(id).setGolstime2(Integer.parseInt(atributo));
			break;
		case 9:
			partidas.get(id).setCartAmaTime2(Integer.parseInt(atributo));
			break;
		case 11:
			partidas.get(id).setCartVerTime2(Integer.parseInt(atributo));
			break;
		}	
	}

	/**
	 * Método que atualiza as informações das listas nas partidas do sistema. 
	 * @param id Inteiro que representa o ID do partidas a ser atualizado. 
	 * @param opcao Inteiro que define a lista que será atualizada. 1 para lista de jogadores que fizeram gols do time 1, 2 para lista de jogadores que receberam cartões do time 1, 3 para lista de jogadores que fizeram gols do time 2, 4 para lista de jogadores que receberam cartões do time 1.
	 * @param atributo Uma lista com os dados que serão atualizados.
	 */
	
	@Override
	public void updateList(int id, int opcao, List<Integer> lista) {
		PartidaDAO partidaDAO = DAO.getPartidas();
		switch (opcao) {
		case 1:
			partidaDAO.read(id).setJogsGols1(lista);
			break;
		case 2:
			partidaDAO.read(id).setJogsCarts1(lista);
			break;
		case 3:
			partidaDAO.read(id).setJogsGols2(lista);
			break;
		case 4:
			partidaDAO.read(id).setJogsCarts2(lista);
			break;
		}
	}
	
	/**
	 * Método que deleta um jogador do Sistema pelo ID.
	 * @param id Inteiro que representa o ID do jogador que será removido.
	 */
	
	@Override
	public void delete(int id) {
		partidas.put(id, null);
		partidas.remove(id);
	}
}
