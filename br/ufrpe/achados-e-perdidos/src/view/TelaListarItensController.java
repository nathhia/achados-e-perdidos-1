package view;

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

public class TelaListarItensController {
	private Main main;

	
	@FXML private Button btVoltar;
	@FXML private TableView tbView;
	@FXML private TableColumn<Item, Integer> tcID;
	@FXML private TableColumn<Item, String> tcTipo;
	@FXML private TableColumn<Item, String> tcCor;
	@FXML private TableColumn<Item, Integer> tcQtd;
	@FXML private TableColumn<Item, String> tcDescricao;
	@FXML private ListView listView;

	
	public void initialize(){
		
		int contAchado = 0;
		int contPerdido = 0;
		File arquivo = new File("contAchado.bin");
		File arquivo1 = new File("contPerdido.bin");
		File arquivo2 = new File("achados.json");
		File arquivo3 = new File("perdidos.json");
		Gson gson = new Gson();
		Item[] itensAchados = new Item[100]; 
		Item[] itensPerdidos = new Item[100]; 
		String[] json = new String[100];
		Collection<Item> lista = new ArrayList();
		
		try( FileReader fr = new FileReader(arquivo) ){
			
			contAchado = fr.read();
			contAchado = contAchado-48;
			
		}catch(IOException ex){
		  ex.printStackTrace();
		}
		
		try( FileReader fr = new FileReader(arquivo1) ){
			
			contPerdido = fr.read();
			contPerdido = contAchado-48;
			
		}catch(IOException ex){
		  ex.printStackTrace();
		}
		
		try( FileReader fr = new FileReader(arquivo2) ){
			
			for(int i = 0; i<contAchado; i++) {
				
			//	json[i] = fr.getEncoding();
				itensAchados[i] = gson.fromJson(fr, Item.class);
				lista.add(itensAchados[i]);
				
			}
			
		}catch(IOException ex){
		  ex.printStackTrace();
		}
		
		try( FileReader fr = new FileReader(arquivo3) ){
			
			for(int i = 0; i<contAchado; i++) {
				
			//	json[i] = fr.getEncoding();
				itensPerdidos[i] = gson.fromJson(fr, Item.class);
				lista.add(itensPerdidos[i]);
				
			}
			
		}catch(IOException ex){
		  ex.printStackTrace();
		}
		
		
		for(Item listaDosItens: lista) {
			//this.tcID.setText(listaDosItens.getId());
			this.tcTipo.setText(listaDosItens.getTipo());
			this.tcCor.setText(listaDosItens.getCor());
			//this.tcDescricao.setText(listaDosItens.getDescricao());
			//this.tcDescricao.setCellFactory(Callback<, String>("descricaoProduto"));
			
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
