package controller;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import model.Item;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class Persistencia {
	Gson gson = new Gson();
	String json;
	
	
	public Item lerItem(String arq, int cont) {
		Collection<Item> listaItens = new ArrayList();
		Item item = new Item();
		try{
			BufferedReader br = new BufferedReader(new FileReader(arq));
			for(int i = 0; i<cont; i++) {
				json = new String();
				json = br.readLine();
				item = gson.fromJson(json, Item.class);

			}
			
		}catch(IOException ex){
		  ex.printStackTrace();
		}
		return item;
	}
	
	

}
