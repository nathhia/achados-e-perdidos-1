package classes;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Item item = new Item();
		int opcao;
		System.out.println("Achados & perdidos");
		System.out.printf("1 - Cadastrar item perdido\n2 - Cadastrar item achado");
		
		opcao = scanner.nextInt();
		switch (opcao) 
		{
		case 1: 
			item.setPerdido(true);
			
		}
	}

}
