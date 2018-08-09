package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TelaCadastroUsuarioController {
		private Main main;
		@FXML private Button btAluno;
		@FXML private Button btAdministrador;
		@FXML private Button btVoltar;
		
		public void initialize(){
			this.main = Main.getInstancia();	
				this.btAluno.setOnAction(e2 -> {
					main = Main.getInstancia();
					 Stage stage;
					 Parent root;
					 
					 try{
						 
						 stage=(Stage) btAluno.getScene().getWindow();
						 root = (Parent) FXMLLoader.load(getClass().getResource("/view/TelaCadastroAluno.fxml"));
						 Scene scene = new Scene(root);
						 stage = main.getPalcoPrincipal();
						 stage.setScene(scene);
						 main.changeStage(stage);
					 }catch(IOException e3){
						 e3.printStackTrace(); 
					 }
					
				});
				this.btAdministrador.setOnAction(e -> {
					main = Main.getInstancia();
					Stage stage;
					Parent root;
					try {
						
						stage=(Stage) btAdministrador.getScene().getWindow();
						root = (Parent) FXMLLoader.load(getClass().getResource("/view/TelaCadastroAdministrador.fxml"));
						Scene scene = new Scene(root);
						stage = main.getPalcoPrincipal();
						stage.setScene(scene);
						main.changeStage(stage);
					}catch(IOException e1) {
						e1.printStackTrace();
					}
				});
				this.btVoltar.setOnAction(e4 ->{
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
					
					
				});
				
				
		}
		
	}


