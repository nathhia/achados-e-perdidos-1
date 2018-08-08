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
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class TelaCadastroItemPerdidoController {private Main main;

@FXML private TextField tfTipo;
@FXML private TextField tfCor;
@FXML private TextField tfQuantidade;
@FXML private TextArea tAreaDescricao;
@FXML private Button btCadastrar;
@FXML private Button btVoltar;

public void initialize(){
	this.main = Main.getInstancia();
	this.btCadastrar.setOnAction(e ->{
		
		int cont=0;	
		Item itemTemp = new Item();
		Item itemPerdido = new Item();
		Gson gson = new Gson();
		String json;
		
		File arquivo1 = new File("cont.bin");
		File arquivo3 = new File("cadastrados.txt");
		
		
		try( FileReader fr = new FileReader(arquivo1) ){
		
			cont = fr.read();
		
		}catch(IOException ex){
		  ex.printStackTrace();
		}
		
				
		itemTemp.setTipo(tfTipo.getText());
		itemTemp.setCor(tfCor.getText());
		itemTemp.setQuantidade(Integer.parseInt(tfQuantidade.getText()));
		itemTemp.setDescricao(tAreaDescricao.getText());
		itemTemp.setId(cont+200-48);
		itemTemp.setPerdido(true);
		itemTemp.setAchado(false);
		itemPerdido.cadastrarItem(itemTemp);
		json = gson.toJson(itemPerdido);
		
		try{	
			FileWriter fwo = new FileWriter(arquivo3, true);
			BufferedWriter bwo = new BufferedWriter(fwo);
			bwo.write(json);
			bwo.newLine();
			bwo.close();
		    
		}catch(IOException ex){
		  ex.printStackTrace();
		}
		
		cont++;
		
		try( FileWriter fw = new FileWriter(arquivo1) ){
			
		    fw.write(cont);
		   
		    fw.flush();
		 //   fw.close();
		}catch(IOException ex){
		  ex.printStackTrace();
		}
		
		Alert alert = new Alert(AlertType.INFORMATION);
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
