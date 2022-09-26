package main.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Classe que implementa a interface JogadorDAO.
 * @see main.model.JogadorDAO
 * @author Gabriel Sena
 * @author Ian Gabriel
 *
 */

public class JogadorDAOImplementList implements JogadorDAO {

	private Map<Integer, Jogador> jogadores = new HashMap<Integer, Jogador>();

	
	/**
	 * Método que cria um jogador no sistema.
	 * @param jogador O objeto do tipo Selecao que será criado.
	 */	
	
	@Override
	public void create(Jogador jogador) {
		jogador.setCodJog(Integer.toString(jogador.getSelecao().getCodSel()) + Integer.toString(jogador.getSelecao().getContagemJogs()));
		DAO.getSelecoes().update(jogador.getSelecao().getId(), 5, Integer.toString(jogador.getId()));
		jogadores.put(jogador.getId(), jogador);
	}

	/**
	 * Método que retorna um objeto do tipo Jogador pelo id do Jogador.
	 * @param id Inteiro que representa o ID que será usado para acessar o Jogador.
	 * @return Retorna o jogador do ID especificado.
	 */
	
	@Override
	public Jogador read(int id) {
		return jogadores.get(id);
	}

	/**
	 * Metódo que retorna uma lista com todos os árbitros do sistema.
	 * @return Retorna uma lista com todos os árbitros do sistema.
	 */
	
	@Override
	public List<Jogador> readAll() {
		List<Jogador> listJogador = new LinkedList<Jogador>();
		for (Jogador jogadoresIterator: jogadores.values()) {
			listJogador.add(jogadoresIterator);
		}
		return listJogador;
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
			jogadores.get(id).setCodJog(atributo);
			break;
		}	

	}

	/**
	 * Método que deleta um jogador do Sistema pelo ID.
	 * @param id Inteiro que representa o ID do jogador que será removido.
	 */
	
	@Override
	public void delete(int id) {
		jogadores.put(id, null);
		jogadores.remove(id);
	}

}
