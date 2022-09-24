package main.model;
import java.util.concurrent.ThreadLocalRandom;

public class StartingEntitiesCreator {
	public static void entitiesCreator() {
	  JogadorDAO jogadorDAO = DAO.getJogadores();
	  TecnicoDAO tecnicoDAO = DAO.getTecnicos();
	  SelecaoDAO selecaoDAO = DAO.getSelecoes();
	  ArbitroDAO arbitroDAO = DAO.getArbitros();
	  selecaoDAO.create(new Selecao("Brasil", "G", 1));
	  jogadorDAO.create(new Jogador("Alisson", 1, "Brasileiro", 29, "Goleiro", ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 30 + 1), true));
	}
}
