package main.model;
import java.util.List;

public interface SelecaoDAO {
	public void create(Selecao selecao);
	public int getContagem();
	public Selecao read(int id);
	public List<Selecao> readAll();
	public void update(int id, int opcao, String atributo);
	public void delete(int id);
}
