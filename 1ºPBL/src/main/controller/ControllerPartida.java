package main.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import main.model.DAO.DAO;
import main.model.DAO.JogadorDAO;
import main.model.DAO.PartidaDAO;
import main.model.DAO.SelecaoDAO;
import main.model.entities.Jogador;
import main.model.entities.JogadorCartoes;
import main.model.entities.JogadorGols;
import main.model.entities.Partida;
import main.model.entities.Selecao;

public class ControllerPartida {
	
	/**
	 * 
	 * @param nome
	 * @param data
	 * @param horario
	 * @param local
	 * @param time1
	 * @param golsTime1
	 * @param cartAmaTime1
	 * @param cartVerTime1
	 * @param time2
	 * @param golsTime2
	 * @param cartAmaTime2
	 * @param cartVerTime2
	 * @param jogsGols1
	 * @param jogsGols2
	 * @param jogsCarts1
	 * @param jogsCarts2
	 */
	
	public static void createPartida(String nome, LocalDate data, LocalTime horario,String local, int time1, int golsTime1, int cartAmaTime1, int cartVerTime1, int time2, int golsTime2, int cartAmaTime2, int cartVerTime2, List<Object> jogsGols1, List<Object> jogsGols2, List<Object> jogsCarts1, List<Object> jogsCarts2) {
		  PartidaDAO partidaDAO = DAO.getPartidas();
		  Partida partida = new Partida(nome,data,horario,local,time1, golsTime1, cartAmaTime1, cartVerTime1, time2, golsTime2, cartAmaTime2, cartVerTime2, jogsGols1, jogsGols2, jogsCarts1, jogsCarts2);
		  partidaDAO.create(partida);
	  }
	
	public static Object createJogadorGols(int idJogador, int gols) {
		JogadorGols jogGols = new JogadorGols(idJogador, gols);
		return jogGols;
	}
	
	public static Object createJogadorCartoes(int idJogador, int cartAma,int cartVer) {
		JogadorCartoes jogCarts = new JogadorCartoes(idJogador, cartAma, cartVer);
		return jogCarts;
	}
	
	public static void updatePartida(int idPartida, int partidaEditar,String atributo) {
		  PartidaDAO partidaDAO = DAO.getPartidas();
		  partidaDAO.update(idPartida, partidaEditar, atributo);	  
	  }
	public static void updateListPartida(int idPartida, int partidaEditar,List<Object> lista) {
		  PartidaDAO partidaDAO = DAO.getPartidas();
		  partidaDAO.updateList(idPartida, partidaEditar, lista);	  
	  }
	public static void deletePartida(int id) {
		PartidaDAO partidaDAO = DAO.getPartidas();
		limparDadosJogador(id,1);
		limparDadosJogador(id,2);
		limparDadosJogador(id,3);
		limparDadosJogador(id,4);
		partidaDAO.delete(id);
	}
	
	  public static List<String> listarSelecaoPartida(int id) {
		  List<String> lista = new LinkedList<String>();
		  SelecaoDAO selecaoDAO = DAO.getSelecoes();
		  
		  lista.add("Esses sao as selecoes inscritas:");
		  for (Selecao selecaoIterator: selecaoDAO.readAll()) {
			  if (selecaoIterator.getId() != id) {
			  	lista.add(selecaoIterator.getId() + " - " + selecaoIterator.getNome());
			  }
		  }
		  return lista;
	  }
	
	public static String nomePartida(int time1, int time2) {
		 SelecaoDAO selecaoDAO = DAO.getSelecoes();
		 String nome = selecaoDAO.read(time1).getNome() + " vs " + selecaoDAO.read(time2).getNome();
		 return nome;
	  }
	  
	  public static LocalDate formatarData(String data) {
		  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		  LocalDate localDate = LocalDate.parse(data, formatter);
		  return localDate;
	  }
	  
	  public static LocalTime formatarHorario(String horario) {
		  DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_TIME;
		  LocalTime localTime = LocalTime.parse(horario, formatter);
		  return localTime;
		  }
	  
	  public static List<String> jogadoresSeleção(int id){
		  List<String> lista = new LinkedList<String>();
		  JogadorDAO jogadorDAO = DAO.getJogadores();
		  lista.add("Esses sao os jogadores da seleção");
		  for (Jogador jogadorIterator: jogadorDAO.readAll()) {
			  if (jogadorIterator.getSelecao().getId() == id) {
				  lista.add(jogadorIterator.getId() + " - " + jogadorIterator.getNome());
			  }
		  }
		  return lista;
	  }
	  
	  public static void adicionarDadosJogador(int idJog,int opcao, int atributo){
		  JogadorDAO jogadorDAO = DAO.getJogadores();
		  int aux;
		  
		  switch (opcao) {
		  	case 1:
		  		aux = jogadorDAO.read(idJog).getGolsQuantidade();
		  		jogadorDAO.update(idJog, 9, Integer.toString(aux + atributo));
		  		break;
		  	case 2:
		  		aux = jogadorDAO.read(idJog).getCartaoAmarelo();
		  		jogadorDAO.update(idJog, 4, Integer.toString(aux + atributo));
		  		break;
		  	case 3: 
		  		aux = jogadorDAO.read(idJog).getCartaoVermelho();
		  		jogadorDAO.update(idJog, 5, Integer.toString(aux + atributo));
		  		break;
		  }
	  }
	  
	  public static void limparDadosJogador(int idPartida,int opcao) {
		  JogadorDAO jogadorDAO = DAO.getJogadores();
		  PartidaDAO partidaDAO = DAO.getPartidas();
		  int aux;
		  switch (opcao) {
		  	case 1:
		  		if (partidaDAO.read(idPartida).getJogsGols1().size() > 0) {
		  			for (int i = 0; i < partidaDAO.read(idPartida).getJogsGols1().size(); i ++) {
		  				JogadorGols jogGols1 = (JogadorGols) (partidaDAO).read(idPartida).getJogsGols1().get(i);
		  				aux = jogadorDAO.read(jogGols1.getId()).getGolsQuantidade();
		  				jogadorDAO.read(jogGols1.getId()).setGolsQuantidade(aux - jogGols1.getGols());
		  			}
		  			for (int k = 0; k < partidaDAO.read(idPartida).getJogsGols1().size(); k++) {
		  				partidaDAO.read(idPartida).getJogsGols1().remove(k);
		  			}
		  		}
		  		break;
		  		
		  	case 2:
		  		if (partidaDAO.read(idPartida).getJogsCarts1().size() > 0) {
		  			for (int i = 0; i < partidaDAO.read(idPartida).getJogsCarts1().size(); i ++) {
			  			JogadorCartoes jogCartoes1 = (JogadorCartoes) (partidaDAO).read(idPartida).getJogsCarts1().get(i);
			  			aux = jogadorDAO.read(jogCartoes1.getId()).getCartaoAmarelo();
			  			jogadorDAO.read(jogCartoes1.getId()).setCartaoAmarelo(aux - jogCartoes1.getCartAma());
			  			aux = jogadorDAO.read(jogCartoes1.getId()).getCartaoVermelho();
				  		jogadorDAO.read(jogCartoes1.getId()).setCartaoVermelho(aux - jogCartoes1.getCartVer());
			  		}
			  		partidaDAO.read(idPartida).getJogsCarts1().clear();
		  		}
		  		break;
		  		
		  	case 3:
		  		if (partidaDAO.read(idPartida).getJogsGols2().size() > 0) {
		  			for (int i = 0; i < partidaDAO.read(idPartida).getJogsGols2().size(); i ++) {
			  			JogadorGols jogGols2 = (JogadorGols) (partidaDAO).read(idPartida).getJogsGols2().get(i);
			  			aux = jogadorDAO.read(jogGols2.getId()).getGolsQuantidade();
			  			jogadorDAO.read(jogGols2.getId()).setGolsQuantidade(aux - jogGols2.getGols());
			  		}
		  			partidaDAO.read(idPartida).getJogsGols2().clear();
		  		}
			  	break;
			  	
		  	case 4:
		  		if (partidaDAO.read(idPartida).getJogsCarts2().size() > 0) {
		  			for (int i = 0; i < partidaDAO.read(idPartida).getJogsCarts2().size(); i ++) {
		  				JogadorCartoes jogCartoes2 = (JogadorCartoes) (partidaDAO).read(idPartida).getJogsCarts2().get(i);
		  				aux = jogadorDAO.read(jogCartoes2.getId()).getCartaoAmarelo();
		  				jogadorDAO.read(jogCartoes2.getId()).setCartaoAmarelo(aux - jogCartoes2.getCartAma());
		  				aux = jogadorDAO.read(jogCartoes2.getId()).getCartaoVermelho();
		  				jogadorDAO.read(jogCartoes2.getId()).setCartaoVermelho(aux - jogCartoes2.getCartVer());
		  			}
		  			partidaDAO.read(idPartida).getJogsCarts2().clear();
		  		}
			  	break;
		  	}
	  }
	  
	  public static int receberTime(int id,int opcao) {
		  PartidaDAO partidaDAO = DAO.getPartidas();
		  switch (opcao) {
		  case 1:
			  return partidaDAO.read(id).getTime1();
		  case 2:
			  return partidaDAO.read(id).getTime2();
		  }
		  return 0;
	  }
}
