package main.model.DAO;

import java.util.List;

import main.model.entities.Grupo;

public interface GrupoDAO {
	
	/**
	 * Método que cria um Grupo no sistema.
	 * @param grupo O objeto do tipo jogador que será criado.
	 */

	public void create(Grupo grupo);

	/**
	 * Método que retorna um objeto do tipo Grupo pelo id do Grupo.
	 * @param id Inteiro que representa o ID que será usado para acessar o Jogador.
	 * @return Retorna o grupo do ID especificado.
	 */

	public Grupo read(int id);

	/**
	 * Metódo que retorna uma lista com todos os grupos do sistema.
	 * @return Retorna uma lista com todos os grupos do sistema.
	 */

	public List<Grupo> readAll();

	/**
	 * Método que atualiza as informações dos grupos do sistema. 
	 * @param id Inteiro que representa o ID do grupo a ser atualizado. 
	 * @param opcao Inteiro que define a informação que será atualizada. 1 para nome, 2 para selecao, 3 para posicao, 4 para a quantidade de cartões amarelos, 5 para a quantidade de cartões vermelhos, 6 para idade, 7 para nacionalidade e 8 para titular, 9 para a quantidade de gols, 10 CodJog.
	 * @param atributo Uma String com o atributo que será atualizado.
	 */

	public void update(int id, int opcao, String atributo);
}