package main.model.DAO;
import main.model.entities.*;
import java.util.*;

/**
 * Classe que implementa a interface SelecaoDAO.
 * @see main.model.DAO.SelecaoDAO
 * @author Gabriel Sena
 * @author Ian Gabriel
 *
 */

public class SelecaoDAOImplementList implements SelecaoDAO {
	

	private int contagemIds = 1;
	private Map<Integer, Selecao> selecoes = new HashMap<Integer, Selecao>();
	
	/**
	 * Método que cria uma seleção no sistema.
	 * @param selecao O objeto do tipo Selecao que será criado.
	 */	
	
	@Override
	public void create(Selecao selecao) {
		selecao.setCodSel(contagemIds++);
		selecoes.put(selecao.getId(), selecao);
	}

	/**
	 * Método que retorna um objeto do tipo Selecao pelo id da seleção.
	 * @param id Inteiro que representa o ID que será usado para acessar a Selecao.
	 * @return Retorna a seleção do ID especificado.
	 */
	
		
	@Override
	public Selecao read(int id) {
		return selecoes.get(id);
	}

	/**
	 * Metódo que retorna uma lista com todas as seleções do sistema.
	 * @return Retorna uma lista com todas as seleções do sistema.
	 */
	
	@Override
	public List<Selecao> readAll() {
		List<Selecao> listSelecao = new ArrayList<Selecao>();
		for (Selecao selecoesIterator: selecoes.values()) {
			listSelecao.add(selecoesIterator);
		}
		return listSelecao;
	}

	/**
	 * Método que atualiza as informações das seleções do sistema. 
	 * @param id Inteiro que representa o ID da seleção a ser atualizada.
	 * @param opcao Inteiro que define a informação que será atualizada. 1 para nome, 2 para grupo, 3 para posição no grupo, 4 para o técnico, 5 para adicionar um jogador pelo ID e 6 para remover um jogador pelo ID.
	 * @param atributo Uma String com o atributo que será atualizado.
	 */
	
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
			break;
		case 7:
			selecoes.get(id).getPartidas().add(Integer.parseInt(atributo));
			break;
		case 8:
			selecoes.get(id).getPartidas().remove((Integer) Integer.parseInt(atributo));
			break;
		}
		
	}

	/**
	 * Método que deleta uma seleção do Sistema pelo ID.
	 * @param id Inteiro que representa o ID da seleção que será removido.
	 */
	
	@Override
	public void delete(int id) {
		selecoes.put(id, null);
		selecoes.remove(id);
	}
	
	/**
	 * Método que retorna a contagem de seleções do sistema.
	 * @return Retorna a contagem de seleções no sistema.
	 */
	

	@Override
	public int getContagem() {
		return contagemIds;
	}
}
