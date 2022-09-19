package main.model;
import java.util.List;

public interface ArbitroDAO {
	public void create(Arbitro arbitro);
	public Arbitro read(int id);
	public List<Arbitro> readAll();
	public void update(int id, int opcao, String atributo);
	public void delete(int id);
}
