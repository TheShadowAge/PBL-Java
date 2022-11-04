package main;
import java.util.*;
import main.model.*;
import main.model.DAO.ArbitroDAO;
import main.model.DAO.DAO;
import main.model.DAO.JogadorDAO;
import main.model.DAO.SelecaoDAO;
import main.model.DAO.TecnicoDAO;
import main.model.entities.Arbitro;
import main.model.entities.Jogador;
import main.model.entities.Selecao;
import main.model.entities.Tecnico;


///*******************************************************************************
//Autores: Gabriel Sena e Ian Gabriel
//Componente Curricular: MI - Programação
//Concluido em: 26/09/2022
//Declaramos que este código foi elaborado por nós de forma conjunta e não contém nenhum
//trecho de código de outro colega ou de outro autor, tais como provindos de livros e
//apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
//de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
//do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
//******************************************************************************************/



/**
 * Classe main do projeto.
 * @author Gabriel Sena
 * @author Ian Gabriel
 */

public class Main {
	
	/**
	 * Função que coloca a primeira letra de cada palavra em maiúscula.
	 * @param nome Nome que vai ser usado.
	 * @return Uma String com a primeira letra de cada palavra em maiúsculo.
	 */
	
	public static String PrimeiraMaiuscula(String nome) {
		nome = nome.toLowerCase();
		String primeiraLetra = nome.substring(0,1).toUpperCase();
		nome = primeiraLetra + nome.substring(1);
		return nome;
	}
	
	/**
	 * Função que mostra os grupos que as seleções podem estar.
	 */
	
	public static void mostrarGrupos() {
		System.out.println("Esses sao os grupos:");
		List<String> grupos = Arrays.asList("A","B","C","D","E","F","G","H");
		for(int i=0;i<grupos.size(); i++) {
  			System.out.println("Grupo " + grupos.get(i));
  		}
	}
	
	/**
	 * Função que pega uma lista de Strings e printa elas com um número do lado.
	 * @param lista A lista de Strings que será utilizada.
	 */
	
	public static void mostrarLista(List<String> lista) {
		for(int i=0;i<lista.size(); i++) {
  			System.out.println((i+1) + " - " + lista.get(i));
  		}
	}
	
	/**
	 * Função que mostra os jogadores de uma determinada seleção.
	 * @param idSelecao O ID da seleção que será mostrado os jogadores.
	 */
	
	public static void mostrarJogadoresSelecao(int idSelecao) {
		SelecaoDAO selecaoDAO = DAO.getSelecoes();
		System.out.println("Esses sao os jogadores inscritos:");
		  for (Jogador jogadorIterator: selecaoDAO.read(idSelecao).getJogadoresList()) {
			  System.out.println(jogadorIterator.getId() + " - " + jogadorIterator.getNome());
		  }
	}
	
	/**
	 * Função que printa os objetos de um DAO específico usando o método toString de cada classe.
	 * @param dao Um inteiro que indica qual DAO será usado para printar. 1 para jogadores, 2 para arbitros, 3 para técnicos e 4 para seleções.
	 */
	
	public static void listarDAO(int dao) {
	  SelecaoDAO selecaoDAO = DAO.getSelecoes();
	  JogadorDAO jogadorDAO = DAO.getJogadores();
	  TecnicoDAO tecnicoDAO = DAO.getTecnicos();
	  ArbitroDAO arbitroDAO = DAO.getArbitros();
	  switch (dao){
		  case 1:
			  if (jogadorDAO.readAll().size() != 0) {
				  System.out.println("Esses são os jogadores inscritos:");
				  for (Jogador jogadorIterator: jogadorDAO.readAll()) {
					  System.out.println("+----------------------------------------+");
					  System.out.println(jogadorIterator);
				  }
				  System.out.println("+----------------------------------------+");
			  } else {
				  System.out.println("Nao ha jogadores inscritos.");
			  }
			  break;
		  case 2:
			  if (arbitroDAO.readAll().size() != 0) {
				  System.out.println("Esses são os arbitros inscritos:");
				  for (Arbitro arbitroIterator: arbitroDAO.readAll()) {
					  System.out.println("+----------------------------------------+");
					  System.out.println(arbitroIterator);
				  }
				  System.out.println("+----------------------------------------+");
	  			} else {
	  				System.out.println("Nao ha arbitros inscritos.");
	  			}
			  break;
		  case 3:
			  if (tecnicoDAO.readAll().size() != 0) {
				  System.out.println("Esses são os tecnicos inscritos:");
				  for (Tecnico tecnicoIterator: tecnicoDAO.readAll()) {
					  System.out.println("+----------------------------------------+");
					  System.out.println(tecnicoIterator);
				  }
				  System.out.println("+----------------------------------------+");
	  			} else {
	  				System.out.println("Nao ha tecnicos inscritos.");
	  			}
			  break;
		  case 4:
			  if (selecaoDAO.readAll().size() != 0) {
				  System.out.println("Essas sao as selecoes inscritas:");
				  for (Selecao selecaoIterator: selecaoDAO.readAll()) {
					  System.out.println("+----------------------------------------+");
					  System.out.println(selecaoIterator);
				  }
				  System.out.println("+----------------------------------------+");
			  } else {
				  System.out.println("Nao ha selecoes inscritas.");
			  }
			  break;
	  }
	}
	
	/**
	 * Uma função parecida com a função listarDAO, mas que printa o nome dos objetos ao lado do ID do objeto.
	 * @param dao Um inteiro que indica qual DAO será usado para printar. 1 para jogadores, 2 para arbitros, 3 para técnicos e 4 para seleções.
	 */
	
	public static void listarDAOByID(int dao) {
		  SelecaoDAO selecaoDAO = DAO.getSelecoes();
		  JogadorDAO jogadorDAO = DAO.getJogadores();
		  TecnicoDAO tecnicoDAO = DAO.getTecnicos();
		  ArbitroDAO arbitroDAO = DAO.getArbitros();
		  switch (dao){
			  case 1:
				  System.out.println("Esses sao os jogadores inscritos:");
				  for (Jogador jogadorIterator: jogadorDAO.readAll()) {
					  System.out.println(jogadorIterator.getId() + " - " + jogadorIterator.getNome());
				  }
				  break;
			  case 2:
				  System.out.println("Esses sao os arbitros inscritos:");
				  for (Arbitro arbitroIterator: arbitroDAO.readAll()) {
					  System.out.println(arbitroIterator.getId() + " - " + arbitroIterator.getNome());
				  }
				  break;
			  case 3:
				  System.out.println("Esses sao os tecnicos inscritos:");
				  for (Tecnico tecnicoIterator: tecnicoDAO.readAll()) {
					  System.out.println(tecnicoIterator.getId() + " - " + tecnicoIterator.getNome());
				  }
				  break;
			  case 4:
				  System.out.println("Esses sao as selecoes inscritas:");
				  for (Selecao selecaoIterator: selecaoDAO.readAll()) {
					  System.out.println(selecaoIterator.getId() + " - " + selecaoIterator.getNome());
				  }
				  break;
		  }
		}
	
	/**
	 * Função que mostra as seleções cheias ou vazias.
	 * @param fullOrNot Um valor booleano que, se for true, vai mostrar só as seleções cheias e se for false vai mostrar só as seleções vazias.
	 */
	
  public static void mostrarSelecao(boolean fullOrNot) {
	  SelecaoDAO selecaoDAO = DAO.getSelecoes();
	  List<Selecao> listSelecoes = selecaoDAO.readAll();
	  System.out.println("Essas sao as Selecoes disponiveis:");
	  for (Selecao selecaoIterator: listSelecoes) {
		  if (fullOrNot && selecaoIterator.isFull()) {
			  System.out.println(selecaoIterator.getId() + " - " + selecaoIterator.getNome());
			}
		  else if (!(fullOrNot) && !selecaoIterator.isFull()) {
			  System.out.println(selecaoIterator.getId() + " - " + selecaoIterator.getNome());
			}
		}
	  }
  
  /**
   * Função que checa se ainda há espaço em alguma seleção para adicionar jogadores.
   * @return Retorna falso caso ainda haja espaço ou verdadeiro caso não haja espaço.
   */
  
  public static boolean isSelecoesFull() {
	  SelecaoDAO selecaoDAO = DAO.getSelecoes();
	  List<Boolean> selecoesFull = new LinkedList<Boolean>();
	  List<Selecao> listSelecoes = selecaoDAO.readAll();
	  for (Selecao selecaoIterator: listSelecoes) {
			selecoesFull.add(selecaoIterator.isFull());
		}
	  return !(selecoesFull.contains(false));
  }
  
  /**
   * Função main onde está o menu principal do código e tudo é chamado para o funcionamento do programa.
   * @param args Argumentos de console.
   */
  
  public static void main(String[] args){
	  
	  StartingEntitiesCreator.entitiesCreator();
	  
	  int opcao,opcao1,opcao2,opcao3,opcao4;
	  JogadorDAO jogadorDAO = DAO.getJogadores();
	  TecnicoDAO tecnicoDAO = DAO.getTecnicos();
	  SelecaoDAO selecaoDAO = DAO.getSelecoes();
	  ArbitroDAO arbitroDAO = DAO.getArbitros();
	  Scanner entrada = new Scanner(System.in);
	  
	  do {
		  System.out.println("   +---------+ ");
		  System.out.println("   | SysCopa | "); 
		  System.out.println("   +---------+ ");
		  System.out.println("Escolha uma opcao:");
		  System.out.println("1) Selecao");
		  System.out.println("2) Jogadores");
		  System.out.println("3) Arbitros");
		  System.out.println("4) Tecnico");
		  System.out.println("5) Sair");
		  System.out.print("Opcao: ");
		  opcao = entrada.nextInt();
		  
		  
		  switch (opcao) {
		  case 1:
			  do {
				  
				  System.out.println("   +----------+ ");
				  System.out.println("   | Selecoes | "); 
				  System.out.println("   +----------+ ");
				  System.out.println("Escolha uma opcao:");
				  System.out.println("1) Inserir");
				  System.out.println("2) Editar");
				  System.out.println("3) Excluir");
				  System.out.println("4) Listar selecoes");
				  System.out.println("5) Voltar");
				  System.out.print("Opcao: ");
				  opcao1 = entrada.nextInt();
				  switch(opcao1) {
				  	case 1:
				  		String nome, grupo;
				  		int posicaoGrupo;
				  		
				  		System.out.println("   +---------+ ");
						System.out.println("   | Inserir | "); 
						System.out.println("   +---------+ ");
				  		System.out.print("Digite o nome da selecao: ");
				  		nome = entrada.next();
				  		PrimeiraMaiuscula(nome);
				  		mostrarGrupos();
				  		System.out.print("Digite o grupo da selecao: ");
				  		grupo = entrada.next();
				  		System.out.print("Digite a posicao no grupo da Selecao [1 a 4]: ");
				  		posicaoGrupo = entrada.nextInt();
				  		Selecao selecao = new Selecao(PrimeiraMaiuscula(nome), PrimeiraMaiuscula(grupo), posicaoGrupo);
				  		selecaoDAO.create(selecao);
				  		break;
				  		
				  	case 2:
				  		String atributo;
				  		int idSelecao, selecaoEditar;
						  
						if(!selecaoDAO.readAll().isEmpty()) {
							listarDAOByID(4);
							System.out.println("Digite o id da selecao que vc deseja editar:");
							idSelecao = entrada.nextInt();
							selecao = selecaoDAO.read(idSelecao);
							if(selecao == null) {
								System.out.println("Selecao não encontrado!");
							}
							else {
								do {
									System.out.println("   +--------+ ");
									System.out.println("   | Editar | "); 
									System.out.println("   +--------+ ");
									System.out.println("1) Nome:" + selecao.getNome());
									System.out.println("2) Grupo:" + selecao.getGrupo());
									System.out.println("3) Posicao da selecao:" + selecao.getPosicaoGrupo());
									System.out.println("4) Voltar");
									System.out.print("Qual atributo deseja editar: ");
									selecaoEditar = entrada.nextInt();
									switch(selecaoEditar) {
									case 1:
										System.out.print("Digite o novo nome:");
										atributo = entrada.next();
										selecaoDAO.update(idSelecao, selecaoEditar, PrimeiraMaiuscula(atributo));
										System.out.println("Nome alterado com sucesso");
										break;
										
									case 2:
										mostrarGrupos();
										System.out.print("Digite o novo grupo:");
										atributo = entrada.next();
										selecaoDAO.update(idSelecao, selecaoEditar, PrimeiraMaiuscula(atributo));
										System.out.println("Selecao alterada com sucesso");
										break;	
										
									case 3:
										System.out.print("Digite a nova posicao da selecao no grupo:");
										atributo = entrada.next();
										selecaoDAO.update(idSelecao, selecaoEditar, atributo);
										System.out.println("Posicao da selecao alterada com sucesso");
										break;
										
									case 4:
										break;
										
									default:
										System.out.print("Atributo não encontrado");
										
									}
								} while (selecaoEditar != 4);
							}	
						}
						else {
							System.out.println("Não ha Selecaos cadastrados!");
						}
				  		break;
				  	
				  	case 3:
				  		int selecaoID;
				  		String escolha;
				  		System.out.println("Qual selecao deseja excluir? ");
				  		listarDAOByID(4);
				  		System.out.println("Digite o ID da selecao a ser excluida: ");
				  		selecaoID = entrada.nextInt();
				  		System.out.println("Tem certeza que deseja excluir a selecao " + selecaoDAO.read(selecaoID).getNome() + "?\nIsso vai excluir a selecao e todos os jogadores e o ténico dela.\nDeseja continuar? S/N");
				  		escolha = entrada.next();
				  		if (escolha.toLowerCase().equals("s")) {
				  			Selecao selecaoDelete = selecaoDAO.read(selecaoID);
				  			for (Integer jogadorIterator: selecaoDelete.getJogadores()) {
				  				jogadorDAO.delete(jogadorIterator);
				  			}
				  			tecnicoDAO.delete(selecaoDelete.getTecnico());
				  			selecaoDAO.delete(selecaoID);
				  			System.out.println("Selecao, jogadores e tecnico excluidos com sucesso!");
				  		}
				  		break;
				  		
				  	case 4:
				  		listarDAO(4);
				  	  	break;  		
				  }
			  }while (opcao1 != 5);
			break;
			
		  case 2:
			  do {
				  List<String> posicoesJogadores = Arrays.asList("Goleiro","Lateral direito","Zagueiro central","Quarto zagueiro","Meia defensivo/Volante","Lateral esquerdo","Meia atacante/Ponta direita","Meia defensivo/Segundo volante","Centroavante/Atacante","Meia armador","Meia atacante/Ponta esquerda");
				  
				  System.out.println("   +-----------+ ");
				  System.out.println("   | Jogadores | "); 
				  System.out.println("   +-----------+ ");
				  System.out.println("Escolha uma opcao:");
				  System.out.println("1) Inserir");
				  System.out.println("2) Editar");
				  System.out.println("3) Excluir");
				  System.out.println("4) Listar jogadores");
				  System.out.println("5) Voltar");
				  System.out.print("Opcao: ");
				  opcao2 = entrada.nextInt();
				  switch(opcao2) {
				  	case 1:
				  		if (!(isSelecoesFull())) {
					  		String nome, nacionalidade ,titular;
					  		int numPosicaoJogador, selecao, idade;
					  		boolean rtitular = false;
					  
					  		System.out.println("   +---------+ ");
							System.out.println("   | Inserir | "); 
							System.out.println("   +---------+ ");
					  		System.out.print("Digite o nome do jogador: ");
					  		nome = entrada.next();
					  		mostrarSelecao(false);
					  		System.out.print("Digite o numero da selecao do Jogador: ");
					  		selecao = entrada.nextInt();
					  		System.out.println("Essas sao as posicoes dos jogadores:");
					  		mostrarLista(posicoesJogadores);
					  		System.out.println("Digite o numero da posicao  do jogador: ");
					  		numPosicaoJogador = entrada.nextInt();
					  		System.out.print("Digite a quantidade de cartoes Amarelos do jogador: ");
					  		cartaoAmarelo = entrada.nextInt();
					  		System.out.print("Digite a quantidade de cartoes Vermelhos do jogador: ");
					  		cartaoVermelho = entrada.nextInt();
					  		System.out.println("Digite a idade do jogador: ");
					  		idade = entrada.nextInt();
					  		System.out.println("Digite a nacionalidade do jogador: ");
					  		nacionalidade = entrada.next();
					  		System.out.println("O jogador e titular? [Sim/Nao]:");
					  		titular = entrada.next();
					  		if (titular.equals("Sim")) {
					  			rtitular = true;
					  		}
					  		else if (titular.equals("Nao")) {
					  			rtitular = false;
					  		}
					  		else {
					  			System.out.print("entrada invalida");
					  		}
					  		System.out.print("Digite a quantidade de gols do jogador: ");
					  		gols = entrada.nextInt();
					  		Jogador jogador = new Jogador(PrimeiraMaiuscula(nome), selecao, PrimeiraMaiuscula(nacionalidade), idade, posicoesJogadores.get(numPosicaoJogador-1), rtitular);
					  		jogadorDAO.create(jogador);
				  		} else {
				  			System.out.println("Não ha espaço nas seleções para um novo jogador.\nFavor criar uma nova selecao ou remover um jogador.");
				  		}
				  		break;
				  	
				  	case 2:
				  		String atributo;
				  		int idJogador, jogadorEditar;
						  
						if(!jogadorDAO.readAll().isEmpty()) {
							listarDAOByID(1);
							System.out.println("Digite o id do jogador que vc deseja editar:");
							idJogador = entrada.nextInt();
							Jogador jogador = jogadorDAO.read(idJogador);
							if(jogador == null) {
								System.out.println("Jogador não encontrado!");
							}
							else {
								do {
									int numAtributo;
									String titular = ((jogador.isTitular() == true) ? "Sim" : "Nao");
									
									System.out.println("   +--------+ ");
									System.out.println("   | Editar | "); 
									System.out.println("   +--------+ ");
									System.out.println("1) Nome:" + jogador.getNome());
									System.out.println("2) Selecao:" + jogador.getSelecao().getNome());
									System.out.println("3) Posicao:" + jogador.getPosicao());
									System.out.println("4) Quantidade de cartoes amarelos:" + jogador.getCartaoAmarelo());
									System.out.println("5) Quantidade de cartoes Vermelhos:" + jogador.getCartaoAmarelo());
									System.out.println("6) Idade:" + jogador.getIdade());
									System.out.println("7) Nacionalide:" + jogador.getNacionalidade());
									System.out.println("8) Titular:" + titular);
									System.out.println("9) gols:" + jogador.getGolsQuantidade());
									System.out.println("10) Voltar");
									System.out.print("Qual atributo deseja editar: ");
									jogadorEditar = entrada.nextInt();
									switch(jogadorEditar) {
									case 1:
										System.out.print("Digite o novo nome:");
										atributo = entrada.next();
										jogadorDAO.update(idJogador, jogadorEditar, atributo);
										System.out.println("Nome alterado com sucesso");
										break;
										
									case 2:
										mostrarSelecao(false);
										System.out.print("Digite a nova selecao:");
										atributo = entrada.next();
										selecaoDAO.update(jogador.getSelecao().getId(), 6, String.valueOf(jogador.getId()));
										jogadorDAO.update(idJogador, jogadorEditar, atributo);
										selecaoDAO.update(jogador.getSelecao().getId(), 5, String.valueOf(jogador.getId()));
										System.out.println("Selecao alterada com sucesso");
										break;	
										
									case 3:
										mostrarLista(posicoesJogadores);
										System.out.print("Digite o numero da nova Posicao:");
										numAtributo = entrada.nextInt();
										jogadorDAO.update(idJogador, jogadorEditar, posicoesJogadores.get(numAtributo-1));
										System.out.println("Posicao alterada com sucesso");
										break;
										
									case 4:
										System.out.print("Digite a nova quantidade de cartões amarelos:");
										atributo = entrada.next();
										jogadorDAO.update(idJogador, jogadorEditar, atributo);
										System.out.println("Quantidade de cartoes amarelos alterada com sucesso");
										break;
										
									case 5:
										System.out.print("Digite a nova quantidade de cartões vermelhos:");
										atributo = entrada.next();
										jogadorDAO.update(idJogador, jogadorEditar, atributo);
										System.out.println("Quantidade de cartoes vermelhos alterada com sucesso");
										break;
										
									case 6:
										System.out.print("Digite a nova idade:");
										atributo = entrada.next();
										jogadorDAO.update(idJogador, jogadorEditar, atributo);
										System.out.println("Idade alterada com sucesso");
										break;
										
									case 7:
										System.out.print("Digite a nova nacionalidade:");
										atributo = entrada.next();
										jogadorDAO.update(idJogador, jogadorEditar, atributo);
										System.out.println("Nacionalidade alterada com sucesso");
										break;
									case 8:
										System.out.print("Digite se o jogador e titular:");
										atributo = entrada.next();
										jogadorDAO.update(idJogador, jogadorEditar, atributo);
										System.out.println("Titular alterado com sucesso");
										break;
										
									case 9:
										System.out.print("Digite a nova Quantidade de gols:");
										atributo = entrada.next();
										jogadorDAO.update(idJogador, jogadorEditar, atributo);
										System.out.println("Quantidade de gols alterada com sucesso");
										break;
										
									case 10:
										break;
										
									default:
										System.out.print("Atributo nao encontrado");
										
									}
								} while (jogadorEditar != 10);
							}
						} 
						else {
							System.out.println("Nao ha jogadores cadastrados!");
						}
				  		break;
				  	case 3:
				  		int selecaoID, jogadorID;
				  		String escolha;
				  		listarDAOByID(4);
				  		System.out.println("Digite o ID da selecao para excluir jogadores: ");
				  		selecaoID = entrada.nextInt();
				  		mostrarJogadoresSelecao(selecaoID);
				  		System.out.println("Digite o ID do jogador que deseja excluir: ");
				  		jogadorID = entrada.nextInt();
				  		System.out.println("Voce tem certeza que deseja excluir o jogador " + jogadorDAO.read(jogadorID).getNome() + "? S/N ");
				  		escolha = entrada.next().toLowerCase();
				  		if (escolha.equals("s")) {
				  			jogadorDAO.delete(jogadorID);
				  			selecaoDAO.update(selecaoID, 6, Integer.toString(jogadorID));
				  			System.out.println("Jogador deletado com sucesso!");
				  		}
				  		break;
				  	case 4:
				  		listarDAO(1);
				  		break;
				  		
				  }
			  } while (opcao2 != 5);
	       	break;
	      
	       	
		  case 3:
			  do {
				  List<String> tipoArbitro = Arrays.asList("arbitro de vídeo","arbitro","arbitro auxiliar");
				  
				  System.out.println("   +----------+ ");
				  System.out.println("   | Arbitros | "); 
				  System.out.println("   +----------+ ");
				  System.out.println("Escolha uma opcao:");
				  System.out.println("1) Inserir");
				  System.out.println("2) Editar");
				  System.out.println("3) Excluir");
				  System.out.println("4) Listar");
				  System.out.println("5) Voltar");
				  System.out.print("Opcao: ");
				  opcao3 = entrada.nextInt();
				  switch(opcao3) {
				  	case 1:
				  		String nome, nacionalidade;
				  		int idade, numTipo;
				  		
				  		System.out.println("   +---------+ ");
						System.out.println("   | Inserir | "); 
						System.out.println("   +---------+ ");
				  		System.out.print("Digite o nome do arbitro: ");
				  		nome = entrada.next();
				  		System.out.print("Digite a idade do arbitro: ");
				  		idade = entrada.nextInt();
				  		System.out.print("Digite a nacionalidade do arbitro: ");
				  		nacionalidade = entrada.next();
				  		System.out.println("Essas sao os tipos de arbitros:");
				  		mostrarLista(tipoArbitro);
				  		System.out.print("Digite o numero do tipo de arbitro: ");
				  		numTipo = entrada.nextInt();
				  		Arbitro arbitro = new Arbitro(nome, nacionalidade, tipoArbitro.get(numTipo-1), idade);
				  		arbitroDAO.create(arbitro);
				  		break;
				  	
				  	case 2:
				  		String atributo;
				  		int idArbitro, arbitroEditar, numAtributo;
				  		
				  		
						if(!arbitroDAO.readAll().isEmpty()) {
							listarDAOByID(2);
							System.out.println("Digite o id do arbitro que vc deseja editar:");
							idArbitro = entrada.nextInt();
							arbitro = arbitroDAO.read(idArbitro);
							if(arbitro == null) {
								System.out.println("Arbitro nao encontrado!");
							}
							else {
								do {
									System.out.println("   +--------+ ");
									System.out.println("   | Editar | "); 
									System.out.println("   +--------+ ");
									System.out.println("1) Nome:" + arbitro.getNome());
									System.out.println("2) Idade:" + arbitro.getIdade());
									System.out.println("3) Nacionalidade:" + arbitro.getNacionalidade());
									System.out.println("4) Tipo:" + arbitro.getTipo());
									System.out.println("5) Voltar");
									System.out.print("Qual atributo deseja editar: ");
									arbitroEditar = entrada.nextInt();
									switch(arbitroEditar) {
									case 1:
										System.out.print("Digite o novo nome:");
										atributo = entrada.next();
										arbitroDAO.update(idArbitro, arbitroEditar, PrimeiraMaiuscula(atributo));
										System.out.println("Nome alterado com sucesso");
										break;
										
									case 2:
										System.out.print("Digite a nova idade:");
										atributo = entrada.next();
										arbitroDAO.update(idArbitro, arbitroEditar, atributo);
										System.out.println("Idade alterada com sucesso");
										break;
										
									case 3:
										System.out.print("Digite a nova nacionalidade:");
										atributo = entrada.next();
										arbitroDAO.update(idArbitro, arbitroEditar, PrimeiraMaiuscula(atributo));
										System.out.println("Nacionalidade alterada com sucesso");
										break;
										
									case 4:
										mostrarLista(tipoArbitro);
										System.out.print("Digite o novo tipo:");
										numAtributo = entrada.nextInt();
										arbitroDAO.update(idArbitro, arbitroEditar, tipoArbitro.get(numAtributo-1));
										System.out.println("Idade alterada com sucesso");
										
									case 5:
										break;
										
									default:
										System.out.println("Atributo nao encontrado");
									}
								} while (arbitroEditar != 5);
							}
						} 
						else {
							System.out.println("Nao ha Arbitros cadastrados!");
						}
				  		break;
				  	case 3:
				  		int arbitroID;
				  		String escolha;
				  		listarDAOByID(2);
				  		System.out.println("Digite o ID do arbitro que deseja excluir: ");
				  		arbitroID = entrada.nextInt();
				  		System.out.println("Voce tem certeza que deseja excluir o arbitro " + arbitroDAO.read(arbitroID).getNome() + "? S/N ");
				  		escolha = entrada.next().toLowerCase();
				  		if (escolha.equals("s")) {
				  			arbitroDAO.delete(arbitroID);
				  			System.out.println("Arbitro deletado com sucesso!");
				  		}
				  		break;
				  	case 4:
				  		listarDAO(2);
				  		break;
				  }
			  } while (opcao3 != 5);
			break;
			
		  case 4:
			  do {
				  System.out.println("   +---------+ ");
				  System.out.println("   | Tecnico | "); 
				  System.out.println("   +---------+ ");
				  System.out.println("Escolha uma opcao:");
				  System.out.println("1) Inserir");
				  System.out.println("2) Editar");
				  System.out.println("3) Excluir");
				  System.out.println("4) Listar Tecnicos");
				  System.out.println("5) Voltar");
				  System.out.print("Opcao: ");
				  opcao4 = entrada.nextInt();
				  switch(opcao4) {
				  	case 1:
				  		String nome, nacionalidade, timeAnterior;
				  		int idade, selecao;
				  		
				  		System.out.println("   +---------+ ");
						System.out.println("   | Inserir | "); 
						System.out.println("   +---------+ ");
				  		System.out.print("Digite o nome do tecnico: ");
				  		nome = entrada.next();
				  		mostrarSelecao(false);
				  		System.out.print("Digite o numero da selecao do tecnico: ");
				  		selecao = entrada.nextInt();
				  		System.out.print("Digite a idade do Tecnico: ");
				  		idade = entrada.nextInt();
				  		System.out.print("Digite a nacionalidade do tecnico: ");
				  		nacionalidade = entrada.next();
				  		System.out.print("Digite o time anterior do tecnico: ");
				  		timeAnterior = entrada.next();
				  		Tecnico tecnico = new Tecnico(PrimeiraMaiuscula(nacionalidade), selecao, PrimeiraMaiuscula(timeAnterior), PrimeiraMaiuscula(nome), idade);
				  		tecnicoDAO.create(tecnico);
				  		break;
				  		
				  	case 2:
				  		int idTecnico, tecnicoEditar;
				  
						if(!tecnicoDAO.readAll().isEmpty()) {
							listarDAOByID(3);
							System.out.println("Digite o id do tecnico que vc deseja editar:");
							idTecnico = entrada.nextInt();
							tecnico = tecnicoDAO.read(idTecnico);
							if(tecnico == null) {
								System.out.println("Tecnico nao encontrado!");
							}
							else {
								do {
									String atributo;
									System.out.println("   +--------+ ");
									System.out.println("   | Editar | "); 
									System.out.println("   +--------+ ");
									System.out.println("1) Nome:" + tecnico.getNome());
									System.out.println("2) Selecao:" + tecnico.getSelecao().getNome());
									System.out.println("3) Idade:" + tecnico.getIdade());
									System.out.println("4) Nacionalidade:" + tecnico.getNacionalidade());
									System.out.println("5) Time anterior:" + tecnico.getTimeAnterior());
									System.out.println("6) Voltar");
									System.out.print("Qual atributo deseja editar: ");
									tecnicoEditar = entrada.nextInt();
									switch(tecnicoEditar) {
									case 1:
										System.out.print("Digite o novo nome:");
										atributo = entrada.next();
										tecnicoDAO.update(idTecnico, tecnicoEditar, PrimeiraMaiuscula(atributo));
										System.out.println("Nome alterado com sucesso");
										break;
										
									case 2:
										mostrarSelecao(false);
										System.out.print("Digite a nova selecao:");
										atributo = entrada.next();
										selecaoDAO.update(tecnico.getSelecao().getId(), 4, String.valueOf(-1));
										tecnicoDAO.update(idTecnico, tecnicoEditar, atributo);
										selecaoDAO.update(tecnico.getSelecao().getId(), 4, String.valueOf(tecnico.getId()));
										System.out.println("Selecao alterada com sucesso");
										break;	
										
									case 3:
										System.out.print("Digite a nova idade:");
										atributo = entrada.next();
										tecnicoDAO.update(idTecnico, tecnicoEditar, atributo);
										System.out.println("Idade alterada com sucesso");
										break;
										
									case 4:
										System.out.print("Digite a nova nacionalidade:");
										atributo = entrada.next();
										tecnicoDAO.update(idTecnico, tecnicoEditar, PrimeiraMaiuscula(atributo));
										System.out.println("Nacionalidade alterada com sucesso");
										break;
										
									case 5:
										System.out.print("Digite o novo time anterior:");
										atributo = entrada.next();
										tecnicoDAO.update(idTecnico, tecnicoEditar, PrimeiraMaiuscula(atributo));
										System.out.println("time anterior alterado com sucesso");
										
									case 6:
										break;
										
									default:
										System.out.println("Atributo nao encontrado");
									}	
								} while (tecnicoEditar != 6);
							}
						} 
						else {
							System.out.println("Nao ha Tecnicos cadastrados!");
						}
						break;
				  	case 3:
				  		int tecnicoID;
				  		String escolha;
				  		listarDAOByID(3);
				  		System.out.println("Digite o ID do tecnico que deseja excluir: ");
				  		tecnicoID = entrada.nextInt();
				  		System.out.println("Voce tem certeza que deseja excluir o tecnico " + tecnicoDAO.read(tecnicoID).getNome() + "? S/N ");
				  		escolha = entrada.next().toLowerCase();
				  		if (escolha.equals("s")) {
				  			tecnicoDAO.read(tecnicoID).getSelecao().setTecnico(-1);
				  			tecnicoDAO.delete(tecnicoID);
				  			System.out.println("Tecnico deletado com sucesso!");
				  		}
				  		break;
				  	case 4:
				  		listarDAO(3);
				  		break;
				  							
				  }
			  } while (opcao4 != 5);
			break;
			
		  case 5:
			System.out.println(" ");
			System.out.println("Fim do programa!!!");
			System.exit(0);
			break;
			
		  default:
			System.out.println("O numero invalido! Digite um numero entre 1 a 5.");
		  }
	  }while (opcao != 5);
	 entrada.close();
  }
}