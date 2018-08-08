package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import model.Item;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaListarItensController {
	private Main main;

	
	@FXML private Button btVoltar;
	@FXML private TableView tbView;
	@FXML private TableColumn<Item, Integer> tcID;
	@FXML private TableColumn<Item, String> tcTipo;
	@FXML private TableColumn<Item, String> tcCor;
	@FXML private TableColumn<Item, Integer> tcQtd;
	@FXML private TableColumn<Item, String> tcDescricao = new TableColumn<Item, String>("Descricao");
	@FXML private ListView listView;
	@FXML private TextArea tAreaListar;

	
	public void initialize(){
		
		int cont = 0;
		File arquivo = new File("cont.bin");

		File arquivo2 = new File("cadastrados.txt");

		Gson gson = new Gson();
		Item[] itens = new Item[100]; 
		String json;
		Collection<Item> lista = new ArrayList();
		
		try( FileReader fr = new FileReader(arquivo) ){
			
			cont = fr.read();
			cont = cont-48;
			
		}catch(IOException ex){
		  ex.printStackTrace();
		}
		
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(arquivo2));
			for(int i = 0; i<cont; i++) {
				itens[i] = new Item();
				json = new String();
				json = br.readLine();
				itens[i] = gson.fromJson(json, Item.class);
				lista.add(itens[i]);
				System.out.println(json);
			}
			
		}catch(IOException ex){
		  ex.printStackTrace();
		}
		
		
		System.out.println(lista.size());
		this.tAreaListar.setText(itens[0].status());
		
		this.tcDescricao.setCellValueFactory(new PropertyValueFactory<Item, String>("Oi"));
		for(Item listaDosItens: lista) {
			//this.tcID.setText(listaDosItens.getId());
			//this.tcTipo.setText(listaDosItens.getTipo());
			//this.tcCor.setText(listaDosItens.getCor());
			//this.tcDescricao.setText(listaDosItens.getDescricao());
			this.tcDescricao.setCellValueFactory(new PropertyValueFactory<Item, String>(listaDosItens.getDescricao()));
			listaDosItens.status();
		
			
		}
		
	

		
		this.main = Main.getInstancia();
		this.btVoltar.setOnAction(e ->{
			this.retornar();
		});
	}
	
	public void retornar(){
			Stage stage;
			Parent root;
		try {
			root = (Parent) FXMLLoader.load(getClass().getResource("/view/TelaInicial.fxml"));
			Scene scene = new Scene(root);
			stage = main.getPalcoPrincipal();
			stage.setScene(scene);
			main.changeStage(stage);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
