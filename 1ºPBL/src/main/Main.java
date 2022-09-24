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
  
  public static void mostrarSelecao( boolean fullOrNot) {
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
				  		System.out.print("Digite o grupo da selecao: ");
				  		grupo = entrada.next();
				  		System.out.println("Essas são as posicoes dos grupos:");
				  		for(int i=0;i<posicoesGrupos.size(); i++) {
				  			System.out.println("Grupo" + posicoesGrupos.get(i));
				  		}
				  		System.out.print("Digite a posicao no grupo da Selecao: ");
				  		posicaoGrupo = entrada.nextInt();
				  		Selecao selecao = new Selecao(nome, grupo, posicaoGrupo);
				  		selecaoDAO.create(selecao);
				  		break;
				  	case 4:
				  		mostrarSelecao(selecaoDAO);
				  	  			  		
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
					  		System.out.println("Digite se o jogador é titular ou reserva: ");
					  		titular = entrada.next();
					  			if(titular.equals("titular"))
					  				rtitular = true;
					  			else
					  				rtitular = false;
					  		System.out.print("Digite a quantidade de gols do jogador: ");
					  		gols = entrada.nextInt();
					  		Jogador jogador = new Jogador(nome, selecao, nacionalidade, idade, posicoesJogadores.get(numPosicaoJogador), cartaoAmarelo, cartaoVermelho, gols, rtitular);
					  		jogadorDAO.create(jogador);
					  		break;
				  		} else {
				  			System.out.println("Não há espaço nas seleções para um novo jogador.\nFavor criar uma nova selecao ou remover um jogador.");
				  		}
				  		
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
				  		Arbitro arbitro = new Arbitro(nome, nacionalidade, tipoArbitro.get(numTipo), idade);
				  		arbitroDAO.create(arbitro);
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
				  		mostrarSelecao(selecaoDAO);
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
				  		
				  }
			  } while (opcao4 != 5);
			break;
			
		  case 5:
			System.out.println(" ");
			System.out.println("Fim do programa!!!");
			System.exit(0);
			break;
		  default:
			System.out.println("O número escolhido é inválido! Digite um número entre 1 a 5.");
		  }
		  // aqui vai utilizar um comando pra limpar o console (ainda não sei como vou fazer isso mas depois faço)
	  }while (opcao != 5);
	  
	  entrada.close();
  }
  
  
}
