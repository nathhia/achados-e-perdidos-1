package view;

import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.io.BufferedWriter;
import java.io.BufferedReader;

import com.google.gson.Gson;

import model.Item;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class TelaCadastroItemPerdidoController {private Main main;

@FXML private TextField tfTipo;
@FXML private TextField tfCor;
@FXML private TextField tfQuantidade;
@FXML private TextField tfDescricao;
@FXML private Button btCadastrar;
@FXML private Button btVoltar;

public void initialize(){
	this.main = Main.getInstancia();
	this.btCadastrar.setOnAction(e ->{
		
		int contPerdido=0;	
		Item itemTemp = new Item();
		Item itemPerdido = new Item();
		Gson gson = new Gson();
		String json;
		
		File arquivo1 = new File("contPerdido.bin");
		File arquivo3 = new File("perdidos.json");
		
		
		try( FileReader fr = new FileReader(arquivo1) ){
		
			contPerdido = fr.read();
		
		}catch(IOException ex){
		  ex.printStackTrace();
		}
		
				
		itemTemp.setTipo(tfTipo.getText());
		itemTemp.setCor(tfCor.getText());
		itemTemp.setQuantidade(Integer.parseInt(tfQuantidade.getText()));
		itemTemp.setDescricao(tfDescricao.getText());
		itemTemp.setId(contPerdido+200);
		itemPerdido.cadastrarItem(itemTemp);
		json = gson.toJson(itemPerdido);
	
		
		try( FileWriter fw = new FileWriter(arquivo3, true) ){
			
				fw.write(json);
		
		    fw.flush();
		    fw.close();
		}catch(IOException ex){
		  ex.printStackTrace();
		}
		
		contPerdido++;
		
		try( FileWriter fw = new FileWriter(arquivo1) ){
			
		    fw.write(contPerdido);
		   
		    fw.flush();
		 //   fw.close();
		}catch(IOException ex){
		  ex.printStackTrace();
		}
		
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Cadastrado!");
		alert.setHeaderText("Cadastrado com sucesso!");
		alert.setContentText("");
		alert.showAndWait();
		this.retornar();		
		
	});
	this.btVoltar.setOnAction(e ->{
		this.retornar();
	});
}

public void retornar(){
		Stage stage;
		Parent root;
	try {
		root = (Parent) FXMLLoader.load(getClass().getResource("/view/TelaCadastro.fxml"));
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
