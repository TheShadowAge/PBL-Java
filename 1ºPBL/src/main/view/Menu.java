package main.view;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import main.controller.*;
import main.model.entities.Entidade;

public class Menu {
	
	public static void listarObjeto(List<Object> lista) {
		for (Object objectIterator: lista) {
			System.out.println(objectIterator);
		}
	}
	
	public static void listar(List<String> lista) {
		for (Object objectIterator: lista) {
			System.out.println(objectIterator);
		}
	}
	
	public static String PrimeiraMaiuscula(String nome) {
		nome = nome.toLowerCase();
		String primeiraLetra = nome.substring(0,1).toUpperCase();
		nome = primeiraLetra + nome.substring(1);
		return nome;
	}
	
	public static void mostrarListaNumerada(List<String> lista) {
		for(int i=0;i<lista.size(); i++) {
  			System.out.println((i+1) + " - " + lista.get(i));
  		}
	}
	
	public static void mostrarGrupos() {
		System.out.println("Esses sao os grupos:");
		List<String> grupos = Arrays.asList("A","B","C","D","E","F","G","H");
		for(int i=0;i<grupos.size(); i++) {
  			System.out.println("Grupo " + grupos.get(i));
  		}
	}
	
	public static void main(String[] args) {
		
		MenuController.criarEntidades();
		int opcao, opcao1,opcao2,opcao3,opcao4,opcao5, opcao6;
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
			  System.out.println("5) Partida");
			  System.out.println("6) Pesquisa");
			  System.out.println("7) Sair");
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
					  		PrimeiraMaiuscula(grupo);
					  		System.out.print("Digite a posicao no grupo da Selecao [1 a 4]: ");
					  		posicaoGrupo = entrada.nextInt();
					  		ControllerSelecao.createSelecao(nome, grupo, posicaoGrupo);
					  		break;
					  		
					  	case 2:
					  		String atributo;
					  		int idSelecao, selecaoEditar;
							  
							if(!MenuController.verificarExistencia(1)) {
								listar(MenuController.listarDAOByID(4));
								System.out.print("Digite o id da selecao que vc deseja editar:");
								idSelecao = entrada.nextInt();
								Object selecao = MenuController.selecionarDAO(1, idSelecao);
								if(selecao == null) {
									System.out.println("Selecao não encontrado!");
								}
								else {
									do {
										System.out.println("   +--------+ ");
										System.out.println("   | Editar | "); 
										System.out.println("   +--------+ ");
										System.out.println("1) Nome");
										System.out.println("2) Grupo");
										System.out.println("3) Posicao da selecao");
										System.out.println("4) Voltar");
										System.out.print("Qual atributo deseja editar: ");
										selecaoEditar = entrada.nextInt();
										switch(selecaoEditar) {
										case 1:
											System.out.print("Digite o novo nome:");
											atributo = entrada.next();
											atributo = PrimeiraMaiuscula(atributo);
											ControllerSelecao.updateSelecao(idSelecao, selecaoEditar, atributo);
											System.out.println("Nome alterado com sucesso");
											break;
											
										case 2:
											mostrarGrupos();
											System.out.print("Digite o novo grupo:");
											atributo = entrada.next();
											ControllerSelecao.updateSelecao(idSelecao, selecaoEditar, atributo);
											System.out.println("Selecao alterada com sucesso");
											break;	
											
										case 3:
											System.out.print("Digite a nova posicao da selecao no grupo:");
											atributo = entrada.next();
											ControllerSelecao.updateSelecao(idSelecao, selecaoEditar, atributo);
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
					  		listar(MenuController.listarDAOByID(4));
					  		System.out.println("Digite o ID da selecao a ser excluida: ");
					  		selecaoID = entrada.nextInt();
					  		System.out.println("Tem certeza que deseja excluir a selecao ?\nIsso vai excluir a selecao e todos os jogadores e o ténico dela.\nDeseja continuar? S/N");
					  		escolha = entrada.next();
					  		if (escolha.toLowerCase().equals("s")) {
					  			ControllerSelecao.deleteSelecao(selecaoID);
					  			System.out.println("Selecao, jogadores e tecnico excluidos com sucesso!");
					  		}
					  		break;
					  		
					  	case 4:
					  		listarObjeto(MenuController.listarDAO(4));
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
					  		if (!(MenuController.isSelecoesFull())) {
						  		String nome, nacionalidade ,titular, posicaoJogador;
						  		int numPosicaoJogador, selecao, idade;
						  		boolean rtitular = false;
						  
						  		System.out.println("   +---------+ ");
								System.out.println("   | Inserir | "); 
								System.out.println("   +---------+ ");
						  		System.out.print("Digite o nome do jogador: ");
						  		nome = entrada.next();
						  		nome = PrimeiraMaiuscula(nome);
						  		MenuController.mostrarSelecao(false);
						  		System.out.print("Digite o numero da selecao do Jogador: ");
						  		selecao = entrada.nextInt();
						  		System.out.println("Essas sao as posicoes dos jogadores:");
						  		mostrarListaNumerada(posicoesJogadores);
						  		System.out.println("Digite o numero da posicao  do jogador: ");
						  		numPosicaoJogador = entrada.nextInt();
						  		posicaoJogador =  posicoesJogadores.get(numPosicaoJogador-1);
						  		System.out.println("Digite a idade do jogador: ");
						  		idade = entrada.nextInt();
						  		System.out.println("Digite a nacionalidade do jogador: ");
						  		nacionalidade = entrada.next();
						  		nacionalidade = PrimeiraMaiuscula(nacionalidade);
						  		System.out.println("O jogador e titular? [Sim/Nao]:");
						  		titular = entrada.next();
						  		if (titular.equals("Sim")) {
						  			rtitular = true;
						  		}
						  		else if (titular.equals("Nao")) {
						  			rtitular = false;
						  		}
						  		ControllerJogador.createJogador(nome, selecao, nacionalidade, idade, posicaoJogador, rtitular);
					  		} else {
					  			System.out.println("Não ha espaço nas seleções para um novo jogador.\nFavor criar uma nova selecao ou remover um jogador.");
					  		}
					  		break;
					  	
					  	case 2:
					  		String atributo;
					  		int idJogador, jogadorEditar;
							  
							if(!MenuController.verificarExistencia(2)) {
								listar(MenuController.listarDAOByID(1));
								System.out.println("Digite o id do jogador que vc deseja editar:");
								idJogador = entrada.nextInt();
								Object jogador = MenuController.selecionarDAO(2, idJogador);
								if(jogador == null) {
									System.out.println("Jogador não encontrado!");
								}
								else {
									do {
										int numAtributo;
										System.out.println("   +--------+ ");
										System.out.println("   | Editar | "); 
										System.out.println("   +--------+ ");
										System.out.println("1) Nome");
										System.out.println("2) Selecao");
										System.out.println("3) Posicao");
										System.out.println("4) Idade");
										System.out.println("5) Nacionalide");
										System.out.println("6) Titular");
										System.out.println("7) Voltar");
										System.out.print("Qual atributo deseja editar: ");
										jogadorEditar = entrada.nextInt();
										switch(jogadorEditar) {
										case 1:
											System.out.print("Digite o novo nome:");
											atributo = entrada.next();
											ControllerJogador.updateJogador(idJogador, jogadorEditar, atributo);
											System.out.println("Nome alterado com sucesso");
											break;
											
										case 2:
											MenuController.mostrarSelecao(false);
											System.out.print("Digite a nova selecao:");
											atributo = entrada.next();
											ControllerSelecao.updateSelecao(ControllerJogador.SelecaoJogador(idJogador), 6, String.valueOf(idJogador));
											ControllerJogador.updateJogador(idJogador, jogadorEditar, atributo);
											ControllerSelecao.updateSelecao(ControllerJogador.SelecaoJogador(idJogador), 5, String.valueOf(idJogador));
											System.out.println("Selecao alterada com sucesso");
											break;	
											
										case 3:
											mostrarListaNumerada(posicoesJogadores);
											System.out.print("Digite o numero da nova Posicao:");
											numAtributo = entrada.nextInt();
											atributo = posicoesJogadores.get(numAtributo-1);
											ControllerJogador.updateJogador(idJogador, jogadorEditar, atributo);
											System.out.println("Posicao alterada com sucesso");
											break;
											
										case 4:
											System.out.print("Digite a nova idade:");
											atributo = entrada.next();
											ControllerJogador.updateJogador(idJogador, jogadorEditar, atributo);
											System.out.println("Idade alterada com sucesso");
											break;
											
										case 5:
											System.out.print("Digite a nova nacionalidade:");
											atributo = entrada.next();
											ControllerJogador.updateJogador(idJogador, jogadorEditar, atributo);
											System.out.println("Nacionalidade alterada com sucesso");
											break;
										case 6:
											System.out.print("Digite se o jogador e titular:");
											atributo = entrada.next();
											ControllerJogador.updateJogador(idJogador, jogadorEditar, atributo);
											System.out.println("Titular alterado com sucesso");
											break;

										case 7:
											break;
											
										default:
											System.out.print("Atributo nao encontrado");
											
										}
									} while (jogadorEditar != 7);
								}
							} 
							else {
								System.out.println("Nao ha jogadores cadastrados!");
							}
					  		break;
					  	case 3:
					  		int selecaoID, jogadorID;
					  		String escolha;
					  		listar(MenuController.listarDAOByID(4));
					  		System.out.println("Digite o ID da selecao para excluir jogadores: ");
					  		selecaoID = entrada.nextInt();
					  		MenuController.mostrarJogadoresSelecao(selecaoID);
					  		System.out.println("Digite o ID do jogador que deseja excluir: ");
					  		jogadorID = entrada.nextInt();
					  		System.out.println("Voce tem certeza que deseja excluir o jogador? S/N ");
					  		escolha = entrada.next().toLowerCase();
					  		if (escolha.equals("s")) {
					  			ControllerJogador.deleteJogador(jogadorID);
					  			ControllerSelecao.updateSelecao(ControllerJogador.SelecaoJogador(jogadorID), 6, String.valueOf(jogadorID));
					  			System.out.println("Jogador deletado com sucesso!");
					  		}
					  		break;
					  	case 4:
					  		listarObjeto(MenuController.listarDAO(1));
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
					  		String nome, nacionalidade, tipo;
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
					  		mostrarListaNumerada(tipoArbitro);
					  		System.out.print("Digite o numero do tipo de arbitro: ");
					  		numTipo = entrada.nextInt();
					  		tipo = tipoArbitro.get(numTipo-1);
					  		ControllerArbitro.createArbitro(nome, nacionalidade, tipo, idade);
					  		break;
					  	
					  	case 2:
					  		String atributo;
					  		int idArbitro, arbitroEditar, numAtributo;
					  		
					  		
							if(!MenuController.verificarExistencia(4)) {
								listar(MenuController.listarDAOByID(2));
								System.out.println("Digite o id do arbitro que vc deseja editar:");
								idArbitro = entrada.nextInt();
								Object arbitro = MenuController.selecionarDAO(4, idArbitro);
								if(arbitro == null) {
									System.out.println("Arbitro nao encontrado!");
								}
								else {
									do {
										System.out.println("   +--------+ ");
										System.out.println("   | Editar | "); 
										System.out.println("   +--------+ ");
										System.out.println("1) Nome");
										System.out.println("2) Idade");
										System.out.println("3) Nacionalidade");
										System.out.println("4) Tipo");
										System.out.println("5) Voltar");
										System.out.print("Qual atributo deseja editar: ");
										arbitroEditar = entrada.nextInt();
										switch(arbitroEditar) {
										case 1:
											System.out.print("Digite o novo nome:");
											atributo = entrada.next();
											ControllerArbitro.updateArbitro(idArbitro, arbitroEditar, PrimeiraMaiuscula(atributo));
											System.out.println("Nome alterado com sucesso");
											break;
											
										case 2:
											System.out.print("Digite a nova idade:");
											atributo = entrada.next();
											ControllerArbitro.updateArbitro(idArbitro, arbitroEditar, atributo);
											System.out.println("Idade alterada com sucesso");
											break;
											
										case 3:
											System.out.print("Digite a nova nacionalidade:");
											atributo = entrada.next();
											ControllerArbitro.updateArbitro(idArbitro, arbitroEditar, PrimeiraMaiuscula(atributo));
											System.out.println("Nacionalidade alterada com sucesso");
											break;
											
										case 4:
											mostrarListaNumerada(tipoArbitro);
											System.out.print("Digite o novo tipo:");
											numAtributo = entrada.nextInt();
											atributo = tipoArbitro.get(numAtributo-1);
											ControllerArbitro.updateArbitro(idArbitro, arbitroEditar, atributo);
											System.out.println("Tipo de arbitro alterado com sucesso");
											
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
					  		listar(MenuController.listarDAOByID(2));
					  		System.out.println("Digite o ID do arbitro que deseja excluir: ");
					  		arbitroID = entrada.nextInt();
					  		System.out.println("Voce tem certeza que deseja excluir o arbitro ? S/N ");
					  		escolha = entrada.next().toLowerCase();
					  		if (escolha.equals("s")) {
					  			ControllerArbitro.deleteArbitro(arbitroID);
					  			System.out.println("Arbitro deletado com sucesso!");
					  		}
					  		break;
					  	case 4:
					  		listarObjeto(MenuController.listarDAO(2));
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
					  		MenuController.mostrarSelecao(false);
					  		System.out.print("Digite o numero da selecao do tecnico: ");
					  		selecao = entrada.nextInt();
					  		System.out.print("Digite a idade do Tecnico: ");
					  		idade = entrada.nextInt();
					  		System.out.print("Digite a nacionalidade do tecnico: ");
					  		nacionalidade = entrada.next();
					  		System.out.print("Digite o time anterior do tecnico: ");
					  		timeAnterior = entrada.next();
					  		ControllerTecnico.createTecnico(PrimeiraMaiuscula(nacionalidade), selecao, PrimeiraMaiuscula(timeAnterior), PrimeiraMaiuscula(nome), idade);
					  		break;
					  		
					  	case 2:
					  		int idTecnico, tecnicoEditar;
					  
							if(!MenuController.verificarExistencia(3)) {
								listar(MenuController.listarDAOByID(3));
								System.out.println("Digite o id do tecnico que vc deseja editar:");
								idTecnico = entrada.nextInt();
								Object tecnico = MenuController.selecionarDAO(3, idTecnico);
								if(tecnico == null) {
									System.out.println("Tecnico nao encontrado!");
								}
								else {
									do {
										String atributo;
										System.out.println("   +--------+ ");
										System.out.println("   | Editar | "); 
										System.out.println("   +--------+ ");
										System.out.println("1) Nome");
										System.out.println("2) Selecao");
										System.out.println("3) Idade");
										System.out.println("4) Nacionalidade");
										System.out.println("5) Time anterior");
										System.out.println("6) Voltar");
										System.out.print("Qual atributo deseja editar: ");
										tecnicoEditar = entrada.nextInt();
										switch(tecnicoEditar) {
										case 1:
											System.out.print("Digite o novo nome:");
											atributo = entrada.next();
											ControllerTecnico.updateTecnico(idTecnico, tecnicoEditar, atributo);
											System.out.println("Nome alterado com sucesso");
											break;
											
										case 2:
											MenuController.mostrarSelecao(false);
											System.out.print("Digite a nova selecao:");
											atributo = entrada.next();
											ControllerSelecao.updateSelecao(ControllerTecnico.SelecaoTecnico(idTecnico), 4, String.valueOf(-1));
											ControllerTecnico.updateTecnico(idTecnico, tecnicoEditar, atributo);
											ControllerSelecao.updateSelecao(ControllerTecnico.SelecaoTecnico(idTecnico), 4, String.valueOf(idTecnico));
											System.out.println("Selecao alterada com sucesso");
											break;	
											
										case 3:
											System.out.print("Digite a nova idade:");
											atributo = entrada.next();
											ControllerTecnico.updateTecnico(idTecnico, tecnicoEditar, atributo);
											System.out.println("Idade alterada com sucesso");
											break;
											
										case 4:
											System.out.print("Digite a nova nacionalidade:");
											atributo = entrada.next();
											ControllerTecnico.updateTecnico(idTecnico, tecnicoEditar, PrimeiraMaiuscula(atributo));
											System.out.println("Nacionalidade alterada com sucesso");
											break;
											
										case 5:
											System.out.print("Digite o novo time anterior:");
											atributo = entrada.next();
											ControllerTecnico.updateTecnico(idTecnico, tecnicoEditar, PrimeiraMaiuscula(atributo));
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
					  		listar(MenuController.listarDAOByID(3));
					  		System.out.println("Digite o ID do tecnico que deseja excluir: ");
					  		tecnicoID = entrada.nextInt();
					  		System.out.println("Voce tem certeza que deseja excluir o tecnico? S/N ");
					  		escolha = entrada.next().toLowerCase();
					  		if (escolha.equals("s")) {
					  			ControllerTecnico.deleteTecnico(tecnicoID);
					  			System.out.println("Tecnico deletado com sucesso!");
					  		}
					  		break;
					  		
					  	case 4:
					  		listarObjeto(MenuController.listarDAO(3));
					  		break;
					  							
					  }
				  } while (opcao4 != 5);
				break;
			  case 5:
				  
				  do {
				  System.out.println("   +---------+ ");
				  System.out.println("   | Partida | "); 
				  System.out.println("   +---------+ ");
				  System.out.println("Escolha uma opcao:");
				  System.out.println("1) Inserir");
				  System.out.println("2) Editar");
				  System.out.println("3) Excluir");
				  System.out.println("4) Listar Partidas");
				  System.out.println("5) Voltar");
				  System.out.print("Opcao:");
				  opcao5 = entrada.nextInt();
				  switch(opcao5) {
				  	case 1:
				  		
				  		int golsTime1 = 0;
				  		int golsTime2 = 0;
				  		int cartVerTime1 = 0;
				  		int cartVerTime2 = 0;
				  		int cartAmaTime1 = 0;
				  		int cartAmaTime2 = 0;
				  		int time1, jogTime1, jogTime2, gols1, gols2, cartAma1, cartAma2, cartVer1, cartVer2;
				  		String respgols1, respgols2, respcart1, respcart2;
				  		List<Object> listajogG1 = new LinkedList<Object>();
					  	List<Object> listajogG2 = new LinkedList<Object>();
					  	List<Object> listajogC1 = new LinkedList<Object>();
					  	List<Object> listajogC2 = new LinkedList<Object>();
				  		System.out.println("   +---------+ ");
						System.out.println("   | Inserir | "); 
						System.out.println("   +---------+ ");
						System.out.println("Digite o local da partida:");
						String local = entrada.next();
						System.out.println("Digite a data da partida [dd/MM/aaaa]:");
				  		String data = entrada.next();
				  		System.out.println("Digite o horario da partida [HH:mm:ss]:");
				  		String horario = entrada.next();
				  		listar(MenuController.listarDAOByID(4));
				  		System.out.println("Digite o id da selecao para o primeiro time da partida:");
				  		time1 = entrada.nextInt();
				  		do {
				  			listar(ControllerPartida.jogadoresSeleção(time1));
				  			System.out.println("Algum jogador fez gol? ");
				  			System.out.println("Digite o id do jogador que fez gol:");
				  			jogTime1 = entrada.nextInt();
				  			System.out.println("Digite a quantidades de gols do jogador:");
				  			gols1 = entrada.nextInt();
				  			listajogG1.add(ControllerPartida.createJogadorGols(jogTime1, gols1));
				  			golsTime1 += gols1;
				  			ControllerPartida.adicionarDadosJogador(jogTime1, 1, gols1);
				  			System.out.print("Mais algum jogador fez gol? [S/N]:");
				  			respgols1 = entrada.next();
			  			} while (respgols1.toUpperCase().equals("S"));
				  		do {
				  			listar(ControllerPartida.jogadoresSeleção(time1));
				  			System.out.println("Algum jogador recebeu cartão? ");
				  			System.out.println("Digite o id do jogador que recebeu cartão:");
				  			jogTime1 = entrada.nextInt();
				  			System.out.println("Digite a quantidades de cartões amarelos do jogador:");
				  			cartAma1 = entrada.nextInt();
				  			System.out.println("Digite a quantidades de cartões vermelhos do jogador:");
				  			cartVer1 = entrada.nextInt();
				  			listajogC1.add(ControllerPartida.createJogadorCartoes(jogTime1, cartAma1, cartVer1));
				  			cartAmaTime1 += cartAma1;
				  			cartVerTime1 += cartVer1;
				  			ControllerPartida.adicionarDadosJogador(jogTime1, 2, cartAma1);
				  			ControllerPartida.adicionarDadosJogador(jogTime1, 3, cartVer1);
				  			System.out.print("Mais algum jogador fez gol? [S/N]:");
				  			respcart1 = entrada.next();
			  			} while (respcart1.toUpperCase().equals("S"));
				  		listar(ControllerPartida.listarSelecaoPartida(time1));
				  		System.out.print("Digite o id da selecao para o segundo time da partida: ");
				  		int time2 = entrada.nextInt();
				  		do {
				  			listar(ControllerPartida.jogadoresSeleção(time2));
				  			System.out.println("Algum jogador fez gol? ");
				  			System.out.print("Digite o id do jogador que fez gol:");
				  			jogTime2 = entrada.nextInt();
				  			System.out.print("Digite a quantidades de gols do jogador:");
				  			gols2 = entrada.nextInt();
				  			listajogG2.add(ControllerPartida.createJogadorGols(jogTime2, gols2));
				  			golsTime2 += gols2;
				  			System.out.print("Mais algum jogador fez gol? [S/N]:");
				  			ControllerPartida.adicionarDadosJogador(jogTime2, 1, gols2);
				  			respgols2 = entrada.next();
			  			} while (respgols2.equals("N"));
				  		do {
				  			listar(ControllerPartida.jogadoresSeleção(time2));
				  			System.out.println("Algum jogador recebeu cartão? ");
				  			System.out.println("Digite o id do jogador que recebeu cartão:");
				  			jogTime2 = entrada.nextInt();
				  			System.out.println("Digite a quantidades de cartões amarelos do jogador:");
				  			cartAma2 = entrada.nextInt();
				  			System.out.println("Digite a quantidades de cartões vermelhos do jogador:");
				  			cartVer2 = entrada.nextInt();
				  			listajogC2.add(ControllerPartida.createJogadorCartoes(jogTime2, cartAma2, cartVer2));
				  			cartAmaTime2 += cartAma2;
				  			cartVerTime2 += cartVer2;
				  			ControllerPartida.adicionarDadosJogador(jogTime2, 2, cartAma2);
				  			ControllerPartida.adicionarDadosJogador(jogTime2, 3, cartVer2);
				  			System.out.print("Mais algum jogador fez gol? [S/N]:");
				  			respcart2 = entrada.next();
			  			} while (respcart2.toUpperCase().equals("S"));
				  		String nome = ControllerPartida.nomePartida(time1, time2);
				  		LocalDate dataformatada = ControllerPartida.formatarData(data);
				  		LocalTime horarioformatado = ControllerPartida.formatarHorario(horario);
				  		ControllerPartida.createPartida(nome, dataformatada, horarioformatado, local, time1, golsTime1, cartAmaTime1, cartVerTime1, time2, golsTime2, cartAmaTime2, cartVerTime2, listajogG1, listajogG2, listajogC1, listajogC2);
				  		ControllerSelecao.updateSelecao(time1, 7, Integer.toString(Entidade.getContagem() - 1));
				  		ControllerSelecao.updateSelecao(time2, 7, Integer.toString(Entidade.getContagem() - 1));
				  		break;
				  		
				  	case 2:
				  		int idPartida, partidaEditar;
				  		
				  		if(!MenuController.verificarExistencia(5)) {
							listar(MenuController.listarDAOByID(5));
							System.out.println("Digite o id do partida que vc deseja editar:");
							idPartida = entrada.nextInt();
							Object partida = MenuController.selecionarDAO(5, idPartida);
							if(partida == null) {
								System.out.println("Partida nao encontrado!");
							}
							else {
								do {
									String atributo;
									
									System.out.println("   +--------+ ");
									System.out.println("   | Editar | "); 
									System.out.println("   +--------+ ");
									System.out.println("1) Data da partida [20/10/2022]");
									System.out.println("2) Horario da partida [11:57:00]");
									System.out.println("3) Local da partida");
									System.out.println("4) Primeiro time da partida");
									System.out.println("5) Quantidade de gols do primeiro time na partida");
									System.out.println("6) Quantidade de cartões do primeiro time na partida");
									System.out.println("7) Segundo time da partida");
									System.out.println("8) Quantidade de gols do segundo time na partida");
									System.out.println("9) Quantidade de cartões  do segundo time na partida");
									System.out.println("10) Voltar");
									System.out.print("Qual atributo deseja editar: ");
									partidaEditar = entrada.nextInt();
									switch(partidaEditar) {
									case 1:
										System.out.print("Digite a nova data da partida [20/10/2022]:");
										atributo = entrada.next();
										ControllerPartida.updatePartida(idPartida, partidaEditar, atributo);
										System.out.println("Data alterada com sucesso");
										break;
										
									case 2:
										System.out.print("Digite o novo horario da partida [18:00:00]:");
										atributo = entrada.next();
										ControllerPartida.updatePartida(idPartida, partidaEditar, atributo);
										System.out.println("Horario alterado com sucesso");
										break;	
										
									case 3:
										System.out.print("Digite o novo Local da partida:");
										atributo = entrada.next();
										ControllerPartida.updatePartida(idPartida, partidaEditar, atributo);
										System.out.println("Local alterado com sucesso");
										break;
										
									case 4:
										int time1Anterior = ControllerPartida.receberTime(idPartida, 1);
										List<Object> editListaJogG1 = new LinkedList<Object>();
										List<Object> editListaJogC1 = new LinkedList<Object>();
										ControllerPartida.limparDadosJogador(idPartida, 1);
										ControllerPartida.limparDadosJogador(idPartida, 2);
										listar(MenuController.listarDAOByID(4));
										System.out.println("Digite o id da selecao para o novo primeiro time da partida:");
										time1 = entrada.nextInt();
										golsTime1 = 0;
										cartAmaTime1 = 0;
										cartVerTime1 = 0;
										do {
											listar(ControllerPartida.jogadoresSeleção(time1));
											System.out.println("Algum jogador fez gol? ");
											System.out.println("Digite o id do jogador que fez gol:");
											jogTime1 = entrada.nextInt();
											System.out.println("Digite a quantidades de gols do jogador:");
											gols1 = entrada.nextInt();
											editListaJogG1.add(ControllerPartida.createJogadorGols(jogTime1, gols1));
											golsTime1 += gols1;
											ControllerPartida.adicionarDadosJogador(jogTime1, 1, gols1);
											System.out.print("Mais algum jogador fez gol? [S/N]:");
											respgols1 = entrada.next();
										} while (respgols1.toUpperCase().equals("S"));
										do {
											listar(ControllerPartida.jogadoresSeleção(time1));
											System.out.println("Algum jogador recebeu cartão? ");
											System.out.println("Digite o id do jogador que recebeu cartão:");
											jogTime1 = entrada.nextInt();
											System.out.println("Digite a quantidades de cartões amarelos do jogador:");
											cartAma1 = entrada.nextInt();
											System.out.println("Digite a quantidades de cartões vermelhos do jogador:");
											cartVer1 = entrada.nextInt();
											editListaJogC1.add(ControllerPartida.createJogadorCartoes(jogTime1, cartAma1, cartVer1));
											cartAmaTime1 += cartAma1;
											cartVerTime1 += cartVer1;
											ControllerPartida.adicionarDadosJogador(jogTime1, 2, cartAma1);
											ControllerPartida.adicionarDadosJogador(jogTime1, 3, cartVer1);
											System.out.print("Mais algum jogador fez gol? [S/N]:");
											respcart1 = entrada.next();
										} while (respcart1.toUpperCase().equals("S"));
										ControllerPartida.updateListPartida(idPartida, 1, editListaJogG1);
										ControllerPartida.updateListPartida(idPartida, 2, editListaJogC1);
										ControllerPartida.updatePartida(idPartida, partidaEditar, Integer.toString(time1));
										ControllerPartida.updatePartida(idPartida, 5, Integer.toString(golsTime1));
										ControllerPartida.updatePartida(idPartida, 6, Integer.toString(cartAmaTime1));
										ControllerPartida.updatePartida(idPartida, 10, Integer.toString(cartVerTime1));
										ControllerSelecao.updateSelecao(time1Anterior, 8, Integer.toString(idPartida));
										System.out.println("Primeiro time alterado com sucesso");
										break;
	
									case 5:
										ControllerPartida.limparDadosJogador(idPartida, 1);
										List<Object> editListaJog2G1 = new LinkedList<Object>();
										time1 = ControllerPartida.receberTime(idPartida,1);
										golsTime1 = 0;
										do {
											listar(ControllerPartida.jogadoresSeleção(time1));
											System.out.println("Algum jogador fez gol? ");
											System.out.println("Digite o id do jogador que fez gol:");
											jogTime1 = entrada.nextInt();
											System.out.println("Digite a quantidades de gols do jogador:");
											gols1 = entrada.nextInt();
											editListaJog2G1.add(ControllerPartida.createJogadorGols(jogTime1, gols1));
											golsTime1 += gols1;
											ControllerPartida.adicionarDadosJogador(jogTime1, 1, gols1);
											System.out.print("Mais algum jogador fez gol? [S/N]:");
											respgols1 = entrada.next();
										} while (respgols1.toUpperCase().equals("S"));
										ControllerPartida.updatePartida(idPartida, partidaEditar, Integer.toString(golsTime1));
										System.out.println("Quantidade de gols do primeiro time alterado com sucesso");
										break;
										
									case 6:
										ControllerPartida.limparDadosJogador(idPartida, 2);
										List<Object> editListaJog2C1 = new LinkedList<Object>();
										time1 = ControllerPartida.receberTime(idPartida,1);
										cartAmaTime1 = 0;
										cartVerTime1 = 0;
										do {
											listar(ControllerPartida.jogadoresSeleção(time1));
											System.out.println("Algum jogador recebeu cartão? ");
											System.out.println("Digite o id do jogador que recebeu cartão:");
											jogTime1 = entrada.nextInt();
											System.out.println("Digite a quantidades de cartões amarelos do jogador:");
											cartAma1 = entrada.nextInt();
											System.out.println("Digite a quantidades de cartões vermelhos do jogador:");
											cartVer1 = entrada.nextInt();
											editListaJog2C1.add(ControllerPartida.createJogadorCartoes(jogTime1, cartAma1, cartVer1));
											cartAmaTime1 += cartAma1;
											cartVerTime1 += cartVer1;
											ControllerPartida.adicionarDadosJogador(jogTime1, 2, cartAma1);
											ControllerPartida.adicionarDadosJogador(jogTime1, 3, cartVer1);
											System.out.print("Mais algum jogador fez gol? [S/N]:");
											respcart1 = entrada.next();
										} while (respcart1.toUpperCase().equals("S"));
										ControllerPartida.updatePartida(idPartida, partidaEditar, Integer.toString(cartAma1));
										ControllerPartida.updatePartida(idPartida, 10, Integer.toString(cartVer1));
										System.out.println("Quantidade de cartões do primeiro time alterado com sucesso");
										break;
									
									case 7:
										int time2Anterior = ControllerPartida.receberTime(idPartida, 2);
										List<Object> editListaJogG2 = new LinkedList<Object>();
										List<Object> editListaJogC2 = new LinkedList<Object>();
										ControllerPartida.limparDadosJogador(idPartida, 3);
										ControllerPartida.limparDadosJogador(idPartida, 4);
										time1 = ControllerPartida.receberTime(idPartida, 1);
										listar(ControllerPartida.listarSelecaoPartida(time1));
										System.out.println("Digite o id da selecao para o novo segundo time da partida:");
										time2 = entrada.nextInt();
										golsTime2 = 0;
										cartAmaTime2 = 0;
										cartVerTime2 = 0;
										do {
											listar(ControllerPartida.jogadoresSeleção(time2));
											System.out.println("Algum jogador fez gol? ");
											System.out.println("Digite o id do jogador que fez gol:");
											jogTime2 = entrada.nextInt();
											System.out.println("Digite a quantidades de gols do jogador:");
											gols2 = entrada.nextInt();
											editListaJogG2.add(ControllerPartida.createJogadorGols(jogTime2, gols2));
											golsTime2 += gols2;
											ControllerPartida.adicionarDadosJogador(jogTime2, 1, gols2);
											System.out.print("Mais algum jogador fez gol? [S/N]:");
											respgols2 = entrada.next();
										} while (respgols2.toUpperCase().equals("S"));
										do {
											listar(ControllerPartida.jogadoresSeleção(time2));
											System.out.println("Algum jogador recebeu cartão? ");
											System.out.println("Digite o id do jogador que recebeu cartão:");
											jogTime2 = entrada.nextInt();
											System.out.println("Digite a quantidades de cartões amarelos do jogador:");
											cartAma2 = entrada.nextInt();
											System.out.println("Digite a quantidades de cartões vermelhos do jogador:");
											cartVer2 = entrada.nextInt();
											editListaJogC2.add(ControllerPartida.createJogadorCartoes(jogTime2, cartAma2, cartVer2));
											cartAmaTime2 += cartAma2;
											cartVerTime2 += cartVer2;
											ControllerPartida.adicionarDadosJogador(jogTime2, 2, cartAma2);
											ControllerPartida.adicionarDadosJogador(jogTime2, 3, cartVer2);
											System.out.print("Mais algum jogador fez gol? [S/N]:");
											respcart2 = entrada.next();
										} while (respcart2.toUpperCase().equals("S"));
										ControllerPartida.updateListPartida(idPartida, 3, editListaJogG2);
										ControllerPartida.updateListPartida(idPartida, 4, editListaJogC2);
										ControllerPartida.updatePartida(idPartida, partidaEditar, Integer.toString(time2));
										ControllerPartida.updatePartida(idPartida, 8, Integer.toString(golsTime2));
										ControllerPartida.updatePartida(idPartida, 9, Integer.toString(cartAmaTime2));
										ControllerPartida.updatePartida(idPartida, 11, Integer.toString(cartVerTime2));
										ControllerSelecao.updateSelecao(time2Anterior, 8, Integer.toString(idPartida));
										System.out.println("Segundo time alterado com sucesso");
										break;
										
									case 8:
										ControllerPartida.limparDadosJogador(idPartida, 3);
										List<Object> editListaJog2G2 = new LinkedList<Object>();
										time2 = ControllerPartida.receberTime(idPartida,2);
										golsTime2 = 0;
										do {
											listar(ControllerPartida.jogadoresSeleção(time2));
											System.out.println("Algum jogador fez gol? ");
											System.out.println("Digite o id do jogador que fez gol:");
											jogTime2 = entrada.nextInt();
											System.out.println("Digite a quantidades de gols do jogador:");
											gols2 = entrada.nextInt();
											editListaJog2G2.add(ControllerPartida.createJogadorGols(jogTime2, gols2));
											golsTime2 += gols2;
											ControllerPartida.adicionarDadosJogador(jogTime2, 1, gols2);
											System.out.print("Mais algum jogador fez gol? [S/N]:");
											respgols2 = entrada.next();
										} while (respgols2.toUpperCase().equals("S"));
										ControllerPartida.updatePartida(idPartida, partidaEditar, Integer.toString(golsTime2));
										System.out.println("Quantidade de gols do segundo time alterado com sucesso");
										break;
										
									case 9:
										ControllerPartida.limparDadosJogador(idPartida, 4);
										List<Object> editListaJog2C2 = new LinkedList<Object>();
										time2 = ControllerPartida.receberTime(idPartida,1);
										cartAmaTime2 = 0;
										cartVerTime2 = 0;
										do {
											listar(ControllerPartida.jogadoresSeleção(time2));
											System.out.println("Algum jogador recebeu cartão? ");
											System.out.println("Digite o id do jogador que recebeu cartão:");
											jogTime2 = entrada.nextInt();
											System.out.println("Digite a quantidades de cartões amarelos do jogador:");
											cartAma2 = entrada.nextInt();
											System.out.println("Digite a quantidades de cartões vermelhos do jogador:");
											cartVer2 = entrada.nextInt();
											editListaJog2C2.add(ControllerPartida.createJogadorCartoes(jogTime2, cartAma2, cartVer2));
											cartAmaTime2 += cartAma2;
											cartVerTime2 += cartVer2;
											ControllerPartida.adicionarDadosJogador(jogTime2, 2, cartAma2);
											ControllerPartida.adicionarDadosJogador(jogTime2, 3, cartVer2);
											System.out.print("Mais algum jogador fez gol? [S/N]:");
											respcart2 = entrada.next();
										} while (respcart2.toUpperCase().equals("S"));
										ControllerPartida.updatePartida(idPartida, partidaEditar, Integer.toString(cartAma2));
										ControllerPartida.updatePartida(idPartida, 11, Integer.toString(cartVer2));
										System.out.println("Quantidade de cartões do segundo time alterado com sucesso");
										break;
										
									default:
										System.out.println("Atributo nao encontrado");
									}	
								} while (partidaEditar != 10);
								break;
							}
						} 
						else {
							System.out.println("Nao ha Partidas cadastrados!");
						}
				  	case 3:
				  		int partidaID;
				  		String escolha;
				  		listar(MenuController.listarDAOByID(5));
				  		System.out.println("Digite o ID da partida que deseja excluir: ");
				  		partidaID = entrada.nextInt();
				  		int timeAnterior1 = ControllerPartida.receberTime(partidaID, 1);
				  		int timeAnterior2 = ControllerPartida.receberTime(partidaID, 2);
				  		System.out.println("Voce tem certeza que deseja excluir a partida? S/N ");
				  		escolha = entrada.next().toLowerCase();
				  		if (escolha.toUpperCase().equals("S")) {
				  			ControllerPartida.deletePartida(partidaID);
				  			ControllerSelecao.updateSelecao(timeAnterior1, 8, Integer.toString(partidaID));
				  			ControllerSelecao.updateSelecao(timeAnterior2, 8, Integer.toString(partidaID));
				  			System.out.println("Partida deletado com sucesso!");
				  		}
				  		break;
	
				  	case 4:
				  		listarObjeto(MenuController.listarDAO(5));
				  		break;
				  		}
				  } while (opcao5 != 5);
				  break;
				
			  case 6:
				do {
				String nome, data;
				System.out.println("   +----------+ ");
				System.out.println("   | Pesquisa | "); 
				System.out.println("   +----------+ ");
				System.out.println("Escolha uma opcao:");
				System.out.println("1) Pesquisar por Categoria");
				System.out.println("2) Pesquisar por Selecao");
				System.out.println("3) Pesquisar Partida por data");
				System.out.println("4) Voltar");
				System.out.print("Opcao: ");
				opcao6 = entrada.nextInt();
				switch (opcao6) {
					case 1:
						int categoriaOpcao;
						do {
						System.out.println("   +-----------+ ");
						System.out.println("   | Categoria | "); 
						System.out.println("   +-----------+ ");
						System.out.println("Escolha uma opcao:");
						System.out.println("1) Partida");
						System.out.println("2) Jogadores");
						System.out.println("3) Tecnico");
						System.out.println("4) Arbitros");
						System.out.println("5) Selecao");
						System.out.println("6) voltar");
						categoriaOpcao = entrada.nextInt();
						switch (categoriaOpcao) {
							case 1:
								System.out.println("Digite o nome da partida que deseja pesquisar");
								nome = entrada.next();
								listarObjeto(Pesquisa.pesquisarCategoria(nome, categoriaOpcao));	
								break;
								
							case 2:
								System.out.println("Digite o nome do jogador que deseja pesquisar");
								nome = entrada.next();
								listarObjeto(Pesquisa.pesquisarCategoria(nome, categoriaOpcao));
								break;
								
							case 3:
								System.out.println("Digite o nome do Tecnico que deseja pesquisar");
								nome = entrada.next();
								listarObjeto(Pesquisa.pesquisarCategoria(nome, categoriaOpcao));	
								break;
								
							case 4:
								System.out.println("Digite o nome do Arbitro que deseja pesquisar");
								nome = entrada.next();
								listarObjeto(Pesquisa.pesquisarCategoria(nome, categoriaOpcao));
								break;
								
							case 5:
								System.out.println("Digite o nome da Selecao que deseja pesquisar");
								nome = entrada.next();
								listarObjeto(Pesquisa.pesquisarCategoria(nome, categoriaOpcao));
								break;
							}
						} while (categoriaOpcao != 6);
						break;
						
					case 2:
					  System.out.println("Digite o nome da Selecao que deseja pesquisar");
					  nome = entrada.next();
					  listarObjeto(Pesquisa.pesquisarSelecao(nome));
					  break;
					  
					case 3:
						System.out.println("Digite a data da partida que deseja pesquisar [10/10/2022]");
						data = entrada.next();
						LocalDate dataformatada = ControllerPartida.formatarData(data);
						listarObjeto(Pesquisa.pesquisarPartidas(dataformatada));
						break;
					}
				} while (opcao6 != 4);
				break;
				
			  case 7:
				System.out.println(" ");
				System.out.println("Fim do programa!!!");
				System.exit(0);
				break;
				
			  default:
				System.out.println("O numero invalido! Digite um numero entre 1 a 7.");
			  }
		  }while (opcao != 0);
		 entrada.close();
	  }
	}