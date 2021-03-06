package controller;

import java.io.IOException;
import com.google.gson.*;
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
import model.*;

public class TelaLoginController {
	private Main main;
	@FXML private TextField tfLogin;
	@FXML private PasswordField pfSenha;
	@FXML private Button btEntrar;
	@FXML private Hyperlink hypCadastro;
	
	
	
	
	public void initialize(){
		this.main = Main.getInstancia();	
			this.hypCadastro.setOnAction(e2 -> {
				main = Main.getInstancia();
				 Stage stage;
				 Parent root;
				 Gson gson = new Gson();
				 Aluno[] alunoTemp = new Aluno[100];
				 
				 
				 try{
					 
					 stage=(Stage) hypCadastro.getScene().getWindow();
					 root = (Parent) FXMLLoader.load(getClass().getResource("/view/TelaCadastroUsuario.fxml"));
					 Scene scene = new Scene(root);
					 stage = main.getPalcoPrincipal();
					 stage.setScene(scene);
					 main.changeStage(stage);
				 }catch(IOException e3){
					 e3.printStackTrace(); 
				 }
				
			});
			this.btEntrar.setOnAction(e -> {
				main = Main.getInstancia();
				Stage stage;
				Parent root;
				if(tfLogin.getText().equals("")| pfSenha.getText().equals("")){
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Erro!");
					alert.setHeaderText("Login ou Senha invalidos!");
					alert.setContentText("");
					alert.showAndWait();
					this.retornar();
				}else {
				try {
					
					stage=(Stage) btEntrar.getScene().getWindow();
					root = (Parent) FXMLLoader.load(getClass().getResource("/view/TelaInicial.fxml"));
					Scene scene = new Scene(root);
					stage = main.getPalcoPrincipal();
					stage.setScene(scene);
					main.changeStage(stage);
				}catch(IOException e1) {
					e1.printStackTrace();
				}
			}
		});
			
			
	}
	
		public void retornar(){
			Stage stage;
			Parent root;
		try {
			root = (Parent) FXMLLoader.load(getClass().getResource("/view/TelaLogin.fxml"));
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
