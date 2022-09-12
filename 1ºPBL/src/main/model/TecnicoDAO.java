package main.model;
import java.util.List;

public interface TecnicoDAO {
	public void create(Tecnico tecnico);
	public int getContagem();
	public Tecnico read(int id);
	public List<Tecnico> readAll();
	public void update(int id, int opcao, String atributo);
	public void delete(int id);
}
