package main;
import java.util.*;
import main.model.*;

public class Main {
	
  public static void mostrarSelecao() {
		SelecaoDAO selecaoDAO = DAO.getSelecoes();
		List<Selecao> listSelecoes = selecaoDAO.readAll();
		System.out.println("Essas sao as Selecoes inscritas:");
		for (Selecao selecaoIterator: listSelecoes) {
			System.out.println(selecaoIterator.getId() + "-" + selecaoIterator.getNome());
		}
  }
  
  public static void mostrarSelecao(boolean fullOrNot) {
	  SelecaoDAO selecaoDAO = DAO.getSelecoes();
		List<Selecao> listSelecoes = selecaoDAO.readAll();
		System.out.println("Essas sao as Selecoes inscritas:");
		for (Selecao selecaoIterator: listSelecoes) {
			if (fullOrNot && selecaoIterator.isFull()) {
				System.out.println(selecaoIterator.getId() + "-" + selecaoIterator.getNome());
			}
			else if (!(fullOrNot) && !selecaoIterator.isFull()) {
				System.out.println(selecaoIterator.getId() + "-" + selecaoIterator.getNome());
			}
		}
	  }
  
  public static boolean isSelecoesFull() {
	  SelecaoDAO selecaoDAO = DAO.getSelecoes();
	  Set<Boolean> selecoesFull = new HashSet<Boolean>();
	  List<Selecao> listSelecoes = selecaoDAO.readAll();
	  for (Selecao selecaoIterator: listSelecoes) {
			selecoesFull.add(selecaoIterator.isFull());
		}
	  return selecoesFull.contains(false);
  }
	
  public static void main(String[] args){
	  
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
				  		List<String> posicoesGrupos = Arrays.asList("A","B","C","D","E","F","G","H");
				  		
				  		System.out.println("   +---------+ ");
						System.out.println("   | Inserir | "); 
						System.out.println("   +---------+ ");
				  		System.out.print("Digite o nome da selecao: ");
				  		nome = entrada.next();
				  		System.out.println("Esses são os grupos:");
				  		for(int i=0;i<posicoesGrupos.size(); i++) {
				  			System.out.println("Grupo" + posicoesGrupos.get(i));
				  		}
				  		System.out.print("Digite o grupo da selecao: ");
				  		grupo = entrada.next();
				  		System.out.print("Digite a posicao no grupo da Selecao [1 a 4]: ");
				  		posicaoGrupo = entrada.nextInt();
				  		Selecao selecao = new Selecao(nome, grupo, posicaoGrupo);
				  		selecaoDAO.create(selecao);
				  		break;
				  		
				  	case 2:
				  		int idSelecao, selecaoEditar;
						  
						if(!selecaoDAO.readAll().isEmpty()) {
							List<Selecao> listSelecao = selecaoDAO.readAll();
							System.out.println("Essas sao as selecoes cadastradas:");
							for (Selecao selecaoIterator: listSelecao) {
								System.out.println(selecaoIterator.getId() + "-" + selecaoIterator.getNome());
							}
							System.out.println("Digite a selecao que vc deseja editar:");
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
									System.out.println("3) Posicao do grupo:" + selecao.getPosicaoGrupo());
									System.out.println("4) Voltar");
									selecaoEditar = entrada.nextInt();
								} while (selecaoEditar != 4);
							}
						} 
						else {
							System.out.println("Não ha Selecaos cadastrados!");
						}
				  		break;
				  		
				  	case 4:
				  		mostrarSelecao();
				  	  	break;  		
				  }
			  }while (opcao1 != 5);
			break;
			
		  case 2:
			  do {
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
					  		int numPosicaoJogador, selecao,cartaoAmarelo, cartaoVermelho, idade, gols;
					  		boolean rtitular;
					  		List<String> posicoesJogadores = Arrays.asList("Goleiro","Lateral direito","Zagueiro central","Quarto zagueiro","Meia defensivo/Volante","Lateral esquerdo","Meia atacante/Ponta direita","Meia defensivo/Segundo volante","Centroavante/Atacante","Meia armador","Meia atacante/Ponta esquerda");
					  	  
					  		System.out.println("   +---------+ ");
							System.out.println("   | Inserir | "); 
							System.out.println("   +---------+ ");
					  		System.out.print("Digite o nome do jogador: ");
					  		nome = entrada.next();
					  		mostrarSelecao(false);
					  		System.out.print("Digite o numero da selecao do Jogador: ");
					  		selecao = entrada.nextInt();
					  		System.out.println("Essas são as posicoes dos jogadores:");
					  		for(int i=0;i<posicoesJogadores.size(); i++) {
					  			System.out.println((i+1) + " - " + posicoesJogadores.get(i));
					  		}
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
					  		System.out.println("Digite se o jogador e titular ou reserva: ");
					  		titular = entrada.next();
					  		rtitular = false;
					  		while(rtitular) {
					  			switch(titular) {
					  				case "titular":
					  					rtitular = true;
					  					break;
					  				case "reserva":
					  					rtitular = false;
					  					break;
					  			}
					  		}
					  		System.out.print("Digite a quantidade de gols do jogador: ");
					  		gols = entrada.nextInt();
					  		Jogador jogador = new Jogador(nome, selecao, nacionalidade, idade, posicoesJogadores.get(numPosicaoJogador-1), cartaoAmarelo, cartaoVermelho, gols, rtitular);
					  		jogadorDAO.create(jogador);
				  		} else {
				  			System.out.println("Não ha espaço nas seleções para um novo jogador.\nFavor criar uma nova selecao ou remover um jogador.");
				  		}
				  		break;
				  	
				  	case 2:
				  		int idJogador, jogadorEditar;
						  
						if(!jogadorDAO.readAll().isEmpty()) {
							List<Jogador> listJogador = jogadorDAO.readAll();
							System.out.println("Esses sao os jogadors cadastrados:");
							for (Jogador jogadorIterator: listJogador) {
								System.out.println(jogadorIterator.getId() + "-" + jogadorIterator.getNome());
							}
							System.out.println("Digite a jogador que vc deseja editar:");
							idJogador = entrada.nextInt();
							Jogador jogador = jogadorDAO.read(idJogador);
							if(jogador == null) {
								System.out.println("Jogador não encontrado!");
							}
							else {
								do {
									System.out.println("   +--------+ ");
									System.out.println("   | Editar | "); 
									System.out.println("   +--------+ ");
									System.out.println("1) Nome:" + jogador.getNome());
									System.out.println("2) Selecao:" + jogador.getSelecao());
									System.out.println("3) Posicao:" + jogador.getPosicao());
									System.out.println("4) Quantidade de cartões amarelos:" + jogador.getCartaoAmarelo());
									System.out.println("5) Quantidade de cartões Vermelhos:" + jogador.getCartaoAmarelo());
									System.out.println("6) Idade:" + jogador.getIdade());
									System.out.println("7) Nacionalide:" + jogador.getNacionalidade());
									System.out.println("8) Titular:" + jogador.isTitular());
									System.out.println("9) gols:" + jogador.getGolsQuantidade());
									System.out.println("10) Voltar");
									jogadorEditar = entrada.nextInt();
								} while (jogadorEditar != 10);
							}
						} 
						else {
							System.out.println("Não ha Jogadores cadastrados!");
						}
				  		break;
				  		
				  }
			  } while (opcao2 != 5);
	       	break;
	      
	       	
		  case 3:
			  do {
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
				  		List<String> tipoArbitro = Arrays.asList("arbitro de vídeo","arbitro","arbitro auxiliar");
				  		
				  		System.out.println("   +---------+ ");
						System.out.println("   | Inserir | "); 
						System.out.println("   +---------+ ");
				  		System.out.print("Digite o nome do arbitro: ");
				  		nome = entrada.next();
				  		System.out.print("Digite a idade do arbitro: ");
				  		idade = entrada.nextInt();
				  		System.out.print("Digite a nacionalidade do arbitro: ");
				  		nacionalidade = entrada.next();
				  		System.out.println("Essas são os tipos de arbitros:");
				  		for(int i=0;i<tipoArbitro.size(); i++) {
				  			System.out.println((i+1) + " - " + tipoArbitro.get(i));
				  		}
				  		System.out.print("Digite o numero do tipo de arbitro: ");
				  		numTipo = entrada.nextInt();
				  		Arbitro arbitro = new Arbitro(nome, nacionalidade, tipoArbitro.get(numTipo-1), idade);
				  		arbitroDAO.create(arbitro);
				  		break;
				  	
				  	case 2:
				  		int idArbitro, arbitroEditar;
						  
						if(!arbitroDAO.readAll().isEmpty()) {
							List<Arbitro> listArbitro = arbitroDAO.readAll();
							System.out.println("Esses sao os arbitros cadastrados:");
							for (Arbitro arbitroIterator: listArbitro) {
								System.out.println(arbitroIterator.getId() + "-" + arbitroIterator.getNome());
							}
							System.out.println("Digite a arbitro que vc deseja editar:");
							idArbitro = entrada.nextInt();
							arbitro = arbitroDAO.read(idArbitro);
							if(arbitro == null) {
								System.out.println("Arbitro não encontrado!");
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
									arbitroEditar = entrada.nextInt();
								} while (arbitroEditar != 5);
							}
						} 
						else {
							System.out.println("Não ha Arbitros cadastrados!");
						}
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
				  		mostrarSelecao();
				  		System.out.print("Digite o numero da selecao do tecnico: ");
				  		selecao = entrada.nextInt();
				  		System.out.print("Digite a idade do Tecnico: ");
				  		idade = entrada.nextInt();
				  		System.out.print("Digite a nacionalidade do tecnico: ");
				  		nacionalidade = entrada.next();
				  		System.out.print("Digite o time anterior do tecnico: ");
				  		timeAnterior = entrada.next();
				  		Tecnico tecnico = new Tecnico(nacionalidade, selecao, timeAnterior, nome, idade);
				  		tecnicoDAO.create(tecnico);
				  		break;
				  		
				  	case 2:
				  		int idTecnico, tecnicoEditar;
				  
						if(!tecnicoDAO.readAll().isEmpty()) {
							List<Tecnico> listSelecoes = tecnicoDAO.readAll();
							System.out.println("Esses sao os tecnicos cadastrados:");
							for (Tecnico tecnicoIterator: listSelecoes) {
								System.out.println(tecnicoIterator.getId() + "-" + tecnicoIterator.getNome());
							}
							System.out.println("Digite o id do tecnico que vc deseja editar:");
							idTecnico = entrada.nextInt();
							tecnico = tecnicoDAO.read(idTecnico);
							if(tecnico == null) {
								System.out.println("Tecnico não encontrado!");
							}
							else {
								do {
									System.out.println("   +--------+ ");
									System.out.println("   | Editar | "); 
									System.out.println("   +--------+ ");
									System.out.println("1) Nome:" + tecnico.getNome());
									System.out.println("2) Selecao:" + tecnico.getSelecao());
									System.out.println("3) Idade:" + tecnico.getIdade());
									System.out.println("4) Nacionalidade:" + tecnico.getNacionalidade());
									System.out.println("5) Time anterior:" + tecnico.getTimeAnterior());
									System.out.println("6) Voltar");
									tecnicoEditar = entrada.nextInt();
								} while (tecnicoEditar != 6);
							}
						} 
						else {
							System.out.println("Nao ha Tecnicos cadastrados!");
						}
						
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
		  // aqui vai utilizar um comando pra limpar o console (ainda não sei como vou fazer isso mas depois faço)
	  }while (opcao != 5);
	  
	  entrada.close();
  }
  
  
}