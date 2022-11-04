package main.model;
import java.util.concurrent.ThreadLocalRandom;

import main.model.DAO.ArbitroDAO;
import main.model.DAO.DAO;
import main.model.DAO.JogadorDAO;
import main.model.DAO.PartidaDAO;
import main.model.DAO.SelecaoDAO;
import main.model.DAO.TecnicoDAO;
import main.model.entities.Arbitro;
import main.model.entities.Jogador;
import main.model.entities.Selecao;
import main.model.entities.Tecnico;
import main.model.entities.Partida;

/**
 * Classe que cria uma seleção completa e árbitros para o projeto.
 * @author Gabriel Sena
 * @author Ian Gabriel
 */

public class StartingEntitiesCreator {
	
	/**
	 * Cria os objetos das entidades presentes no projeto.
	 */
	
	public static void entitiesCreator() {
	  JogadorDAO jogadorDAO = DAO.getJogadores();
	  TecnicoDAO tecnicoDAO = DAO.getTecnicos();
	  SelecaoDAO selecaoDAO = DAO.getSelecoes();
	  ArbitroDAO arbitroDAO = DAO.getArbitros();
	  
	  selecaoDAO.create(new Selecao("Brasil", "G", 1));
	  selecaoDAO.create(new Selecao("Argentina", "G", 2));
	  jogadorDAO.create(new Jogador("Alisson", 1, "Brasileiro", 29, "Goleiro", true));
	  jogadorDAO.create(new Jogador("Ederson", 1, "Brasileiro", 29, "Goleiro", false));
	  jogadorDAO.create(new Jogador("Weverton", 1, "Brasileiro", 34, "Goleiro", false));
	  jogadorDAO.create(new Jogador("Danilo", 1, "Brasileiro", 31, "Lateral Direito", false));
	  jogadorDAO.create(new Jogador("Bremer", 1, "Brasileiro", 25, "Zagueiro", false));
	  jogadorDAO.create(new Jogador("Eder Militao", 1, "Brasileiro", 24, "Zagueiro", true));
	  jogadorDAO.create(new Jogador("Ibanez", 1, "Brasileiro", 23, "Zagueiro", false));
	  jogadorDAO.create(new Jogador("Marquinhos", 1, "Brasileiro", 28, "Zagueiro", true));
	  jogadorDAO.create(new Jogador("Thiago Silva", 1, "Brasileiro", 37, "Zagueiro", true));
	  jogadorDAO.create(new Jogador("Alex Sandro", 1, "Brasileiro", 31, "Lateral esquerdo", false));
	  jogadorDAO.create(new Jogador("Alex Telles", 1, "Brasileiro", 29, "Lateral esquerdo", true));
	  jogadorDAO.create(new Jogador("Bruno Guimaraes", 1, "Brasileiro", 24, "Volante", false));
	  jogadorDAO.create(new Jogador("Casemiro", 1, "Brasileiro", 30, "Volante", true));
	  jogadorDAO.create(new Jogador("Fabinho", 1, "Brasileiro", 28, "Volante", false));
	  jogadorDAO.create(new Jogador("Fred", 1, "Brasileiro", 29, "Volante", false));
	  jogadorDAO.create(new Jogador("Everton Ribeiro", 1, "Brasileiro", 33, "Meio-campo", false));
	  jogadorDAO.create(new Jogador("Lucas Paqueta", 1, "Brasileiro", 25, "Meio-campo", true));
	  jogadorDAO.create(new Jogador("Antony", 1, "Brasileiro", 22, "Atacante", false));
	  jogadorDAO.create(new Jogador("Matheus Cunha", 1, "Brasileiro", 23, "Atacante", false));
	  jogadorDAO.create(new Jogador("Neymar", 1, "Brasileiro", 30, "Atacante", true));
	  jogadorDAO.create(new Jogador("Pedro", 1, "Brasileiro", 25, "Atacante", false));
	  jogadorDAO.create(new Jogador("Raphinha", 1, "Brasileiro", 23, "Atacante", true));
	  jogadorDAO.create(new Jogador("Richarlison", 1, "Brasileiro", 25, "Atacante", true));
	  jogadorDAO.create(new Jogador("Roberto Firmino", 1, "Brasileiro", 30, "Atacante", false));
	  jogadorDAO.create(new Jogador("Rodrygo", 1, "Brasileiro", 21, "Atacante", false));
	  jogadorDAO.create(new Jogador("Vinicius Junior", 1, "Brasileiro", 22, "Atacante", true));
	  tecnicoDAO.create(new Tecnico("Brasileiro", 1, "Corinthians", "Tite", 61));
	  arbitroDAO.create(new Arbitro("Raphael Claus", "Brasileiro", "Arbitro", 46));
	  arbitroDAO.create(new Arbitro("Wilton Pereira Sampaio", "Brasileiro", "Arbitro", 40));
	  jogadorDAO.create(new Jogador("Alisson Argentino", 2, "Argentino", 29, "Goleiro", true));
	}
}
