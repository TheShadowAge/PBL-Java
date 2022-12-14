package pbl.controller.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import pbl.model.DAO.DAO;
import pbl.model.DAO.JogadorDAO;
import pbl.model.DAO.PartidaDAO;
import pbl.model.DAO.SelecaoDAO;
import pbl.model.entities.Jogador;
import pbl.model.entities.JogadorCartoes;
import pbl.model.entities.JogadorGols;
import pbl.model.entities.ListGolsCart;
import pbl.model.entities.Partida;
import pbl.model.entities.Selecao;

public class ControllerPartida {
	
	/**
	 * Metodo que envia dados para criação da Partida.
	 * @param nome Nome da partida.
	 * @param data  Data da partida.
	 * @param horario Horario da partida.
	 * @param local Local da partida.
	 * @param time1 Primeiro time da partida.
	 * @param golsTime1 Quantidade de gols que o primeiro time fez na partida.
	 * @param cartAmaTime1 Quantidade de cartões amarelos que o primeiro time recebeu na partida.
	 * @param cartVerTime1 Quantidade de cartões vermelhos que o primeiro time recebeu na partida.
	 * @param time2 Segundo time da partida.
	 * @param golsTime2 Quantidade de gols que o segundo time fez na partida.
	 * @param cartAmaTime2 Quantidade de cartões amarelos que o segundo time recebeu na partida.
	 * @param cartVerTime2 Quantidade de cartões vermelhos que o segundo time recebeu na partida.
	 * @param jogsGols1 Lista de id e quantidade de gols que cada jogador do time 1 fez na partida.
	 * @param jogsGols2 Lista com id e quantidade de gols que cada jogador do time 2 fez na partida.
	 * @param jogsCarts1 Lista com id e quantidade de cartões vermelhos e amarelos que cada jogador do time 1 recebeu na partida.
	 * @param jogsCarts2 Lista com id e quantidade de cartões vermelhos e amarelos que cada jogador do time 2 recebeu na partida.
	 */
	
	public static void createPartida(String nome, LocalDate data, LocalTime horario,String local, int time1, int golsTime1, int cartAmaTime1, int cartVerTime1, int time2, int golsTime2, int cartAmaTime2, int cartVerTime2, List<JogadorGols> jogsGols1, List<JogadorGols> jogsGols2, List<JogadorCartoes> jogsCarts1, List<JogadorCartoes> jogsCarts2) {
		  PartidaDAO partidaDAO = DAO.getPartidas();
		  Partida partida = new Partida(nome,data,horario,local,time1, golsTime1, cartAmaTime1, cartVerTime1, time2, golsTime2, cartAmaTime2, cartVerTime2, jogsGols1, jogsGols2, jogsCarts1, jogsCarts2);
		  partidaDAO.create(partida);
	  }
	
	/**
	 * Metodo cria objeto com id e jogador.
	 * @param idJogador id do jogador.
	 * @param gols quantidade de gols do jogador.
	 * @return objeto com id e gols
	 */
	
	public static Object createJogadorGols(int idJogador, int gols) {
		JogadorGols jogGols = new JogadorGols(idJogador, gols);
		return jogGols;
	}
	
	/**
	 * Metodo que cria objeto com id e jogador.
	 * @param idJogador id do jogador.
	 * @param cartAma quantidade de cartões amarelos.
	 * @param cartVer quantidade de cartões vermelhos.
	 * @return objeto com id, quantidade de cartões amarelos e quantidade de cartões vermelhos.
	 */
	
	public static Object createJogadorCartoes(int idJogador, int cartAma,int cartVer) {
		JogadorCartoes jogCarts = new JogadorCartoes(idJogador, cartAma, cartVer);
		return jogCarts;
	}
	
	/**
	 * Metodo que envia dados para edição do partida.
	 * @param idPartida um inteiro com o id da partida que será editado.
	 * @param partidaEditar um inteiro com a opção de edição
	 * @param atributo uma string com o atributo que sera editado.
	 */
	
	public static void updatePartida(int idPartida, int partidaEditar,String atributo) {
		  PartidaDAO partidaDAO = DAO.getPartidas();
		  partidaDAO.update(idPartida, partidaEditar, atributo);	  
	  }
	
	/**
	 * Metodo que envia dados para edição de listar partida.
	 * @param idPartida um inteiro com o id da partida que será editado.
	 * @param partidaEditar um inteiro com a opção de edição.
	 * @param lista uma lista com objeto.
	 */
	
	public static void updateListPartida(int idPartida, int partidaEditar, ListGolsCart lista) {
		  PartidaDAO partidaDAO = DAO.getPartidas();
		  partidaDAO.updateList(idPartida, partidaEditar, lista);	  
	  }
	
	/**
	 * Metodo que envia dados para remoção da partida.
	 * @param id um inteiro com o id da partida que será removido.
	 */
	
	public static void deletePartida(int id) {
		PartidaDAO partidaDAO = DAO.getPartidas();
		limparDadosJogador(id,1);
		limparDadosJogador(id,2);
		limparDadosJogador(id,3);
		limparDadosJogador(id,4);
		partidaDAO.delete(id);
	}
	
	/**
	 * Metodo que lista as selecoes que são do mesmo grupo.
	 * @param id inteiro com id da partida
	 * @return uma lista com os dados
	 */
	
	  public static List<String> listarSelecaoPartida(int id) {
		  List<String> lista = new LinkedList<String>();
		  SelecaoDAO selecaoDAO = DAO.getSelecoes();
		  lista.add("Esses sao as selecoes inscritas:");
		  for (Selecao selecaoIterator: selecaoDAO.readAll()) {
			  if (selecaoIterator.getId() != id) {
				  if (selecaoIterator.getGrupo() == selecaoDAO.read(id).getGrupo()) {
			  	lista.add(selecaoIterator.getId() + " - " + selecaoIterator.getNome());
				  }
			  }
		  }
		  return lista;
	  }
	
	  /**
	   * Metodo que cria o nome da partida.
	   * @param time1 id do time 1.
	   * @param time2 id do time 2.
	   * @return o nome da partida.
	   */
	  
	public static String nomePartida(int time1, int time2) {
		 SelecaoDAO selecaoDAO = DAO.getSelecoes();
		 String nome = selecaoDAO.read(time1).getNome() + " vs " + selecaoDAO.read(time2).getNome();
		 return nome;
	  }
	  
	/**
	 * formata a data da partida.
	 * @param data String com a data da partida.
	 * @return a data formada.
	 */
	
	  public static LocalDate formatarData(String data) {
		  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		  LocalDate localDate = LocalDate.parse(data, formatter);
		  return localDate;
	  }
	  
	  /**
	   * formata o horario da partida.
	   * @param horario String com o horario da partida.
	   * @return o horario formatado.
	   */
	  
	  public static LocalTime formatarHorario(String horario) {
		  DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_TIME;
		  LocalTime localTime = LocalTime.parse(horario, formatter);
		  return localTime;
		  }
	  
	  /**
	   * lista os jogadores de uma selecao
	   * @param id inteiro com id da selaçao
	   * @return lista com todos os jogadores de uma selecao
	   */
	  
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
	  
	  /**
	   * Metodo que adiciona gols, cartoes amarelos e cartoes vermelhos ao jogador.
	   * @param idJog inteiro com id do jogador.
	   * @param opcao inteiro com a opcao.
	   * @param atributo inteiro com o atributo.
	   */
	  
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
	  
	  /**
	   * Limpa a lista que armazena dados do jogador na partida.
	   * @param idPartida inteiro com id da partida.
	   * @param opcao inteiro com a opcao que levara a limpeza de 1 das listas.
	   */
	  
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
		  			partidaDAO.read(idPartida).getJogsGols1().clear();
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
	  
	  /**
	   * Retorna o id de 1 das selecoes da partida.
	   * @param id inteiro com o id da partida
	   * @param opcao inteiro com a opcao. 1 primeiro time e 2 segundo time.
	   * @return retorna o id da selecao.
	   */
	  
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
