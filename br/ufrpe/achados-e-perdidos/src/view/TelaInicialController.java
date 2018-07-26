package view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class TelaInicialController {

	private Main main;
	@FXML private Button btCadastrarItem;
	@FXML private Button btListarItens;
	
	
	public void initialize(){
		this.main = Main.getInstancia();	
			this.btCadastrarItem.setOnAction(e2 -> {
				main = Main.getInstancia();
				 Stage stage;
				 Parent root;	
				 try{
					 
					 stage=(Stage) btCadastrarItem.getScene().getWindow();
					 root = (Parent) FXMLLoader.load(getClass().getResource("/view/TelaCadastro.fxml"));
					 Scene scene = new Scene(root);
					 stage = main.getPalcoPrincipal();
					 stage.setScene(scene);
					 main.changeStage(stage);
				 }catch(IOException e3){
					 e3.printStackTrace(); 
				 }
				
			});
			
			
	}
}
