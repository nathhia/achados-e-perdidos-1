package classes;
import java.util.Scanner;
import java.util.Date;
import java.util.Collection; 
import java.util.ArrayList;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	private static void coletarDados(Item auxItem)
	{
		System.out.println("Tipo de item:");
		
		auxItem.setTipo(scanner.nextLine());
		auxItem.setTipo(scanner.nextLine());
		System.out.println("Cor:");
		
		auxItem.setCor(scanner.nextLine());
		System.out.println("Quantidade:");
		
		auxItem.setQuantidade(scanner.nextInt());
	
		System.out.println("Descrição:");
		auxItem.setDescricao(scanner.nextLine());
		auxItem.setDescricao(scanner.nextLine());
	}

	public static void main(String[] args) {
		int cont=0;	
		Item itemTemp = new Item();
		Item[] item = new Item[100];
		
		Integer opcao, aux;
		Date data = new Date();
		String info;
		Collection<Item> itens = new ArrayList();
		
		System.out.println("Achados & perdidos");
		System.out.printf("1 - Cadastrar item perdido\n2 - Cadastrar item achado\n3 - Listar itens cadastrados\n0 - Sair");
		opcao = scanner.nextInt();
		while (opcao != 0)
		{
			item[cont] = new Item();
			
			switch (opcao) 
			{
			case 1: 
				itemTemp.setPerdido(true);
				itemTemp.setAchado(false);
				coletarDados(itemTemp);
				item[cont].cadastrarItem(itemTemp);
				if (cont >0) item[cont].setId(item[cont-1].incrementaId());
				itens.add(item[cont]);
				cont++;
				break;
				
			case 2:
				itemTemp.setAchado(true);
				itemTemp.setPerdido(false);
				coletarDados(itemTemp);
				item[cont].cadastrarItem(itemTemp);
				if (cont >0) item[cont].setId(item[cont-1].incrementaId());
				itens.add(item[cont]);
				cont++;
				break;
			
			case 3:
				for(Item listaItens: itens)
				{
					listaItens.status();
				}
			}
			System.out.printf("1 - Cadastrar item perdido\n2 - Cadastrar item achado\n3 - Listar itens cadastrados\n0 - Sair");
			opcao = scanner.nextInt();
		}
		
		
		
	}

}