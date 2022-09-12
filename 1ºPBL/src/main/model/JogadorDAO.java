package main.model;

import java.util.List;

public interface JogadorDAO {
	public void create(Jogador jogador);
	public Jogador read(int id);
	public List<Jogador> readAll();
	public void update(int id, int opcao, String atributo);
	public void delete(int id);
}
