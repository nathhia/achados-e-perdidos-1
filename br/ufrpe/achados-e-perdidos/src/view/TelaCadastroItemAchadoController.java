package view;

import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import com.google.gson.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;

import model.Item;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class TelaCadastroItemAchadoController {
	private Main main;

	@FXML private TextField tfTipo;
	@FXML private TextField tfCor;
	@FXML private TextField tfQuantidade;
	@FXML private TextField tfDescricao;
	@FXML private Button btCadastrar;
	@FXML private Button btVoltar;
	
	public void initialize(){
		this.main = Main.getInstancia();
		this.btCadastrar.setOnAction(e ->{

			Integer cont = 0;
			Item itemTemp = new Item();
			Item itemAchado = new Item();
			Gson gson = new Gson();
			String json;
			
			File arquivo = new File("cont.txt");
			File arquivo2 = new File("achados.txt");
			
			try( FileReader fr = new FileReader(arquivo) ){
				
				cont = fr.read();
			
			}catch(IOException ex){
			  ex.printStackTrace();
			}
			
					
			itemTemp.setTipo(tfTipo.getText());
			itemTemp.setCor(tfCor.getText());
			itemTemp.setQuantidade(Integer.parseInt(tfQuantidade.getText()));
			itemTemp.setDescricao(tfDescricao.getText());
			itemTemp.setId(cont);
			itemAchado.cadastrarItem(itemTemp);
			json = gson.toJson(itemAchado);
		
			
			try( FileWriter fw = new FileWriter(arquivo2, true) ){
			   
					fw.write(json);
				
			    fw.flush();
			    fw.close();
			}catch(IOException ex){
			  ex.printStackTrace();
			}
			
			cont++;
			
			try( FileWriter fw = new FileWriter(arquivo) ){
			//	char c = (char)cont;
			    fw.write(cont);
			   
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
