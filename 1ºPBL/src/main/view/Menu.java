package main.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import main.controller.MenuController;

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
		int opcao,opcao1,opcao2,opcao3,opcao4;
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
					  		PrimeiraMaiuscula(grupo);
					  		System.out.print("Digite a posicao no grupo da Selecao [1 a 4]: ");
					  		posicaoGrupo = entrada.nextInt();
					  		MenuController.createSelecao(nome, grupo, posicaoGrupo);
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
											MenuController.updateSelecao(idSelecao, selecaoEditar, atributo);
											System.out.println("Nome alterado com sucesso");
											break;
											
										case 2:
											mostrarGrupos();
											System.out.print("Digite o novo grupo:");
											atributo = entrada.next();
											MenuController.updateSelecao(idSelecao, selecaoEditar, atributo);
											System.out.println("Selecao alterada com sucesso");
											break;	
											
										case 3:
											System.out.print("Digite a nova posicao da selecao no grupo:");
											atributo = entrada.next();
											MenuController.updateSelecao(idSelecao, selecaoEditar, atributo);
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
					  			MenuController.deleteSelecao(selecaoID);
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
						  		int numPosicaoJogador, selecao,cartaoAmarelo, cartaoVermelho, idade, gols;
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
						  		System.out.print("Digite a quantidade de cartoes Amarelos do jogador: ");
						  		cartaoAmarelo = entrada.nextInt();
						  		System.out.print("Digite a quantidade de cartoes Vermelhos do jogador: ");
						  		cartaoVermelho = entrada.nextInt();
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
						  		System.out.print("Digite a quantidade de gols do jogador: ");
						  		gols = entrada.nextInt();
						  		MenuController.createJogador(nome, selecao, nacionalidade, idade, posicaoJogador, cartaoAmarelo, cartaoVermelho, gols, rtitular);
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
										System.out.println("4) Quantidade de cartoes amarelos");
										System.out.println("5) Quantidade de cartoes Vermelhos");
										System.out.println("6) Idade");
										System.out.println("7) Nacionalide");
										System.out.println("8) Titular");
										System.out.println("9) gols");
										System.out.println("10) Voltar");
										System.out.print("Qual atributo deseja editar: ");
										jogadorEditar = entrada.nextInt();
										switch(jogadorEditar) {
										case 1:
											System.out.print("Digite o novo nome:");
											atributo = entrada.next();
											MenuController.updateJogador(idJogador, jogadorEditar, atributo);
											System.out.println("Nome alterado com sucesso");
											break;
											
										case 2:
											MenuController.mostrarSelecao(false);
											System.out.print("Digite a nova selecao:");
											atributo = entrada.next();
											MenuController.updateSelecao(MenuController.SelecaoJogador(idJogador), 6, String.valueOf(idJogador));
											MenuController.updateJogador(idJogador, jogadorEditar, atributo);
											MenuController.updateSelecao(MenuController.SelecaoJogador(idJogador), 5, String.valueOf(idJogador));
											System.out.println("Selecao alterada com sucesso");
											break;	
											
										case 3:
											mostrarListaNumerada(posicoesJogadores);
											System.out.print("Digite o numero da nova Posicao:");
											numAtributo = entrada.nextInt();
											atributo = posicoesJogadores.get(numAtributo-1);
											MenuController.updateJogador(idJogador, jogadorEditar, atributo);
											System.out.println("Posicao alterada com sucesso");
											break;
											
										case 4:
											System.out.print("Digite a nova quantidade de cartões amarelos:");
											atributo = entrada.next();
											MenuController.updateJogador(idJogador, jogadorEditar, atributo);
											System.out.println("Quantidade de cartoes amarelos alterada com sucesso");
											break;
											
										case 5:
											System.out.print("Digite a nova quantidade de cartões vermelhos:");
											atributo = entrada.next();
											MenuController.updateJogador(idJogador, jogadorEditar, atributo);
											System.out.println("Quantidade de cartoes vermelhos alterada com sucesso");
											break;
											
										case 6:
											System.out.print("Digite a nova idade:");
											atributo = entrada.next();
											MenuController.updateJogador(idJogador, jogadorEditar, atributo);
											System.out.println("Idade alterada com sucesso");
											break;
											
										case 7:
											System.out.print("Digite a nova nacionalidade:");
											atributo = entrada.next();
											MenuController.updateJogador(idJogador, jogadorEditar, atributo);
											System.out.println("Nacionalidade alterada com sucesso");
											break;
										case 8:
											System.out.print("Digite se o jogador e titular:");
											atributo = entrada.next();
											MenuController.updateJogador(idJogador, jogadorEditar, atributo);
											System.out.println("Titular alterado com sucesso");
											break;
											
										case 9:
											System.out.print("Digite a nova Quantidade de gols:");
											atributo = entrada.next();
											MenuController.updateJogador(idJogador, jogadorEditar, atributo);
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
					  		listar(MenuController.listarDAOByID(4));
					  		System.out.println("Digite o ID da selecao para excluir jogadores: ");
					  		selecaoID = entrada.nextInt();
					  		MenuController.mostrarJogadoresSelecao(selecaoID);
					  		System.out.println("Digite o ID do jogador que deseja excluir: ");
					  		jogadorID = entrada.nextInt();
					  		System.out.println("Voce tem certeza que deseja excluir o jogador? S/N ");
					  		escolha = entrada.next().toLowerCase();
					  		if (escolha.equals("s")) {
					  			MenuController.deleteJogador(jogadorID);
					  			MenuController.updateSelecao(MenuController.SelecaoJogador(jogadorID), 6, String.valueOf(jogadorID));
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
					  		MenuController.createArbitro(nome, nacionalidade, tipo, idade);
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
											MenuController.updateArbitro(idArbitro, arbitroEditar, PrimeiraMaiuscula(atributo));
											System.out.println("Nome alterado com sucesso");
											break;
											
										case 2:
											System.out.print("Digite a nova idade:");
											atributo = entrada.next();
											MenuController.updateArbitro(idArbitro, arbitroEditar, atributo);
											System.out.println("Idade alterada com sucesso");
											break;
											
										case 3:
											System.out.print("Digite a nova nacionalidade:");
											atributo = entrada.next();
											MenuController.updateArbitro(idArbitro, arbitroEditar, PrimeiraMaiuscula(atributo));
											System.out.println("Nacionalidade alterada com sucesso");
											break;
											
										case 4:
											mostrarListaNumerada(tipoArbitro);
											System.out.print("Digite o novo tipo:");
											numAtributo = entrada.nextInt();
											atributo = tipoArbitro.get(numAtributo-1);
											MenuController.updateArbitro(idArbitro, arbitroEditar, atributo);
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
					  			MenuController.deleteArbitro(arbitroID);
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
					  		MenuController.createTecnico(PrimeiraMaiuscula(nacionalidade), selecao, PrimeiraMaiuscula(timeAnterior), PrimeiraMaiuscula(nome), idade);
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
											MenuController.updateTecnico(idTecnico, tecnicoEditar, atributo);
											System.out.println("Nome alterado com sucesso");
											break;
											
										case 2:
											MenuController.mostrarSelecao(false);
											System.out.print("Digite a nova selecao:");
											atributo = entrada.next();
											MenuController.updateSelecao(MenuController.SelecaoTecnico(idTecnico), 4, String.valueOf(-1));
											MenuController.updateTecnico(idTecnico, tecnicoEditar, atributo);
											MenuController.updateSelecao(MenuController.SelecaoTecnico(idTecnico), 4, String.valueOf(idTecnico));
											System.out.println("Selecao alterada com sucesso");
											break;	
											
										case 3:
											System.out.print("Digite a nova idade:");
											atributo = entrada.next();
											MenuController.updateTecnico(idTecnico, tecnicoEditar, atributo);
											System.out.println("Idade alterada com sucesso");
											break;
											
										case 4:
											System.out.print("Digite a nova nacionalidade:");
											atributo = entrada.next();
											MenuController.updateTecnico(idTecnico, tecnicoEditar, PrimeiraMaiuscula(atributo));
											System.out.println("Nacionalidade alterada com sucesso");
											break;
											
										case 5:
											System.out.print("Digite o novo time anterior:");
											atributo = entrada.next();
											MenuController.updateTecnico(idTecnico, tecnicoEditar, PrimeiraMaiuscula(atributo));
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
					  			MenuController.deleteTecnico(tecnicoID);
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