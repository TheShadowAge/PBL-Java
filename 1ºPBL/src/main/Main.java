package main;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import main.model.*;

public class Main {
  public static void main(String[] args) throws IOException, InterruptedException {
	  int opcao,opcao1,opcao2,opcao3,opcao4;
	  JogadorDAO jogadorDAO = DAO.getJogadores();
	  TecnicoDAO tecnicoDAO = DAO.getTecnicos();
	  SelecaoDAO selecaoDAO = DAO.getSelecoes();
	  ArbitroDAO arbitroDAO = DAO.getArbitros();
	  Scanner entrada = new Scanner(System.in);
	  do {
		  System.out.println("   ┌─────────┐ ");
		  System.out.println("   │ SysCopa │ "); 
		  System.out.println("   └─────────┘ ");
		  System.out.println("Escolha uma opcao:");
		  System.out.println("1) Seleção");
		  System.out.println("2) Jogadores");
		  System.out.println("3) Árbitros");
		  System.out.println("4) Técnico");
		  System.out.println("5) Sair");
		  System.out.print("Opcao: ");
		  opcao = entrada.nextInt();
		  
		  
		  switch (opcao) {
		  case 1:
			  do {
				  System.out.println("   ┌──────────┐ ");
				  System.out.println("   │ Seleções │ "); 
				  System.out.println("   └──────────┘ ");
				  System.out.println("Escolha uma opcao:");
				  System.out.println("1) Inserir");
				  System.out.println("2) Editar");
				  System.out.println("3) Excluir");
				  System.out.println("4) Listar Seleções");
				  System.out.println("5) Voltar");
				  System.out.print("Opcao: ");
				  opcao1 = entrada.nextInt();
				  switch(opcao1) {
				  	case 1:
				  		String nome, grupo;
				  		int posicaoGrupo;
				  		System.out.print("Digite o nome da Seleçao: ");
				  		nome = entrada.nextLine();
				  		System.out.print("Digite o grupo da Seleção: ");
				  		grupo = entrada.nextLine();
				  		System.out.print("Digite a posição no grupo da Seleção: ");
				  		posicaoGrupo = entrada.nextInt();
				  		Selecao selecao = new Selecao();
				  		selecao.setNome(nome);
				  		selecao.setGrupo(grupo);
				  		selecao.setPosicaoGrupo(posicaoGrupo);
				  		selecaoDAO.create(selecao);
				  	case 5:
				  		int cont = 1;
				  		List<Selecao> listSelecoes = selecaoDAO.readAll();
				  		System.out.println("Essas são as Seleções inscritas:");
				  		for (Selecao selecaoIterator: listSelecoes) {
				  			System.out.println(cont + "-" + selecaoIterator.getNome());
				  		}
				  	  			  		
				  }
			  }while (opcao1 != 5);
			break;
			
		  case 2:
			  do {
				  System.out.println("   ┌───────────┐ ");
				  System.out.println("   │ Jogadores │ "); 
				  System.out.println("   └───────────┘ ");
				  System.out.println("Escolha uma opcao:");
				  System.out.println("1) Inserir");
				  System.out.println("2) Editar");
				  System.out.println("3) Excluir");
				  System.out.println("4) Listar Jogadores");
				  System.out.println("5) Voltar");
				  System.out.print("Opcao: ");
				  opcao2 = entrada.nextInt();
			  } while (opcao2 != 5);
	       	break;
	       	
		  case 3:
			  do {
				  System.out.println("   ┌──────────┐ ");
				  System.out.println("   │ Árbitros │ "); 
				  System.out.println("   └──────────┘ ");
				  System.out.println("Escolha uma opcao:");
				  System.out.println("1) Inserir");
				  System.out.println("2) Editar");
				  System.out.println("3) Excluir");
				  System.out.println("4) Listar");
				  System.out.println("5) Voltar");
				  System.out.print("Opcao: ");
				  opcao3 = entrada.nextInt();
			  } while (opcao3 != 5);
			break;
			
		  case 4:
			  do {
				  System.out.println("   ┌──────────┐ ");
				  System.out.println("   │ Técnicos │ "); 
				  System.out.println("   └──────────┘ ");
				  System.out.println("Escolha uma opcao:");
				  System.out.println("1) Inserir");
				  System.out.println("2) Editar");
				  System.out.println("3) Excluir");
				  System.out.println("4) Listar Tecnicos");
				  System.out.println("5) Voltar");
				  System.out.print("Opcao: ");
				  opcao4 = entrada.nextInt();
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
