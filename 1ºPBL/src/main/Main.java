package main;
import java.util.Scanner;

public class Main {
  public static void main(String[] args){
	  
	  int opcao;
	  Scanner entrada = new Scanner(System.in);
	  do {
		  System.out.println("   ┌─────────┐ ");
		  System.out.println("   │ SysCopa │ "); 
		  System.out.println("   └─────────┘ ");
		  System.out.println("Escolha uma opcao");
		  System.out.println("1) Selecao");
		  System.out.println("2) Jogadores");
		  System.out.println("3) Arbitros");
		  System.out.println("4) Tecnico");
		  System.out.println("5) Sair");
		  System.out.print("Opcao: ");
		  opcao = entrada.nextInt();
		  
		  switch (opcao) {
		  case 1:
			  System.out.println("   ┌─────────┐ ");
			  System.out.println("   │ Selecao │ "); 
			  System.out.println("   └─────────┘ ");
			break;
		  case 2:
			  System.out.println("   ┌───────────┐ ");
			  System.out.println("   │ Jogadores │ "); 
			  System.out.println("   └───────────┘ ");
	       	break;
		  case 3:
			  System.out.println("   ┌──────────┐ ");
			  System.out.println("   │ Arbitros │ "); 
			  System.out.println("   └──────────┘ ");
			break;
		  case 4:
			  System.out.println("   ┌─────────┐ ");
			  System.out.println("   │ Tecnico │ "); 
			  System.out.println("   └─────────┘ ");
			break;
		  case 5:
			System.out.println("Fim do programa!!!");
			break;
		  default:
			System.out.println("O número escolhido é inválido! Digite um número entre 1 a 5.");
		  }
		  // aqui vai utilizar um comando pra limpar o console (ainda não sei como vou fazer isso mas depois faço)
	  }while (opcao != 5);
	  
	  entrada.close();
  }
}
