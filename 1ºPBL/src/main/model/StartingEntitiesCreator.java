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
	  jogadorDAO.create(new Jogador("Ederson", 1, "Brasileiro", 29, "Goleiro", ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 30 + 1),false));
	  jogadorDAO.create(new Jogador("Weverton", 1, "Brasileiro", 34, "Goleiro", ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 30 + 1), false));
	  jogadorDAO.create(new Jogador("Danilo", 1, "Brasileiro", 31, "Lateral Direito", ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 30 + 1), false));
	  jogadorDAO.create(new Jogador("Bremer", 1, "Brasileiro", 25, "Zagueiro", ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 30 + 1), false));
	  jogadorDAO.create(new Jogador("Eder Militao", 1, "Brasileiro", 24, "Zagueiro", ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 30 + 1), true));
	  jogadorDAO.create(new Jogador("Ibanez", 1, "Brasileiro", 23, "Zagueiro", ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 30 + 1), false));
	  jogadorDAO.create(new Jogador("Marquinhos", 1, "Brasileiro", 28, "Zagueiro", ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 30 + 1), true));
	  jogadorDAO.create(new Jogador("Thiago Silva", 1, "Brasileiro", 37, "Zagueiro", ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 30 + 1), true));
	  jogadorDAO.create(new Jogador("Alex Sandro", 1, "Brasileiro", 31, "Lateral esquerdo", ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 30 + 1), false));
	  jogadorDAO.create(new Jogador("Alex Telles", 1, "Brasileiro", 29, "Lateral esquerdo", ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 30 + 1), true));
	  jogadorDAO.create(new Jogador("Bruno Guimaraes", 1, "Brasileiro", 24, "Volante", ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 30 + 1), false));
	  jogadorDAO.create(new Jogador("Casemiro", 1, "Brasileiro", 30, "Volante", ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 30 + 1), true));
	  jogadorDAO.create(new Jogador("Fabinho", 1, "Brasileiro", 28, "Volante", ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 30 + 1), false));
	  jogadorDAO.create(new Jogador("Fred", 1, "Brasileiro", 29, "Volante", ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 30 + 1), false));
	  jogadorDAO.create(new Jogador("Everton Ribeiro", 1, "Brasileiro", 33, "Meio-campo", ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 30 + 1), false));
	  jogadorDAO.create(new Jogador("Lucas Paqueta", 1, "Brasileiro", 25, "Meio-campo", ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 30 + 1), true));
	  jogadorDAO.create(new Jogador("Antony", 1, "Brasileiro", 22, "Atacante", ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 30 + 1), false));
	  jogadorDAO.create(new Jogador("Matheus Cunha", 1, "Brasileiro", 23, "Atacante", ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 30 + 1), false));
	  jogadorDAO.create(new Jogador("Neymar", 1, "Brasileiro", 30, "Atacante", ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 30 + 1), true));
	  jogadorDAO.create(new Jogador("Pedro", 1, "Brasileiro", 25, "Atacante", ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 30 + 1), false));
	  jogadorDAO.create(new Jogador("Raphinha", 1, "Brasileiro", 23, "Atacante", ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 30 + 1), true));
	  jogadorDAO.create(new Jogador("Richarlison", 1, "Brasileiro", 25, "Atacante", ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 30 + 1), true));
	  jogadorDAO.create(new Jogador("Roberto Firmino", 1, "Brasileiro", 30, "Atacante", ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 30 + 1), false));
	  jogadorDAO.create(new Jogador("Rodrygo", 1, "Brasileiro", 21, "Atacante", ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 30 + 1), false));
	  jogadorDAO.create(new Jogador("Vinicius Junior", 1, "Brasileiro", 22, "Atacante", ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 3 + 1), ThreadLocalRandom.current().nextInt(0, 30 + 1), true));
	  tecnicoDAO.create(new Tecnico("Brasileiro", 1, "Corinthians", "Tite", 61));
	  arbitroDAO.create(new Arbitro("Raphael Claus", "Brasileiro", "Arbitro", 46));
	  arbitroDAO.create(new Arbitro("Wilton Pereira Sampaio", "Brasileiro", "Arbitro", 40));
	}
}
