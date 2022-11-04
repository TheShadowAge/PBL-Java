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
import main.model.entities.Partida;
import main.model.entities.Selecao;

public class ControllerPartida {
	
	public static void createPartida(String nome, LocalDate data, LocalTime horario,String local, int time1, int golsTime1, int cartAmaTime1, int cartVerTime1, int time2, int golsTime2, int cartAmaTime2, int cartVerTime2, List<Integer> jogsGols1, List<Integer> jogsGols2, List<Integer> jogsCarts1, List<Integer> jogsCarts2) {
		  PartidaDAO partidaDAO = DAO.getPartidas();
		  Partida partida = new Partida(nome,data,horario,local,time1, golsTime1, cartAmaTime1, cartVerTime1, time2, golsTime2, cartAmaTime2, cartVerTime2, jogsGols1, jogsGols2, jogsCarts1, jogsCarts2);
		  partidaDAO.create(partida);
	  }
	  
	public static void updatePartida(int idPartida, int partidaEditar,String atributo) {
		  PartidaDAO partidaDAO = DAO.getPartidas();
		  partidaDAO.update(idPartida, partidaEditar, atributo);	  
	  }
	public static void updateListPartida(int idPartida, int partidaEditar,List<Integer> lista) {
		  PartidaDAO partidaDAO = DAO.getPartidas();
		  partidaDAO.updateList(idPartida, partidaEditar, lista);	  
	  }
	public static void deletePartida(int id) {
		PartidaDAO partidaDAO = DAO.getPartidas();
		partidaDAO.delete(id);  
		limparDadosJogador(id,1);
		limparDadosJogador(id,2);
		limparDadosJogador(id,3);
		limparDadosJogador(id,4);
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
		  		for (int i = 0; i < partidaDAO.read(idPartida).getJogsGols1().size(); i += 2) {
		  			aux = jogadorDAO.read(partidaDAO.read(idPartida).getJogsGols1().get(i)).getGolsQuantidade();
				  	jogadorDAO.read(partidaDAO.read(idPartida).getJogsGols1().get(i)).setGolsQuantidade(aux - partidaDAO.read(idPartida).getJogsGols1().get(i+1));
		  		}
		  		for (int k = 0; k < partidaDAO.read(idPartida).getJogsGols1().size(); k++) {
		  			partidaDAO.read(idPartida).getJogsGols1().remove(k);
		  		}
		  		break;
		  		
		  	case 2:
		  		
		  		for (int i = 0; i < partidaDAO.read(idPartida).getJogsCarts1().size(); i += 3) {
		  			aux = jogadorDAO.read(partidaDAO.read(idPartida).getJogsCarts1().get(i)).getCartaoAmarelo();
		  			jogadorDAO.read(partidaDAO.read(idPartida).getJogsCarts1().get(i)).setCartaoAmarelo(aux - partidaDAO.read(idPartida).getJogsCarts1().get(i+1));
		  			aux = jogadorDAO.read(partidaDAO.read(idPartida).getJogsCarts1().get(i)).getCartaoVermelho();
			  		jogadorDAO.read(partidaDAO.read(idPartida).getJogsCarts1().get(i)).setCartaoVermelho(aux - partidaDAO.read(idPartida).getJogsCarts1().get(i+2));
		  		}
		  		for (int j = 0; j < partidaDAO.read(idPartida).getJogsCarts1().size(); j ++) {
		  			partidaDAO.read(idPartida).getJogsCarts1().remove(j);
		  		}
		  		break;
		  		
		  	case 3:
			  	for (int i = 0; i < partidaDAO.read(idPartida).getJogsGols2().size(); i += 2) {
			  		aux = jogadorDAO.read(partidaDAO.read(idPartida).getJogsGols2().get(i)).getGolsQuantidade();
					jogadorDAO.read(partidaDAO.read(idPartida).getJogsGols2().get(i)).setGolsQuantidade(aux - partidaDAO.read(idPartida).getJogsGols2().get(i+1));
			  	}
			  	for (int k = 0; k < partidaDAO.read(idPartida).getJogsGols2().size(); k++) {
		  			partidaDAO.read(idPartida).getJogsGols2().remove(k);
		  		}
			  	break;
			  	
		  	case 4:
			  	for (int i = 0; i < partidaDAO.read(idPartida).getJogsCarts2().size(); i += 3) {
			  		aux = jogadorDAO.read(partidaDAO.read(idPartida).getJogsCarts2().get(i)).getCartaoAmarelo();
					jogadorDAO.read(partidaDAO.read(idPartida).getJogsCarts2().get(i)).setCartaoAmarelo(aux - partidaDAO.read(idPartida).getJogsCarts2().get(i+1));
					aux = jogadorDAO.read(partidaDAO.read(idPartida).getJogsCarts2().get(i)).getCartaoVermelho();
					jogadorDAO.read(partidaDAO.read(idPartida).getJogsCarts2().get(i)).setCartaoVermelho(aux - partidaDAO.read(idPartida).getJogsCarts2().get(i+2));
			  	}
			  	for (int k = 0; k < partidaDAO.read(idPartida).getJogsCarts2().size(); k ++) {
		  			partidaDAO.read(idPartida).getJogsCarts2().remove(k);
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
