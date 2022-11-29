package pbl.model;


import java.util.LinkedList;
import java.util.List;

import pbl.controller.entities.ControllerPartida;
import pbl.model.DAO.ArbitroDAO;
import pbl.model.DAO.DAO;
import pbl.model.DAO.GrupoDAO;
import pbl.model.DAO.JogadorDAO;
import pbl.model.DAO.PartidaDAO;
import pbl.model.DAO.SelecaoDAO;
import pbl.model.DAO.TecnicoDAO;
import pbl.model.entities.Arbitro;
import pbl.model.entities.Grupo;
import pbl.model.entities.Jogador;
import pbl.model.entities.Partida;
import pbl.model.entities.Selecao;
import pbl.model.entities.Tecnico;

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
	  GrupoDAO grupoDAO = DAO.getGrupos();
	  PartidaDAO partidaDAO = DAO.getPartidas();
	  List<Object> lista = new LinkedList<Object>();
	  
	  selecaoDAO.create(new Selecao("Brasil", 9, 1));
	  selecaoDAO.create(new Selecao("Argentina", 9, 2));
	  grupoDAO.create(new Grupo("A"));
	  grupoDAO.create(new Grupo("B"));
	  grupoDAO.create(new Grupo("C"));
	  grupoDAO.create(new Grupo("D"));
	  grupoDAO.create(new Grupo("E"));
	  grupoDAO.create(new Grupo("F"));
	  grupoDAO.create(new Grupo("G"));
	  grupoDAO.create(new Grupo("H"));
	  grupoDAO.update(9, 2, "1");
	  grupoDAO.update(9, 2, "2");
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
	  tecnicoDAO.create(new Tecnico("Argentino", 2, "River Plate", "Currito Gimenez", 57));
	  jogadorDAO.create(new Jogador("Leopoldo Gashi", 2, "Argentino", 29, "Goleiro", true));
	  jogadorDAO.create(new Jogador("Bautista Giménez", 2, "Argentino", 29, "Goleiro", false));
	  jogadorDAO.create(new Jogador("Anibal Gomez", 2, "Argentino", 34, "Goleiro", false));
	  jogadorDAO.create(new Jogador("Tito Molina", 2, "Argentino", 31, "Lateral Direito", false));
	  jogadorDAO.create(new Jogador("Javier French", 2, "Argentino", 25, "Zagueiro", false));
	  jogadorDAO.create(new Jogador("Agustin Fallaci", 2, "Argentino", 24, "Zagueiro", true));
	  jogadorDAO.create(new Jogador("Angelo Ramos", 2, "Argentino", 23, "Zagueiro", false));
	  jogadorDAO.create(new Jogador("Gualterio Gonzalezs", 2, "Argentino", 28, "Zagueiro", true));
	  jogadorDAO.create(new Jogador("Veto Herrera", 2, "Argentino", 37, "Zagueiro", true));
	  jogadorDAO.create(new Jogador("Cuartio Giménez", 2, "Argentino", 31, "Lateral esquerdo", false));
	  jogadorDAO.create(new Jogador("Platon Cohen", 2, "Argentino", 29, "Lateral esquerdo", true));
	  jogadorDAO.create(new Jogador("Iago DeRose", 2, "Argentino", 24, "Volante", false));
	  jogadorDAO.create(new Jogador("Cristoval Costa", 2, "Argentino", 30, "Volante", true));
	  jogadorDAO.create(new Jogador("Curcio Ledesma", 2, "Argentino", 28, "Volante", false));
	  jogadorDAO.create(new Jogador("Lucas Páez", 2, "Argentino", 29, "Volante", false));
	  jogadorDAO.create(new Jogador("José María Fetuccini", 2, "Argentino", 33, "Meio-campo", false));
	  jogadorDAO.create(new Jogador("Heriberto Rousse", 2, "Argentino", 25, "Meio-campo", true));
	  jogadorDAO.create(new Jogador("Manuelo Ortíz", 2, "Argentino", 22, "Atacante", false));
	  jogadorDAO.create(new Jogador("Chico Núnez", 2, "Argentino", 23, "Atacante", false));
	  jogadorDAO.create(new Jogador("Hermosa Fallaci", 2, "Argentino", 30, "Atacante", true));
	  jogadorDAO.create(new Jogador("Simón Pirozzi", 2, "Argentino", 25, "Atacante", false));
	  jogadorDAO.create(new Jogador("Ginebra Medina", 2, "Argentino", 23, "Atacante", true));
	  jogadorDAO.create(new Jogador("Omar Coronel", 2, "Argentino", 25, "Atacante", true));
	  jogadorDAO.create(new Jogador("Ramon Coronel", 2, "Argentino", 30, "Atacante", false));
	  jogadorDAO.create(new Jogador("Pablo Villar", 2, "Argentino", 21, "Atacante", false));
	  jogadorDAO.create(new Jogador("Ovidio Paz", 2, "Argentino", 22, "Atacante", true));
	  partidaDAO.create(new Partida("Brasil VS Argentina", ControllerPartida.formatarData("05/11/2022"),ControllerPartida.formatarHorario("20:00:00"),"Qatar",1,0,0,0,2,0,0,0,lista,lista,lista,lista));
	}
}
